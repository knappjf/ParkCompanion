package info.jfknapp.parkcompanion.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Presenter {
    protected Activity mActivity;
    protected SharedPreferences mSettings;

    public Presenter(Activity activity){
        mActivity = activity;
        mSettings = mActivity.getSharedPreferences(Session.PREFS, Context.MODE_PRIVATE);
    }
}
