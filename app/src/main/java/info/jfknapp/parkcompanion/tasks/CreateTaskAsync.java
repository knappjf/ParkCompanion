package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class CreateTaskAsync extends AsyncTask <Task, Void, Void> {
    private Activity mActivity;
    private SharedPreferences mSettings;

    public CreateTaskAsync(Activity activity) {
        mActivity = activity;
        mSettings = mActivity.getSharedPreferences(Util.PREFS, Context.MODE_PRIVATE);
    }

    @Override
    protected Void doInBackground(Task... params) {
        Task task = params[0];

        //        Get server address from settings
        String address = mSettings.getString("address", mActivity.getResources().getString(R.string.default_address));
        address = address.concat(mActivity.getResources().getString(R.string.default_server_file));

        try{
            HttpRequest request = new HttpRequest(address, Util.CHARSET);
            request.addParam("command", "task");
            request.addParam("option", "create");
            request.addParam("name", task.getName());
            request.addParam("park", task.getPark());
            request.addParam("description", task.getDescription());
            request.execute();

            if(request.getStatus().equals("Success")){
                Logger.log("Successfully created task");
            }
            else{
                Logger.log("Failed to create task");
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
