package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.os.AsyncTask;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class CreateContactAsync extends AsyncTask <Contact, Void, Void> {
    private Activity mActivity;

    public CreateContactAsync(Activity activity){
        mActivity = activity;
    }

    @Override
    protected Void doInBackground(Contact... params) {
        Contact contact = params[0];

        try{
            HttpRequest request = new HttpRequest(Util.formAddress(mActivity), Util.CHARSET);
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
