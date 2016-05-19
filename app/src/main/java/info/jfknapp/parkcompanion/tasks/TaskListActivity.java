package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.jfknapp.parkcompanion.R;

public class TaskListActivity extends Activity {

    TasksPresenter mPresenter;
    ArrayAdapter<String> mAdapter;
    String selected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        mPresenter = new TasksPresenter(this);

        mAdapter = new ArrayAdapter<>(this, R.layout.task_item_view, mPresenter.getTaskList());

        final ListView taskListView = (ListView) findViewById(R.id.task_listview);
        taskListView.setAdapter(mAdapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = (String) taskListView.getItemAtPosition(position);
            }
        });
    }

    public void onDetailsButton(View v){
        Intent intent = new Intent(this, TaskDetailsActivity.class);
        intent.putExtra("task_name", selected);
        startActivity(intent);
        finish();
    }

    public void onEditButton(View v){
        Intent intent = new Intent(this, TaskEditActivity.class);
        intent.putExtra("task_name", selected);
        startActivity(intent);
        finish();
    }

    public void onCreateTaskButton(View v) {
        Intent intent = new Intent(this, TaskEditActivity.class);
        startActivity(intent);
        finish();
    }
}