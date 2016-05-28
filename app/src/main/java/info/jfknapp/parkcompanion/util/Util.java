package info.jfknapp.parkcompanion.util;

// Class used to provide static constants that must be available across different activities

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;

import info.jfknapp.parkcompanion.R;

public class Util {
    public static final String CHARSET = "UTF-8";
    public static final String PREFS = "parkcompanion_prefs";

//    Static method used to send simple string messages back to main thread
    public static void sendMessage(String result, Context context, String intentName){
        Intent intent = new Intent(intentName);
        intent.putExtra("result", result);

        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

//    Static method used to form the URL String for HttpRequest
//    If setting not found, returns default
    public static String formAddress(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREFS, context.MODE_PRIVATE);

        StringBuilder sb = new StringBuilder();
        sb.append(context.getResources().getString(R.string.default_protocol));
        sb.append(context.getResources().getString(R.string.default_address));
        sb.append(context.getResources().getString(R.string.default_server_file));

        return settings.getString("address", sb.toString());
    }
}
