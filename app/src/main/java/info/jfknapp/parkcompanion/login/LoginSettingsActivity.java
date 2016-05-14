package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class LoginSettingsActivity extends Activity {
    private EditText mAddressField;
    private LoginSettingsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_settings);
        mPresenter = new LoginSettingsPresenter(this);

        mAddressField = (EditText) findViewById(R.id.server_address_field);
    }

    public void onSaveButton(View v) {
        mPresenter.storeAddress(mAddressField.getText().toString());
        this.finish();
    }
}
