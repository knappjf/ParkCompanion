package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.jfknapp.parkcompanion.util.DatabaseHelper;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Util;

public class TasksPresenter extends Presenter {
    private Activity mActivity;
    private List<String> mTaskList;
    private Map<String, Task> mTasks;




    public TasksPresenter(Activity activity) {
        super(activity);
        mActivity = activity;

//        Populate list of task names
        mTaskList = new ArrayList<>();
        mTasks = new HashMap<>();
        fetchTasks();

//        Register broadcast receivers
        LocalBroadcastManager.getInstance(mActivity).registerReceiver(mListReceiver, new IntentFilter("listtasks-intent"));
        LocalBroadcastManager.getInstance(mActivity).registerReceiver(mGetReceiver, new IntentFilter("gettask-intent"));
    }

    public List<String> getTaskList(){
        return mTaskList;
    }

//    Searches the task list for task matching name and returns it
//    Returns null if task is not found
    public Task getTask(String name){
        if(mTasks.containsKey(name)){
            return mTasks.get(name);
        }
        return null;
    }

//    Private method which calls thread to fetch a task when given its name
    private void fetchTask(String name){
        HashMap<String, View> viewMap = new HashMap<>();
        viewMap.put("name",)

        GetTaskRunnable r = new GetTaskRunnable(name, mActivity);
        new Thread(r).start();
    }

//    Private method which calls thread to fetch list of task names
    private void fetchTasks(){
        FetchTasksRunnable task = new FetchTasksRunnable(mActivity);
        new Thread(task).start();
    }

//      Private method that adds items from result string array to the task list
    private void onTaskListReceive(String[] result){


        //        Populate list of tasks
        for(String s : mTaskList){
            fetchTask(s);
        }
    }
}