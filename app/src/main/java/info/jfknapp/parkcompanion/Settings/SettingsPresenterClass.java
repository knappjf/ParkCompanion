package info.jfknapp.parkcompanion.settings;

import android.util.Log;

/**
 * Created by Jeff on 2/17/2016.
 */
public class SettingsPresenterClass implements SettingsPresenter, SettingsListener {
    private SettingsView mSettingsView;
    private Settings mSettings;

    public SettingsPresenterClass(SettingsView settingsView){
        this.mSettingsView = settingsView;
        this.mSettings = new SettingsClass(mSettingsView.getContext());
    }

    @Override
    public void updateSetting(String key, String value){
        mSettings.setValue(key, value);

        if(mSettings.getValue(key) == value){
            onSettingChange();
        }
        else{
            onSettingError(Settings.SETTINGS_ERROR);
        }
    }

    @Override
    public void onSettingChange(){
        Log.d(TAG, Settings.SETTINGS_SUCCESS);
        Log.d(TAG, "Server Address:" + mSettings.getValue(Settings.SERVER_ADDRESS_STRING));
        Log.d(TAG, "Server Port:" + mSettings.getValue(Settings.SERVER_PORT_STRING));
    }

    @Override
    public void onSettingError(String error){
        Log.d(TAG, error);
    }

    @Override
    public String debugSetting(String key){
        return mSettings.getValue(key);
    }
}