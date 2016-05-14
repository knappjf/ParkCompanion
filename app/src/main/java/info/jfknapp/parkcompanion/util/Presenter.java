package info.jfknapp.parkcompanion.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import info.jfknapp.parkcompanion.R;

public class Presenter {
    protected Activity mActivity;
    protected SharedPreferences mSettings;

    public Presenter(Activity activity){
        mActivity = activity;
        mSettings = mActivity.getSharedPreferences(Util.PREFS, Context.MODE_PRIVATE);

        if(mSettings.getBoolean("first_run", true)){
            loadDefaults();
        }
    }

    private void loadDefaults(){
        SharedPreferences.Editor editor = mSettings.edit();

//        Ensures that defaults won't overwrite saved values in the future
        editor.putBoolean("first_run", false);

//        Load default server address
        editor.putString("address",mActivity.getResources().getString(R.string.default_address));

//        Commit values to settings
        editor.commit();
    }
}
