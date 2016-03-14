package info.jfknapp.parkcompanion.login;

/**
 * Created by Jeff on 2/17/2016.
 */
public interface LoginInteractor {
    void login(String username, String password, LoginListener listener);
    void addUser(String username, String password);
    void deleteUser(String username);
}
