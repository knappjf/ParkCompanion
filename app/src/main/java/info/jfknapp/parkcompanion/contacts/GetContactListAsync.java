package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import org.json.JSONArray;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.tasks.TaskListActivity;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class GetContactListAsync extends AsyncTask <Void, Void, String[]> {
    private Activity mActivity;
    private SharedPreferences mSettings;

    public GetContactListAsync(Activity activity){
        mActivity = activity;
        mSettings = activity.getSharedPreferences(Util.PREFS, Context.MODE_PRIVATE);
    }

    @Override
    protected String[] doInBackground(Void... params) {
        String[] result = null;

        StringBuilder sb = new StringBuilder();
        sb.append(mSettings.getString("address", mActivity.getResources().getString(R.string.default_address)));
        sb.append(mActivity.getResources().getString(R.string.default_server_file));
        String address = sb.toString();

        try{
            HttpRequest request = new HttpRequest(address, Util.CHARSET);
            request.addParam("command", "contact");
            request.addParam("option", "list");
            request.execute();

            if(request.getStatus().equals("Success")){
                Logger.log("Request completed successfully");

                if(request.getData() instanceof JSONArray){
                    JSONArray json = (JSONArray) request.getData();
                    result = new String[json.length()];

                    for(int i=0; i<result.length; i++){
                        result[i] = json.getString(i);
                    }
                }
            }
            else {
                Logger.log("Failed to get contacts list");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String[] strings) {
        super.onPostExecute(strings);

        if(mActivity instanceof ContactListActivity){
            ((ContactListActivity) mActivity).updateContactList(strings);
        }
    }
}
