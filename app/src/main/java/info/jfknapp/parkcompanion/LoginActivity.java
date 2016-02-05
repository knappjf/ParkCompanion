package info.jfknapp.parkcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity{

    private final String sDummyUserName="test";
    private final String sDummyPassword="test";
    private EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        usernameField = (EditText) findViewById(R.id.usernameField);
        passwordField = (EditText) findViewById(R.id.passwordField);

        String sUsernameInput = usernameField.getText().toString();
        String sPasswordInput = passwordField.getText().toString();

        if(sUsernameInput.equals(sDummyUserName) && sPasswordInput.equals(sDummyPassword)){
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        this.finish();
    }
}
