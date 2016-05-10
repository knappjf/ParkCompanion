package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import info.jfknapp.parkcompanion.util.DatabaseHelper;
import info.jfknapp.parkcompanion.util.Presenter;

public class TasksPresenter extends Presenter{
    private List<String> taskList;
    private List<Task> tasks;
    private DatabaseHelper db;

    public TasksPresenter(Activity activity) {
        super(activity);
        db = new DatabaseHelper(activity);
        tasks = new ArrayList<>();

        taskList = db.getTaskList();

        for (String s : taskList) {
            tasks.add(db.getTask(s));
        }
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public void addTask(String name, String description, String park) {
        Task task = new Task(name, description, park);

        db.addTask(task);
        db.close();
    }

    public void deleteTask(String name) {
        db.deleteTask(name);
    }

    //Returns task if found, returns null if task not found
    public Task getTask(String name) {
        for (Task t : tasks) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    //This will be the method that fetches the task list from the server
    //It will remain empty until I figure out how to connect to the server
    public void fetchTaskList() {
    }

    //This will be the method that publishes the new/updated task to the server
    //It will remain empty until I figure out how to connect to the server
    public void pushChanges(Task t) {
    }
}