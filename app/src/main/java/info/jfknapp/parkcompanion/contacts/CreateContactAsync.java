package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class CreateContactAsync extends AsyncTask <Contact, Void, Void> {
    private Activity mActivity;
    private SharedPreferences mSettings;

    public CreateContactAsync(Activity activity){
        mActivity = activity;
        mSettings = mActivity.getSharedPreferences(Util.PREFS, Activity.MODE_PRIVATE);
    }

    @Override
    protected Void doInBackground(Contact... params) {
        Contact contact = params[0];

        //        Get server address from settings
        String address = mSettings.getString("address", mActivity.getResources().getString(R.string.default_address));
        address = address.concat(mActivity.getResources().getString(R.string.default_server_file));

        try{
            HttpRequest request = new HttpRequest(address, Util.CHARSET);
            request.addParam("command", "contact");
            request.addParam("option", "create");
            request.addParam("name", contact.getName());
            request.addParam("phone", contact.getPhone());
            request.addParam("park", contact.getPark());
            request.addParam("position", contact.getTitle());
            request.execute();

            if(request.getStatus().equals("Success")){
                Logger.log("Successfully created contact");
            }
            else{
                Logger.log("Failed to create contact");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
}
