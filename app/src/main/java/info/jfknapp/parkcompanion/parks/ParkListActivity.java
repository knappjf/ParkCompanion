package info.jfknapp.parkcompanion.parks;

import android.app.Activity;
import android.os.Bundle;

import info.jfknapp.parkcompanion.R;

public class ParkListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);
    }
}
