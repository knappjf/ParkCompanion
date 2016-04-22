package info.jfknapp.parkcompanion.parks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import info.jfknapp.parkcompanion.util.Database;

public class ParkDatabase extends Database {
    private final String TABLE = "parkcompanion.parks";

    public ParkDatabase(String user, String password) {
        super(user, password);
    }

    public void addPark(Park park) throws SQLException{
        String sql  = "INSERT INTO " + TABLE + " VALUES (" + park.toSQL() + ")";
        Statement statement = mConnection.createStatement();

        statement.executeUpdate(sql);

        statement.close();
    }

    public void deletePark(Park park) throws SQLException{
        String sql = "DELETE FROM " + TABLE + " WHERE name='" + park.getName() + "'";
        Statement statement = mConnection.createStatement();

        statement.executeUpdate(sql);

        statement.close();
    }

    public Park getPark(String name) throws SQLException{
        String sql = "SELECT name, description, supervisor, phone FROM " + TABLE +
                " WHERE name = '" + name + "'";

        Statement statement = mConnection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        if(rs.next()){
            Park park = new Park(rs.getString("name"));
            park.setSupervisor(rs.getString("supervisor"));
            park.setDescription(rs.getString("description"));
            park.setPhone(rs.getString("phone"));

            rs.close();
            statement.close();

            return park;
        }

        rs.close();
        statement.close();

        return new Park(null);
    }
}
