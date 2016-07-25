package info.jfknapp.parkcompanion.util;

import android.util.Log;

public class Logger {
    private static final String TAG = "[Park Companion]";

    public static void log(String message){
        Log.d(TAG, message);
    }
}
