package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import info.jfknapp.parkcompanion.R;

public class CreateTaskActivity extends Activity {
    private TaskCreatePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_create);
        mPresenter = new TaskCreatePresenter(this);
    }

    public void onSaveButton(View v){
        String name = ((EditText) findViewById(R.id.task_create_name_edittext)).getText().toString();
        String description = ((EditText) findViewById(R.id.task_create_description_edittext)).getText().toString();
        String park = ((EditText) findViewById(R.id.task_create_park_edittext)).getText().toString();
        Task task = new Task(name, description, park);
        mPresenter.createTask(task);
        finish();
    }
}
