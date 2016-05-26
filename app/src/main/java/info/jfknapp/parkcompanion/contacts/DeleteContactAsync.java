package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class DeleteContactAsync extends AsyncTask <String, Void, Void> {
    private Activity mActivity;
    private SharedPreferences mSettings;

    public DeleteContactAsync(Activity activity){
        mActivity = activity;
        mSettings = mActivity.getSharedPreferences(Util.PREFS,Activity.MODE_PRIVATE);
    }

    @Override
    protected Void doInBackground(String... params) {
        //        Get server address from settings
        String address = mSettings.getString("address", mActivity.getResources().getString(R.string.default_address));
        address = address.concat(mActivity.getResources().getString(R.string.default_server_file));

        try{
            HttpRequest request = new HttpRequest(address, Util.CHARSET);
            request.addParam("command", "contact");
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
