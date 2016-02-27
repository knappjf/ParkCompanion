package info.jfknapp.parkcompanion.Settings;

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
            onSettingError(mSettings.SETTINGS_ERROR);
        }
    }

    @Override
    public void onSettingChange(){
        Log.d(this.TAG, mSettings.SETTINGS_SUCCESS);
        Log.d(this.TAG, "Server Address:" + mSettings.getValue(mSettings.SERVER_ADDRESS_STRING));
        Log.d(this.TAG, "Server Port:" + mSettings.getValue(mSettings.SERVER_PORT_STRING));
    }

    @Override
    public void onSettingError(String error){
        Log.d(this.TAG, error);
    }

    @Override
    public String debugSetting(String key){
        return mSettings.getValue(key);
    }
}