package info.jfknapp.parkcompanion.Login;

import android.os.Handler;
import android.util.Log;

import info.jfknapp.parkcompanion.Settings.SettingsClass;

/**
 * Created by Jeff on 2/17/2016.
 */
public class LoginPresenterClass implements LoginPresenter, LoginListener {
    private final String TAG = "[Park Companion]";

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;
    private SettingsClass mSettings;
    private Handler mSettingsHandler, mLoginHandler;

    private Runnable mSettingsRunnable = new Runnable(){
        @Override
        public void run(){
            mLoginInteractor = new LoginInteractorClass();
            loadSettings();
        }
    };


    //Constructor
    public LoginPresenterClass(LoginView loginView){
        this.mLoginView = loginView;

        mSettingsHandler = new Handler();
        mSettingsHandler.post(mSettingsRunnable);
    }

    @Override
    public void checkUserCredentials(String username, String password){
        this.mLoginInteractor.login(username, password, this);
    }

    @Override
    public void loadSettings(){
        this.mSettings = new SettingsClass(this.mLoginView.getContext());
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
        this.mLoginView.navigateToMain();
    }
}