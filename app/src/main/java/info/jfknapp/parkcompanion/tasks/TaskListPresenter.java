package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import info.jfknapp.parkcompanion.util.Presenter;

public class TaskListPresenter extends Presenter {
    private TaskListActivity mActivity;
    private List<String> mTaskList;

    //    Create receiver used to catch task list intent
    private BroadcastReceiver mListReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            for (String s : intent.getStringArrayExtra("result")) {
                mTaskList.add(s);
            }
        }
    };


    public TaskListPresenter(TaskListActivity activity) {
        super(activity);
        mActivity = activity;
        mTaskList = new ArrayList<>();
        fetchTasks();
    }

    private void fetchTasks() {

    }
}
