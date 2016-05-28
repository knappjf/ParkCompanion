package info.jfknapp.parkcompanion.login;

import android.content.Context;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Util;

public class LoginTaskRunnable implements Runnable {
    private String mUsername;
    private String mPassword;
    private Context mContext;

    public LoginTaskRunnable(String username, String password, Context context) {
        mUsername = username;
        mPassword = password;
        mContext = context;
    }

    @Override
    public void run() {
        try {
            HttpRequest request = new HttpRequest(Util.formAddress(mContext), Util.CHARSET);
            request.addParam("username", mUsername);
            request.addParam("password", mPassword);
            request.addParam("command", "login");

            request.execute();

            if (request.getStatus().equals("Success")) {
                Util.sendMessage("Success", mContext, "login-intent");
            } else {
                Util.sendMessage("Failure", mContext, "login-intent");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
