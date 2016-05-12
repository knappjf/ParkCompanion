package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.menu.MainMenuActivity;
import info.jfknapp.parkcompanion.util.Session;

public class LoginActivity extends Activity {

    private LoginPresenter mPresenter;
    private EditText mUsernameField, mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameField = (EditText) findViewById(R.id.login_username_field);
        mPasswordField = (EditText) findViewById(R.id.login_password_field);

        mPresenter = new LoginPresenter(this);
    }

    public void onLoginButton(View v){
        final String username = mUsernameField.getText().toString();
        final String password = mPasswordField.getText().toString();

        mPresenter.login(username, password);
    }

    public void onSettingsButton(View v){
        navigateToLoginSettings();
    }

    public void navigateToMenu(){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        this.finish();
    }

    //For now, login settings won't be functional
    public void navigateToLoginSettings(){
        Intent intent = new Intent(this, LoginSettingsActivity.class);
        startActivity(intent);
    }

    public void onCreateUserButton(View v) {
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }

}
