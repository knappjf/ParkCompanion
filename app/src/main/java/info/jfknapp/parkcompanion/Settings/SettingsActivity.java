package info.jfknapp.parkcompanion.Settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class SettingsActivity extends Activity implements SettingsView {
    private SettingsPresenter presenter;
    private EditText mServerAddressField, mServerPortField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.presenter = new SettingsPresenterClass(this);
    }

    public void onSaveButton(View view){
        mServerAddressField = (EditText) this.findViewById(R.id.editText);
        mServerPortField = (EditText) this.findViewById(R.id.editText2);

        presenter.updateSetting(Settings.SERVER_ADDRESS_STRING, mServerAddressField.getText().toString());
        presenter.updateSetting(Settings.SERVER_PORT_STRING, mServerPortField.getText().toString());

        //this.finish();
    }

    public void onCancelButton(View view){
        this.finish();
    }

    public void debug(View view){
        Log.d(presenter.TAG, "Server Address:" + presenter.debugSetting(Settings.SERVER_ADDRESS_STRING));
        Log.d(presenter.TAG, "Server Port:" + presenter.debugSetting(Settings.SERVER_PORT_STRING));
    }

    @Override
    public Context getContext(){
        return this;
    }
}