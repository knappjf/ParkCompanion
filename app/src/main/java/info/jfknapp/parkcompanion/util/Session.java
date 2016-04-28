package info.jfknapp.parkcompanion.util;

import android.util.Log;


/**
 * Created by Jeff on 4/25/2016.
 */
public class Session {
    private static final String TAG = "[Park Companion]";
    public static final String PREFS = "parkcompanion_prefs";

    private static String currentUser;


    public static void log(String message){
        Log.d(TAG, message);
    }

    public static void setUser(String user){
        currentUser=user;
    }

    public static String getUser(){
        return currentUser;
    }

}