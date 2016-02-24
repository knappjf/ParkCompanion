package info.jfknapp.parkcompanion.Settings;

/**
 * Created by Jeff on 2/23/2016.
 */
public interface Settings {
    public void setValue(String key, String value);
    public String getValue(String key);
}
