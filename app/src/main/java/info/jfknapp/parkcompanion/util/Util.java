package info.jfknapp.parkcompanion.util;

// Class used to provide static constants that must be available across different activities

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class Util {
    public static final String CHARSET = "UTF-8";
    public static final String PREFS = "parkcompanion_prefs";

//    Static method used to send simple string messages back to main thread
    public static void sendMessage(String result, Context context, String intentName){
        Intent intent = new Intent(intentName);
        intent.putExtra("result", result);

        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
