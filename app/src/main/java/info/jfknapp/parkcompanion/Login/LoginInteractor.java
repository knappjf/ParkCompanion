package info.jfknapp.parkcompanion.Login;

/**
 * Created by Jeff on 2/17/2016.
 */
public interface LoginInteractor {
    void login(String username, String password, LoginListener listener);
}
