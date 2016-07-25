package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class ContactEditActivity extends Activity {
    private ContactEditPresenter mPresenter;
    private String mContactName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);

        mPresenter = new ContactEditPresenter(this);
        mContactName = getIntent().getStringExtra("name");
        mPresenter.getContact(mContactName);
    }

    public void onSaveButton(View v){
        mPresenter.deleteContact(mContactName);

        String name = ((EditText) findViewById(R.id.contact_edit_name)).getText().toString();
        String phone = ((EditText) findViewById(R.id.contact_edit_phone)).getText().toString();
        String park = ((EditText) findViewById(R.id.contact_edit_park)).getText().toString();
        String title = ((EditText) findViewById(R.id.contact_edit_title)).getText().toString();
        mPresenter.createContact(new Contact(name, park, phone, title));

        finish();
    }

    public void onDeleteButton(View v){
        mPresenter.deleteContact(mContactName);
        finish();
    }
}
