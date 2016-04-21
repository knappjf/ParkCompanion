package info.jfknapp.parkcompanion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
        public final int SUCCESS = 0;
        public final int FAIL = 1;
        public final String DATABASE_NAME = "parkcompanion";


        protected String mUser, mPassword; //Eventually password will be encrypted once I have time to figure out how
        protected Connection mConnection = null;

        public Database(String user, String password) {
            mUser = user;
            mPassword = password;
        }

        public int connect(String host, int port) {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + DATABASE_NAME;

            try {
                mConnection = DriverManager.getConnection(url, mUser, mPassword);
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                return FAIL;
            }

            return SUCCESS;
        }

        public int close(){
            try{
                mConnection.close();
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                return FAIL;
            }
            return SUCCESS;
        }
}
