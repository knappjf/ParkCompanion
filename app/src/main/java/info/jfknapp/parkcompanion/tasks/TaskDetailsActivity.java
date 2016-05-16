package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import info.jfknapp.parkcompanion.R;

public class TaskDetailsActivity extends Activity {
    private TasksPresenter presenter;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
//        presenter = new TasksPresenter(this);
//
//
//        TextView nameTextView = (TextView) findViewById(R.id.task_name_textview);
//        TextView descriptionTextView = (TextView) findViewById(R.id.task_description_textview);
//        TextView parkTextView = (TextView) findViewById(R.id.task_park_textview);
//
//        Bundle extras = getIntent().getExtras();
//
//        if (extras != null) {
//            String taskName = extras.getString("task_name");
//            task = presenter.getTask(taskName);
//
//            nameTextView.setText(task.getName());
//            descriptionTextView.setText(task.getDescription());
//            parkTextView.setText(task.getPark());
//        }
    }

    public void onDeleteButton(View v) {
        presenter.deleteTask(task.getName());
        finish();
    }
}
