package info.jfknapp.parkcompanion.parks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import info.jfknapp.parkcompanion.R;

public class ParkListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);
    }

    public void onDetailsButton(View v){
        Intent intent = new Intent(this, ParkDetailsActivity.class);
        startActivity(intent);
    }

    public void onEditButton(View v){
        Intent intent = new Intent(this, ParkEditActivity.class);
        startActivity(intent);
    }
}
