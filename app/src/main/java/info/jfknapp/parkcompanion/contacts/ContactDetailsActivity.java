package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.os.Bundle;

import info.jfknapp.parkcompanion.R;

public class ContactDetailsActivity extends Activity {
    private ContactDetailsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        mPresenter = new ContactDetailsPresenter(this);

        String name = getIntent().getStringExtra("name");
        mPresenter.getContact(name);
    }
}
