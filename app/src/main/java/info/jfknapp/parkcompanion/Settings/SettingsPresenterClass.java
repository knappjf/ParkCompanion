package info.jfknapp.parkcompanion.Settings;

import android.util.Log;

/**
 * Created by Jeff on 2/17/2016.
 */
public class SettingsPresenterClass implements SettingsPresenter, SettingsListener {
    private SettingsView mSettingsView;
    private Settings mSettings;

    private final String TAG = "[Park Companion]";

    public SettingsPresenterClass(SettingsView settingsView){
        this.mSettingsView = settingsView;
        this.mSettings = new SettingsClass(mSettingsView.getContext());
    }

    @Override
    public void updateSetting(String key, String value){
        this.mSettings.setValue(key, value);
    }

    @Override
    public void onSettingChange(){
        Log.d(this.TAG, "Setting Changed Successfully");
    }

    @Override
    public void onSettingError(String error){
        Log.d(this.TAG, "Error:" + error);
    }
}