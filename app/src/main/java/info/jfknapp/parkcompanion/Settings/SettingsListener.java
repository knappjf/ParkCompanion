package info.jfknapp.parkcompanion.settings;

/**
 * Created by Jeff on 2/23/2016.
 */
public interface SettingsListener {
    void onSettingChange();
    void onSettingError(String error);
}
