package info.jfknapp.parkcompanion.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jeff on 2/17/2016.
 */
public class SettingsClass implements Settings {
    private final String DEFAULT_VALUE = "Default";
    private SharedPreferences mSharedPreferences;

    public SettingsClass(Context context){
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void setValue(String key, String value){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public String getValue(String key){
        return this.mSharedPreferences.getString(key, this.DEFAULT_VALUE);
    }
}
