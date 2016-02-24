package info.jfknapp.parkcompanion.Settings;

/**
 * Created by Jeff on 2/23/2016.
 */
public interface SettingsListener {
    void onSettingChange();
    void onSettingError(String error);
}
