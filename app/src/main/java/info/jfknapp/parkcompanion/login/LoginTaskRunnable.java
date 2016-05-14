package info.jfknapp.parkcompanion.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Util;

public class LoginTaskRunnable implements Runnable {
    private String mUsername;
    private String mPassword;
    private Context mContext;
    private SharedPreferences mSettings;

    public LoginTaskRunnable(String username, String password, Context context) {
        mUsername = username;
        mPassword = password;
        mContext = context;
        mSettings = context.getSharedPreferences(Util.PREFS, Context.MODE_PRIVATE);
    }

    @Override
    public void run() {
        try {
            String address = mSettings.getString("address", mContext.getResources().getString(R.string.default_address));
            address = address.concat(mContext.getResources().getString(R.string.default_server_file));

            HttpRequest request = new HttpRequest(address, Util.CHARSET);
            request.addParam("username", mUsername);
            request.addParam("password", mPassword);
            request.addParam("command", "login");

            request.execute();

            if (request.getStatus().equals("Success")) {
                sendMessage("Success");
            } else {
                sendMessage("Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String result) {
        Intent intent = new Intent("login-event");
        intent.putExtra("result", result);

        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
    }
}
