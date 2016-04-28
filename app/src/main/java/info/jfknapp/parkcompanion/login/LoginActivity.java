package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.Session;

public class LoginActivity extends Activity {

    private LoginPresenter mPresenter;
    private EditText mUsernameField, mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameField = (EditText)findViewById(R.id.edit_text1);
        mPasswordField = (EditText)findViewById(R.id.edit_text2);

        mPresenter = new LoginPresenter(this);
    }

    public void onLoginButton(View v){
        String username = mUsernameField.getText().toString();
        String password = mPasswordField.getText().toString();
    }

    public void navigateToMenu(){
    }

}
