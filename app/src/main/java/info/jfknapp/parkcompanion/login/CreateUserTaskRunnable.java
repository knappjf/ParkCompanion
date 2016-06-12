package info.jfknapp.parkcompanion.login;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;

import java.io.IOException;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Util;

public class CreateUserTaskRunnable implements Runnable{
    private String mUsername;
    private String mPassword;
    private Context mContext;

    public CreateUserTaskRunnable(String username, String password, Context context){
        mUsername = username;
        mPassword = password;
        mContext = context;
    }

    @Override
    public void run() {
        try {
            HttpRequest request = new HttpRequest(Util.formAddress(mContext), Util.CHARSET);
            request.addParam("command", "user");
            request.addParam("option", "create");
            request.addParam("name", mUsername);
            request.addParam("password", mPassword);

            request.execute();

            if (request.getStatus().equals("Success")) {
                Util.sendMessage("Success", mContext, "create-user-intent");
            } else {
                Util.sendMessage("Failure", mContext, "create-user-intent");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
