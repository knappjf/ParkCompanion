package info.jfknapp.parkcompanion.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.Main.MainMenuActivity;
import info.jfknapp.parkcompanion.R;

public class LoginActivity extends Activity implements LoginView{

    private EditText mUsernameField, mPasswordField;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.presenter = new LoginPresenterClass(this);
    }

    public void onButtonPress(View view){
        mUsernameField = (EditText) findViewById(R.id.usernameField);
        mPasswordField = (EditText) findViewById(R.id.passwordField);

        String mUsername = mUsernameField.getText().toString();
        String mPassword = mPasswordField.getText().toString();


        presenter.checkUserCredentials(mUsername, mPassword);
        this.navigateToMain();
    }

    @Override
    public void onStop(){
        super.onStop();
        this.finish();
    }
    @Override
    public void navigateToMain(){
        Intent intent = new Intent(this, MainMenuActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}
