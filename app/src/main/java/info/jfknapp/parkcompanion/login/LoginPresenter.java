package info.jfknapp.parkcompanion.login;

import info.jfknapp.parkcompanion.util.Presenter;
import info.jfknapp.parkcompanion.util.Session;

/**
 * Created by Jeff on 4/25/2016.
 */
public class LoginPresenter extends Presenter{
    private final String SUCCESS_MESSAGE = "User logged in successfully";
    private final String USERNAME_ERROR = "Username is incorrect";
    private final String PASSWORD_ERROR = "Password is incorrect";

    private final String TEST_HOST = "192.168.51.1";
    private final int TEST_PORT = 3306;

    private LoginActivity mActivity;

    public LoginPresenter(LoginActivity activity){
        super(activity);
        mActivity = activity;
    }

    public void login(String username, String password){
    }

    public void onUsernameError(){
        Session.log(USERNAME_ERROR);
    }

    public void onPasswordError(){
        Session.log(PASSWORD_ERROR);
    }

    public void onLoginSuccess(String username, String password){
        Session.setUser(username);

        Session.log(SUCCESS_MESSAGE);
        this.mActivity.navigateToMenu();
    }
}
