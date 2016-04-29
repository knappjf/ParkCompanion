package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.os.Bundle;

import info.jfknapp.parkcompanion.R;


public class TaskListActivity extends Activity {
    TasksPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new TasksPresenter(this);
        setContentView(R.layout.activity_task_list);
    }
}
