package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

public class TaskCreatePresenter extends Presenter{
    private CreateTaskActivity mActivity;

    public TaskCreatePresenter(Activity activity) {
        super(activity);
        mActivity = (CreateTaskActivity) activity;
    }

    public void createTask(Task task){
        new CreateTaskAsync(mActivity).execute(task);
    }
}
