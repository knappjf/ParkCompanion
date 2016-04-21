package info.jfknapp.parkcompanion.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import info.jfknapp.parkcompanion.util.Database;

public class AuthDatabase extends Database {
    public AuthDatabase(String user, String password) {
        super(user, password);
    }

    public boolean userExists(String username) {
        try {
            String result=null;

            Statement statement = mConnection.createStatement();
            String query = "select User from mysql.user where User = '"+ username +"'";
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                result = resultSet.getString("User");
            }

            if (username.equals(result)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
}
