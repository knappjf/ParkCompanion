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
    ArrayAdapter<String> adapter;
    String selected = null;
    List<String> taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new TasksPresenter(this);
        taskList = mPresenter.getTaskList();

        //Fetches the task list from the server
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                mPresenter.fetchTaskList();
//            }
//        }).start();


        adapter = new ArrayAdapter<String>(this, R.layout.task_item_view, taskList);



        setContentView(R.layout.activity_task_list);

        final ListView taskListView = (ListView) findViewById(R.id.task_listview);
        taskListView.setAdapter(adapter);

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
    }

    public void onEditButton(View v){
        Intent intent = new Intent(this, TaskEditActivity.class);
        intent.putExtra("task_name", selected);
        startActivity(intent);
        taskList = mPresenter.getTaskList();
        adapter.notifyDataSetChanged();
    }

    public void onCreateTaskButton(View v) {
        Intent intent = new Intent(this, TaskEditActivity.class);
        startActivity(intent);
    }

    //This doesn't work, don't know why
    public void onRefreshButton(View v) {
        taskList = mPresenter.getTaskList();
        adapter.notifyDataSetChanged();
    }
}
