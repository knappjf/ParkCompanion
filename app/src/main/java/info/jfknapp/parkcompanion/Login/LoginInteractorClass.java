package info.jfknapp.parkcompanion.Login;

/**
 * Created by Jeff on 2/17/2016.
 */
public class LoginInteractorClass implements LoginInteractor {
    private final String USERNAME = "admin";
    private final String PASSWORD = "password";

    @Override
    public void login(String username, String password, LoginListener listener){
        if(!username.equals(USERNAME)){
            listener.onUsernameError();
        }

        else if(!password.equals(PASSWORD)){
            listener.onPasswordError();
        }

        else{
            listener.onSuccess();
        }
    }

    @Override
    public void addUser(String username, String password){}

    @Override
    public void deleteUser(String username){};
}
