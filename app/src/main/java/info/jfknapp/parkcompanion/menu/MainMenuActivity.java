package info.jfknapp.parkcompanion.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.contacts.ContactListActivity;
import info.jfknapp.parkcompanion.tasks.TaskListActivity;

public class MainMenuActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onTasksButton(View v){
        Intent intent = new Intent(this, TaskListActivity.class);
        startActivity(intent);
    }

    public void onContactsButton(View v){
        Intent intent = new Intent(this, ContactListActivity.class);
        startActivity(intent);
    }


    public void onLogoutButton(View v) {
        finish();
    }
}
