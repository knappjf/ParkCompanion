package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.jfknapp.parkcompanion.util.DatabaseHelper;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Util;

public class TasksPresenter extends Presenter {
    private TaskListActivity mActivity;
    private List<String> mTaskList;

    public TasksPresenter(TaskListActivity activity) {
        super(activity);
        mActivity = activity;
        mTaskList = new ArrayList<>();
        fetchTasks();
        LocalBroadcastManager.getInstance(mActivity).registerReceiver(mReciever, new IntentFilter("listtasks-intent"));
    }

    private void fetchTasks(){
        FetchTasksRunnable task = new FetchTasksRunnable(mActivity);
        new Thread(task).start();
    }

    private BroadcastReceiver mReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            onTaskListRecieve(intent.getStringArrayExtra("result"));
        }
    };

    public List<String> getTaskList(){
        return mTaskList;
    }

    public Task getTask(String name){return null;}

    public void addTask(Task task){}

    public void deleteTask(String name){}

//    Private method that adds items from result string array to the task list
    private void onTaskListRecieve(String[] result){
        for (String s : result) {
            mTaskList.add(s);
        }
    }
}