package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.os.AsyncTask;

import org.json.JSONArray;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class GetNamesAsync extends AsyncTask <Void,Void,String[]> {
    private Activity mActivity;

    public GetNamesAsync(TaskListActivity activity){
        mActivity = activity;
    }

    @Override
    protected String[] doInBackground(Void... params) {
        String[] dataArray = null;

        try {
//            Execute http request
            HttpRequest request = new HttpRequest(Util.formAddress(mActivity), Util.CHARSET);
            request.addParam("command", "task");
            request.addParam("option", "list");
            request.execute();

//            Http request success
            if(request.getStatus().equals("Success")) {
                Logger.log("Successfully fetched task list");
                if (request.getData() instanceof JSONArray) {
//            Cast back to JSONArray
                    JSONArray data = (JSONArray) request.getData();

//            Store strings from JSONArray into String array
                    dataArray = new String[data.length()];

                    for (int i = 0; i < data.length(); i++) {
                        dataArray[i] = data.getString(i);
                    }
                }
            }

//            Http request failure
            else{
                Logger.log("Failed to fetch task list");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return dataArray;
    }

    @Override
    protected void onPostExecute(String[] strings) {
        super.onPostExecute(strings);

        if(mActivity instanceof TaskListActivity){
            ((TaskListActivity) mActivity).updateNamesList(strings);
        }
    }
}
