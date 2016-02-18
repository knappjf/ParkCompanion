package info.jfknapp.parkcompanion.Login;

/**
 * Created by Jeff on 2/17/2016.
 */
public interface LoginListener {
    void onUsernameError();
    void onPasswordError();
    void onSuccess();
}
