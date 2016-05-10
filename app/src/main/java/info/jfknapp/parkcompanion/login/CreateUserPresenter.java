package info.jfknapp.parkcompanion.login;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Session;
import info.jfknapp.parkcompanion.util.Util;

public class CreateUserPresenter extends Presenter {

    public CreateUserPresenter(CreateUserActivity activity) {
        super(activity);
    }

    public void createUser(String username, String password) {
        try {
            HttpRequest request = new HttpRequest(Util.ADDRESS, Util.CHARSET);
            request.addParam("command", "user");
            request.addParam("option", "create");
            request.addParam("name", username);
            request.addParam("password", password);
            request.execute();

            if (request.getStatus() == "Success") {
                onCreateSuccess();
            } else {
                onCreateFailure();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onCreateSuccess() {
        Session.log("User successfully created");
    }

    private void onCreateFailure() {
        Session.log("Failed to create user");
    }
}
