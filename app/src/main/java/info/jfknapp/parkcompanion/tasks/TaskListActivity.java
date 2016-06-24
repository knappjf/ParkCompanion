package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import info.jfknapp.parkcompanion.R;

public class TaskListActivity extends Activity {

    TaskListPresenter mPresenter;
    ArrayAdapter mAdapter;
    String selected = null;
    List<String> mNamesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        mPresenter = new TaskListPresenter(this);
        mNamesList = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this, R.layout.list_item_view, mNamesList);

        final ListView taskListView = (ListView) findViewById(R.id.task_listview);
        taskListView.setAdapter(mAdapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = (String) taskListView.getItemAtPosition(position);
            }
        });

        mPresenter.getTaskNames();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getTaskNames();
    }

    public void onDetailsButton(View v){
        if (selected != null && mNamesList.contains(selected)) {
            Intent intent = new Intent(this, TaskDetailsActivity.class);
            intent.putExtra("task_name", selected);
            startActivity(intent);
        }
    }

    public void onEditButton(View v){
        if (selected != null && mNamesList.contains(selected)) {
            Intent intent = new Intent(this, TaskEditActivity.class);
            intent.putExtra("task_name", selected);
            startActivity(intent);
        }
    }

    public void onCreateTaskButton(View v) {
        Intent intent = new Intent(this, CreateTaskActivity.class);
        startActivity(intent);
    }

    public void updateNamesList(String[] names){
//        Clears name list if not empty
        if(!mNamesList.isEmpty()){
            mNamesList.clear();
        }

//        Copy elements of string array to list
        if (names != null) {
            for(String s : names){
                mNamesList.add(s);
            }
        }


        mAdapter.notifyDataSetChanged();
    }
}