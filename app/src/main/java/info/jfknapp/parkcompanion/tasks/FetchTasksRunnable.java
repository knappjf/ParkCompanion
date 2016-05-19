package info.jfknapp.parkcompanion.tasks;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class FetchTasksRunnable implements Runnable {
    private Context mContext;
    private SharedPreferences mSettings;


    public FetchTasksRunnable(Context context){
        mContext = context;
        mSettings = mContext.getSharedPreferences(Util.PREFS, Context.MODE_PRIVATE);
    }

    @Override
    public void run() {
        try {
            String address = mSettings.getString("address", mContext.getResources().getString(R.string.default_address));
            address = address.concat(mContext.getResources().getString(R.string.default_server_file));

            HttpRequest request = new HttpRequest(address, Util.CHARSET);
            request.addParam("command", "task");
            request.addParam("option", "list");
            request.execute();

            if(request.getStatus().equals("Success")){
                onSuccess(request);
                Logger.log("Successfully fetched task list");
            }
            else{
                Logger.log("Failed to fetch task list");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

//    Private method that determines whether data object is JSONArray or JSONObject
//    and sends an appropriately structured intent for either case
    private void onSuccess(HttpRequest request){
        if(request.getData() instanceof JSONArray){
//            Cast back to JSONArray
            JSONArray data = (JSONArray)request.getData();

//            Store strings from JSONArray into String array
            String[] dataArray = new String[data.length()];

            for(int i=0; i < data.length(); i++){
                try {
                    dataArray[i] = data.getString(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

//            Store dataArray in intent and broadcast it
            Intent intent = new Intent("listtasks-intent"); //ToDo:Store this as a constant somewhere
            intent.putExtra("result", dataArray);
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
        }
    }
}
