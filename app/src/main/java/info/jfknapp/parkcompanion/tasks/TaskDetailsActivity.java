package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import info.jfknapp.parkcompanion.R;

public class TaskDetailsActivity extends Activity {

    private TaskDetailsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        mPresenter = new TaskDetailsPresenter(this);

//        Get task from extras
        Intent intent = getIntent();
        String taskName = intent.getStringExtra("task_name");

        mPresenter.getTask(taskName);
    }
}