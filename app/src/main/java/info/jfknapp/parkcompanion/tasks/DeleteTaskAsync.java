package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class DeleteTaskAsync extends AsyncTask<String, Void, Void> {
    private Activity mActivity;

    public DeleteTaskAsync(Activity activity){
        mActivity = activity;
    }

    @Override
    protected Void doInBackground(String... params) {
        try{
            HttpRequest request = new HttpRequest(Util.formAddress(mActivity), Util.CHARSET);
            request.addParam("command", "task");
            request.addParam("option", "delete");
            request.addParam("name", params[0]);
            request.execute();

            if(request.getStatus().equals("Success")){
                Logger.log("Successfully deleted task");
            }
            else{
                Logger.log("Failed to delete task");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
