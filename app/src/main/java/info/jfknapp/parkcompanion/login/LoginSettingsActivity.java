package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class LoginSettingsActivity extends Activity {
    private EditText addressField;
    private EditText portField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_settings);

        addressField = (EditText) findViewById(R.id.server_address_field);
        portField = (EditText) findViewById(R.id.server_port_field);
    }

    public void onSave(View v) {
        String address = addressField.getText().toString();
        String port = portField.getText().toString();
    }
}
