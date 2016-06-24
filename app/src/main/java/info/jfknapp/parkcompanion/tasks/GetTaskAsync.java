package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

import info.jfknapp.parkcompanion.R;
import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class GetTaskAsync extends AsyncTask<String, Void, Task> {
    private Activity mActivity;
    private SharedPreferences mSettings;

    public GetTaskAsync(Activity activity){
        mActivity = activity;
    }

    @Override
    protected Task doInBackground(String... params) {
        Task task = null;
        String taskName = params[0];

        try{
            HttpRequest request = new HttpRequest(Util.formAddress(mActivity), Util.CHARSET);
            request.addParam("command", "task");
            request.addParam("option", "get");
            request.addParam("name", taskName);
            request.execute();

            if(request.getStatus().equals("Success")){
                Logger.log("Task get executed successfully");

                if (request.getData() instanceof JSONObject) {
                    JSONObject result = (JSONObject) request.getData();

                    HashMap<String, String> map = new HashMap<>();
                    Iterator<String> iterator = result.keys();

                    while(iterator.hasNext()){
                        String key = iterator.next();
                        map.put(key, result.getString(key));
                    }

                    task = new Task(result.getString("name"), result.getString("description"), result.getString("park"));
                }
            }

            else{
                Logger.log("Failure while getting task");
            }

            return task;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Task task) {
        super.onPostExecute(task);

        if(mActivity instanceof TaskDetailsActivity){
            TextView nameText = (TextView)mActivity.findViewById(R.id.task_name_textview);
            TextView descriptionText = (TextView)mActivity.findViewById(R.id.task_description_textview);
            TextView parkText = (TextView)mActivity.findViewById(R.id.task_park_textview);

            nameText.setText(task.getName());
            descriptionText.setText(task.getDescription());
            parkText.setText(task.getPark());
        }

        else if(mActivity instanceof TaskEditActivity){
            EditText nameText = (EditText) mActivity.findViewById(R.id.task_name_edittext);
            EditText descriptionText = (EditText) mActivity.findViewById(R.id.task_description_edittext);
            EditText parkText = (EditText) mActivity.findViewById(R.id.task_park_edittext);

            nameText.setText(task.getName());
            descriptionText.setText(task.getDescription());
            parkText.setText(task.getPark());
        }
    }
}
