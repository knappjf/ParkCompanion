package info.jfknapp.parkcompanion.login;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Logger;
import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Session;
import info.jfknapp.parkcompanion.util.Util;

public class CreateUserPresenter extends Presenter {

    public CreateUserPresenter(CreateUserActivity activity) {
        super(activity);
    }

    public void createUser(String username, String password) {
    }

    private void onCreateSuccess() {
        Logger.log("User successfully created");
    }

    private void onCreateFailure() {
        Logger.log("Failed to create user");
    }
}
