package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

public class TaskEditPresenter extends Presenter {
    private TaskEditActivity mActivity;

    public TaskEditPresenter(Activity activity) {
        super(activity);
        mActivity = (TaskEditActivity) activity;
    }

    public void getTask(String name) {
        new GetTaskAsync(mActivity).execute(name);
    }

    public void addTask(Task task) {
        new CreateTaskAsync(mActivity).execute(task);
    }

    public void deleteTask(String name) {
        new DeleteTaskAsync(mActivity).execute(name);
    }
}
