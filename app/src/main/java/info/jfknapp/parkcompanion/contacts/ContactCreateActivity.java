package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class ContactCreateActivity extends Activity{
    private ContactCreatePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_create);
        mPresenter = new ContactCreatePresenter(this);
    }

    public void onSaveButton(View v){
        String name = ((EditText) findViewById(R.id.contact_create_name)).getText().toString();
        String phone = ((EditText) findViewById(R.id.contact_create_phone)).getText().toString();
        String park = ((EditText) findViewById(R.id.contact_create_park)).getText().toString();
        String title = ((EditText) findViewById(R.id.contact_create_title)).getText().toString();

        Contact contact = new Contact(name, park, phone, title);
        mPresenter.createContact(contact);
        finish();
    }
}
