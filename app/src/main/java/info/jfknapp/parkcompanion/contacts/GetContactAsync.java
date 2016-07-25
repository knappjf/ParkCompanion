package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class GetContactAsync extends AsyncTask <String, Void, Contact> {
    private Activity mActivity;

    public GetContactAsync(Activity activity){
        mActivity = activity;
    }

    @Override
    protected Contact doInBackground(String... params) {
        Contact contact = null;

        try{
            HttpRequest request = new HttpRequest(Util.formAddress(mActivity), Util.CHARSET);
            request.addParam("command", "contact");
            request.addParam("option", "get");
            request.addParam("name", params[0]);
            request.execute();
            if(request.getStatus().equals("Success")) {
                Logger.log("Contact get executed successfully");

                if (request.getData() instanceof JSONObject) {
                    JSONObject result = (JSONObject) request.getData();

                    HashMap<String, String> map = new HashMap<>();
                    Iterator<String> iterator = result.keys();

                    while (iterator.hasNext()) {
                        String key = iterator.next();
                        map.put(key, result.getString(key));
                    }

                    contact = new Contact(result.getString("name"), result.getString("park"), result.getString("phone"), result.getString("position"));
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return contact;
    }

    @Override
    protected void onPostExecute(Contact contact) {
        super.onPostExecute(contact);

        if(mActivity instanceof ContactDetailsActivity){
            TextView nameText = (TextView) mActivity.findViewById(R.id.contact_details_name_text);
            TextView phoneText = (TextView) mActivity.findViewById(R.id.contact_details_phone_text);
            TextView parkText = (TextView) mActivity.findViewById(R.id.contact_details_park_text);
            TextView titleText = (TextView) mActivity.findViewById(R.id.contact_details_position_text);

            nameText.setText(contact.getName());
            phoneText.setText(contact.getPhone());
            parkText.setText(contact.getPark());
            titleText.setText(contact.getTitle());
        }

        else if(mActivity instanceof ContactEditActivity){
            EditText name = (EditText) mActivity.findViewById(R.id.contact_edit_name);
            EditText phone = (EditText) mActivity.findViewById(R.id.contact_edit_phone);
            EditText park = (EditText) mActivity.findViewById(R.id.contact_edit_park);
            EditText title = (EditText) mActivity.findViewById(R.id.contact_edit_title);

            name.setText(contact.getName());
            phone.setText(contact.getPhone());
            park.setText(contact.getPark());
            title.setText(contact.getTitle());
        }
    }
}
