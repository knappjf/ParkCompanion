package info.jfknapp.parkcompanion.tasks;

import info.jfknapp.parkcompanion.util.Presenter;

public class TaskListPresenter extends Presenter {
    private TaskListActivity mActivity;

    public TaskListPresenter(TaskListActivity activity) {
        super(activity);
        mActivity = activity;
    }

    public void getTaskNames(){
        new GetNamesAsync(mActivity).execute();
    }
}
