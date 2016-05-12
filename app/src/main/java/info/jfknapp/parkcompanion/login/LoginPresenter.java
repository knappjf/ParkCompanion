package info.jfknapp.parkcompanion.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.support.v4.content.LocalBroadcastManager;

import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Session;

public class LoginPresenter extends Presenter{

    private LoginActivity mActivity;
    private String mUsername;
    private String mPassword;

    public LoginPresenter(LoginActivity activity){
        super(activity);
        mActivity = activity;

        LocalBroadcastManager.getInstance(mActivity).registerReceiver(mReciever, new IntentFilter("login-event"));
    }

    private BroadcastReceiver mReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getStringExtra("result").equals("Success")) {
                onLoginSuccess();
            } else {
                onLoginFailure();
            }
        }
    };

    public void login(String username, String password){
        mUsername = username;
        mPassword = password;

        LoginTaskRunnable task = new LoginTaskRunnable(mUsername, mPassword, mActivity);
        new Thread(task).start();
    }

    private void onLoginSuccess() {
        Session.setUser(mUsername);

        Session.log("User logged in successfully");
        mActivity.navigateToMenu();
    }

    private void onLoginFailure() {
        Session.log("Failed to login");
    }
}
