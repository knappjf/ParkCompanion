package info.jfknapp.parkcompanion.Login;

public interface LoginPresenter {
    void checkUserCredentials(String username, String password);
    void loadSettings();
}
