package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class CreateUserActivity extends Activity {
    private CreateUserPresenter mPresenter;
    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        mPresenter = new CreateUserPresenter(this);
        usernameField = (EditText) findViewById(R.id.create_username);
        passwordField = (EditText) findViewById(R.id.create_password);
    }

    public void onCreateUserButton(View v) {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        mPresenter.createUser(username, password);

        this.finish();
    }
}
