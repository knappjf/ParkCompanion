package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;

import info.jfknapp.parkcompanion.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginButton(View v){}

}
