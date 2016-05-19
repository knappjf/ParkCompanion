package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import info.jfknapp.parkcompanion.R;

public class TaskDetailsActivity extends Activity {
    private Task mTask;
    private TextView mNameTextView;
    private TextView mDescriptionTextView;
    private TextView mParkTextView;
    private TasksPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        mPresenter = new TasksPresenter(this);

        mNameTextView = (TextView) findViewById(R.id.task_name_textview);
        mDescriptionTextView = (TextView) findViewById(R.id.task_description_textview);
        mParkTextView = (TextView) findViewById(R.id.task_park_textview);

//        Get task from extras
        Intent intent = getIntent();
        String taskName = intent.getStringExtra("task_name");
        mTask = mPresenter.getTask(taskName);

//        Set text to task details
        mNameTextView.setText(mTask.getName());
        mDescriptionTextView.setText(mTask.getDescription());
        mParkTextView.setText(mTask.getPark());
    }
}
