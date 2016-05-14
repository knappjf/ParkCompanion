package info.jfknapp.parkcompanion.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Session;
import info.jfknapp.parkcompanion.util.Util;

public class CreateUserPresenter extends Presenter {
    private CreateUserActivity mActivity;

    public CreateUserPresenter(CreateUserActivity activity) {
        super(activity);
        mActivity = activity;

        LocalBroadcastManager.getInstance(mActivity).registerReceiver(mReciever, new IntentFilter("create-user-intent"));
    }

    private BroadcastReceiver mReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getStringExtra("result").equals("Success")) {
                onSuccess();
            } else {
                onFailure();
            }
        }
    };

    public void createUser(String username, String password) {
        CreateUserTaskRunnable task = new CreateUserTaskRunnable(username, password, mActivity);
        new Thread(task).start();
    }

    private void onSuccess(){
        Logger.log("Created user successfully");
        mActivity.finish();
    }

    private void onFailure(){
        Logger.log("Failed to create user");
        Logger.log("Failed to create user");
    }
}
