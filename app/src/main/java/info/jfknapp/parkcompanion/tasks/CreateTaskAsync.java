package info.jfknapp.parkcompanion.tasks;

import android.app.Activity;
import android.os.AsyncTask;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Util;

public class CreateTaskAsync extends AsyncTask <Task, Void, Void> {
    private Activity mActivity;

    public CreateTaskAsync(Activity activity) {
        mActivity = activity;
    }

    @Override
    protected Void doInBackground(Task... params) {
        Task task = params[0];

        try{
            HttpRequest request = new HttpRequest(Util.formAddress(mActivity), Util.CHARSET);
            request.addParam("command", "task");
            request.addParam("option", "create");
            request.addParam("name", task.getName());
            request.addParam("park", task.getPark());
            request.addParam("description", task.getDescription());
            request.execute();

            if(request.getStatus().equals("Success")){
                Logger.log("Successfully created task");
            }
            else{
                Logger.log("Failed to create task");
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
