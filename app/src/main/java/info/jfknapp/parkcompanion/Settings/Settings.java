package info.jfknapp.parkcompanion.Settings;

/**
 * Created by Jeff on 2/23/2016.
 */
public interface Settings {
    final String SERVER_ADDRESS_STRING = "server_address";
    final String SERVER_PORT_STRING = "server_port";
    final String SETTINGS_ERROR = "Failed to Store Setting";
    final String SETTINGS_SUCCESS = "Setting Changed Successfully";

    void setValue(String key, String value);
    String getValue(String key);
}
