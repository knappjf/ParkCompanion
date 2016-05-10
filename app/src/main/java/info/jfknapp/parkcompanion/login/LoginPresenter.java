package info.jfknapp.parkcompanion.login;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Session;
import info.jfknapp.parkcompanion.util.Util;

public class LoginPresenter extends Presenter{

    private LoginActivity mActivity;

    public LoginPresenter(LoginActivity activity){
        super(activity);
        mActivity = activity;
    }

    public void login(String username, String password){
        try {
            HttpRequest request = new HttpRequest(Util.ADDRESS, Util.CHARSET);
            request.addParam("command", "login");
            request.addParam("name", username);
            request.addParam("password", password);
            request.execute();

            if (request.getStatus() == "Success") {
                onLoginSuccess(username);
            } else {
                onLoginFailure();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onLoginSuccess(String username) {
        Session.setUser(username);

        Session.log("User logged in successfully");
    }

    private void onLoginFailure() {
        Session.log("Failed to login");
    }
}
