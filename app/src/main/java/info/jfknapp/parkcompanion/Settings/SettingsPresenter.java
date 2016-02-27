package info.jfknapp.parkcompanion.Settings;

/**
 * Created by Jeff on 2/23/2016.
 */
public interface SettingsPresenter {
    final String TAG = "[Park Companion]";

    void updateSetting(String key, String value);
    String debugSetting(String key);
}
