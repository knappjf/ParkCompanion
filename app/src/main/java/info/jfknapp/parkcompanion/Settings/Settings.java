package info.jfknapp.parkcompanion.Settings;

/**
 * Created by Jeff on 2/23/2016.
 */
public interface Settings {
    String SERVER_ADDRESS_STRING = "server_address";
    String SERVER_PORT_STRING = "server_port";
    String SETTINGS_ERROR = "Failed to Store Setting";
    String SETTINGS_SUCCESS = "Setting Changed Successfully";

    void setValue(String key, String value);
    String getValue(String key);
}
