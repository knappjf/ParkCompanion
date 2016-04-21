package info.jfknapp.parkcompanion.tasks;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import info.jfknapp.parkcompanion.util.Database;

public class TasksDatabase extends Database {
    private static final String TABLE_NAME = "parkcompanion.tasks";

    public TasksDatabase(String user, String password) {
        super(user, password);
    }

    public void addTask(Task task) throws SQLException {
        Statement statement = mConnection.createStatement();

        String sql = "INSERT INTO " + TABLE_NAME +
                " VALUES (" + task.toSQL() + ")";

        statement.executeUpdate(sql);
    }

    public void deleteTask(Task task) throws SQLException{
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE task_name=?";
        PreparedStatement statement = mConnection.prepareStatement(sql);
        statement.setString(1, task.getName());
        statement.execute();
    }

    public Task getTask(String search) throws SQLException{
        String description=null;
        String park=null;
        Date date=null;
        String name=null;

        Statement statement = mConnection.createStatement();

        String sql = "SELECT task_name, task_description, park_name, creation_date FROM " + TABLE_NAME +
                " WHERE task_name = '" + search + "'";

        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            name = resultSet.getString("task_name");
            description = resultSet.getString("task_description");
            park = resultSet.getString("park_name");
            date = resultSet.getDate("creation_date");
        }
        return new Task(name, description, park, date);
    }
}
