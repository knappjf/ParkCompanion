package info.jfknapp.parkcompanion.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.communication.CommunicationActivity;
import info.jfknapp.parkcompanion.info.InfoActivity;
import info.jfknapp.parkcompanion.login.LoginActivity;
import info.jfknapp.parkcompanion.settings.SettingsActivity;
import info.jfknapp.parkcompanion.tasks.TasksActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    
    public void onLoginButton(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    public void onSettingsButton(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        this.startActivity(intent);
    }

    public void onTasksButton(View view){
        Intent intent = new Intent(this, TasksActivity.class);
        this.startActivity(intent);
    }

    public void onCommButton(View view){
        Intent intent = new Intent(this, CommunicationActivity.class);
        this.startActivity(intent);
    }

    public void onInfoButton(View view){
        Intent intent = new Intent(this, InfoActivity.class);
        this.startActivity(intent);
    }
}