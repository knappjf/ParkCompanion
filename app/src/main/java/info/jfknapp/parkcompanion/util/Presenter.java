package info.jfknapp.parkcompanion.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jeff on 4/25/2016.
 */
public class Presenter {
    protected Activity mActivity;
    protected SharedPreferences mSettings;

    public Presenter(Activity activity){
        mActivity = activity;
        mSettings = mActivity.getSharedPreferences(Session.PREFS, Context.MODE_PRIVATE);
    }
}
