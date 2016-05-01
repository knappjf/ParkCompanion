package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import info.jfknapp.parkcompanion.R;


public class TaskListActivity extends Activity {
    TasksPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new TasksPresenter(this);
        setContentView(R.layout.activity_task_list);
    }

    public void onDetailsButton(View v){
        Intent intent = new Intent(this, TaskDetailsActivity.class);
        startActivity(intent);
    }

    public void onEditButton(View v){
        Intent intent = new Intent(this, TaskEditActivity.class);
        startActivity(intent);
    }
}
