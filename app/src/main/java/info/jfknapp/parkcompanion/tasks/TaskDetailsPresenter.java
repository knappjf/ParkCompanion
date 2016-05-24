package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

public class TaskDetailsPresenter extends Presenter {
    private TaskDetailsActivity mActivity;

    public TaskDetailsPresenter(Activity activity) {
        super(activity);
        mActivity = (TaskDetailsActivity) activity;
    }

    public void getTask(String name){
        new GetTaskAsync(mActivity).execute(name);
    }
}
