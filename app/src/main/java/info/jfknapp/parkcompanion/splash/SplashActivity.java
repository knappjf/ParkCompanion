package info.jfknapp.parkcompanion.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.login.LoginActivity;

public class SplashActivity extends Activity implements SplashView{
    private final String TAG = "[Park Companion]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void initialize(){
        Log.d(TAG, "Initializing application");
    }

    public void onLoginButton(View v){
        Log.d(TAG, "Login button pressed");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
