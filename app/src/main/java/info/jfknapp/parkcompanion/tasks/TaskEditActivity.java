package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.DatabaseHelper;

public class TaskEditActivity extends Activity {
    private TaskEditPresenter mPresenter;
    private String mTaskName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);

        Intent intent = getIntent();
        mTaskName = intent.getStringExtra("task_name");
        mPresenter = new TaskEditPresenter(this);
        mPresenter.getTask(mTaskName);
    }

    public void onSaveButton(View v) {
        EditText name = (EditText) findViewById(R.id.task_park_edittext);
        EditText park = (EditText) findViewById(R.id.task_park_edittext);
        EditText description = (EditText) findViewById(R.id.task_description_edittext);

        mPresenter.deleteTask(mTaskName);

        Task task = new Task(name.getText().toString(), description.getText().toString(), park.getText().toString());
        mPresenter.addTask(task);
        finish();
    }
}
