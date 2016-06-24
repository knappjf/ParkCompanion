package info.jfknapp.parkcompanion.util;

public class Session {
    private static Session mInstance = null;

    private String mCurrentUser;

    private Session(){
        mCurrentUser = null;
    }

    public static Session getInstance(){
        if(mInstance == null){
            mInstance = new Session();
        }

        return mInstance;
    }

//    Prevents calling clone method from Object superclass
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public void setCurrentUser(String user){
        mCurrentUser = user;
    }

    public String getCurrentUser(){
        return mCurrentUser;
    }
}