package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class CreateUserActivity extends Activity {
    private CreateUserPresenter presenter;
    private String username;
    private String password;
    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        presenter = new CreateUserPresenter(this);
        usernameField = (EditText) findViewById(R.id.create_username);
        passwordField = (EditText) findViewById(R.id.create_password);
    }

    public void onCreateUserButton(View v) {
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();

        new Thread(new Runnable() {
            public void run() {
                presenter.createUser(username, password);
            }
        }
        ).start();

        this.finish();
    }
}
