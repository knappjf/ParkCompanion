package info.jfknapp.parkcompanion.settings;

/**
 * Created by Jeff on 2/23/2016.
 */
public interface SettingsPresenter {
    String TAG = "[Park Companion]";

    void updateSetting(String key, String value);
    String debugSetting(String key);
}
