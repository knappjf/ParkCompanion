package info.jfknapp.parkcompanion.login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.Util;

public class LoginSettingsActivity extends Activity {
    private EditText mAddressField;
    private LoginSettingsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_settings);

        mPresenter = new LoginSettingsPresenter(this);
        mAddressField = (EditText) findViewById(R.id.server_address_field);

        SharedPreferences settings = getSharedPreferences(Util.PREFS, MODE_PRIVATE);

        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.default_protocol));
        sb.append(getResources().getString(R.string.default_address));
        String defaultAddress = sb.toString();

        mAddressField.setText(settings.getString("address", defaultAddress));
    }

    public void onSaveButton(View v) {
        mPresenter.storeAddress(mAddressField.getText().toString());
        this.finish();
    }
}
