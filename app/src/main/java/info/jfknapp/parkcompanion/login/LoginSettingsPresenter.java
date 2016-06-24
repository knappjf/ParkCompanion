package info.jfknapp.parkcompanion.login;

import android.content.SharedPreferences;

import info.jfknapp.parkcompanion.util.Presenter;

public class LoginSettingsPresenter extends Presenter{
    private LoginSettingsActivity mActivity;

    public LoginSettingsPresenter(LoginSettingsActivity activity) {
        super(activity);
        mActivity = activity;
    }

    public void storeAddress(String address){
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString("address", address);
        editor.commit();
    }
}
