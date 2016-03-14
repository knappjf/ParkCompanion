package info.jfknapp.parkcompanion.login;

public interface LoginPresenter {
    void checkUserCredentials(String username, String password);
    void loadSettings();
}
