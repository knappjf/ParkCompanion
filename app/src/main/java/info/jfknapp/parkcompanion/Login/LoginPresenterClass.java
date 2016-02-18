package info.jfknapp.parkcompanion.Login;

import android.util.Log;

/**
 * Created by Jeff on 2/17/2016.
 */
public class LoginPresenterClass implements LoginPresenter, LoginListener {
    private final String TAG = "[Park Companion]";

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    //Constructor
    public LoginPresenterClass(LoginView loginView){
        mLoginView = loginView;
        mLoginInteractor = new LoginInteractorClass();
    }

    @Override
    public void checkUserCredentials(String username, String password){
        mLoginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError(){
        Log.d(this.TAG, "Incorrect Username");
    }

    @Override
    public void onPasswordError(){
        Log.d(this.TAG, "Incorrect Password");
    }

    @Override
    public void onSuccess(){
        Log.d(this.TAG, "Username and password correct");
    }

}
