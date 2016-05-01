package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import info.jfknapp.parkcompanion.R;

public class ContactListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
    }

    public void onDetailsButton(View v){
        Intent intent = new Intent(this, ContactDetailsActivity.class);
        startActivity(intent);
    }

    public void onEditButton(View v){
        Intent intent = new Intent(this, ContactEditActivity.class);
        startActivity(intent);
    }
}
