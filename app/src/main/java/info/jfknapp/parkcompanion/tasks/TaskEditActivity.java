package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.DatabaseHelper;

public class TaskEditActivity extends Activity {
    private TaskEditPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);

        Intent intent = getIntent();
        mPresenter = new TaskEditPresenter(this);
        mPresenter.getTask(intent.getStringExtra("task_name"));
    }

    public void onSaveButton(View v) {
//        String name = nameEditText.getText().toString();
//        String park = parkEditText.getText().toString();
//        String description = descriptionEditText.getText().toString();
//
//        if (edit) {
//            presenter.deleteTask(oldName);
//        }
//        presenter.addTask(name, description, park);


        finish();
    }
}
