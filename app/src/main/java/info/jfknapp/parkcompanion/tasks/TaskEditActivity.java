package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.DatabaseHelper;

public class TaskEditActivity extends Activity {
    private TasksPresenter presenter;
    private DatabaseHelper db;
    EditText nameEditText;
    EditText parkEditText;
    EditText descriptionEditText;
    boolean edit;   //false means we are creating a new task
    private String oldName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TasksPresenter(this);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_task_edit);


        nameEditText = (EditText) findViewById(R.id.task_name_edittext);
        parkEditText = (EditText) findViewById(R.id.task_park_edittext);
        descriptionEditText = (EditText) findViewById(R.id.task_description_edittext);

        Bundle extras = getIntent().getExtras();
        edit = false;
        if (extras != null) {
            oldName = extras.getString("task_name");
            Task task = db.getTask(oldName);

            nameEditText.setText(task.getName());
            parkEditText.setText(task.getPark());
            descriptionEditText.setText(task.getDescription());
            edit = true;
        }

    }

    public void onSaveButton(View v) {
        String name = nameEditText.getText().toString();
        String park = parkEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        if (edit) {
            presenter.deleteTask(oldName);
        }
        presenter.addTask(name, description, park);


        finish();
    }
}
