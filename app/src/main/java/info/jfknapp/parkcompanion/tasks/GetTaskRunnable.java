package info.jfknapp.parkcompanion.tasks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class GetTaskRunnable implements Runnable{
    private String mName;
    private Context mContext;
    private SharedPreferences mSettings;
    private Handler mHandler;
    private Map<String, View> mViewMap;

    public GetTaskRunnable(String name, Context context, Map<String, View> viewMap) {
        mName = name;
        mContext = context;
        mSettings = mContext.getSharedPreferences(Util.PREFS, Context.MODE_PRIVATE);
        mHandler = new Handler(mContext.getMainLooper());
        mViewMap = viewMap;
    }

    @Override
    public void run() {
//        Get server address from settings
        String address = mSettings.getString("address", mContext.getResources().getString(R.string.default_address));
        address = address.concat(mContext.getResources().getString(R.string.default_server_file));

        try {
            HttpRequest request = new HttpRequest(address, Util.CHARSET);
            request.addParam("command", "task");
            request.addParam("option", "get");
            request.addParam("name", mName);
            request.execute();

            if(request.getStatus().equals("Success")){
                onSuccess(request);
            }
            else{
                onFailure();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void onSuccess(HttpRequest request){
        Logger.log("Successfully fetched task information");

        if(request.getData() instanceof JSONObject){
            JSONObject data = (JSONObject)request.getData();

//            Store data as hash map
            HashMap<String, String> map = new HashMap<>();
            Iterator<String> iterator = data.keys();

            while(iterator.hasNext()){
                String key = iterator.next();
                try {
                    map.put(key, data.getString(key));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

//            Create and send an intent with map as extra
            Intent intent = new Intent("gettask-intent");   //ToDo:Store this as a constant somewhere
            intent.putExtra("result", map);
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
        }
    }

    private void onFailure(){
        Logger.log("Failed to get task information");
    }
}
