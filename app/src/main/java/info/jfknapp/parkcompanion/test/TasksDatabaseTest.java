package info.jfknapp.parkcompanion.test;

import org.junit.Test;

import java.sql.Date;

import info.jfknapp.parkcompanion.tasks.Task;
import info.jfknapp.parkcompanion.tasks.TasksDatabase;

import static org.junit.Assert.*;

public class TasksDatabaseTest extends DatabaseTest{

    @Test
    public void testTaskDB() throws Exception{
        TasksDatabase db = new TasksDatabase(TEST_USER, TEST_PASS);
        db.connect(HOST, PORT);

        //Ensure task does not exist yet
        assertNotEquals("test", db.getTask("test").getName());

        Task task = new Task("test","test","test", Date.valueOf("2016-01-01"));
        db.addTask(task);

        assertEquals("test", db.getTask("test").getName());

        db.deleteTask(task);

        assertNotEquals("test", db.getTask("test").getName());

        db.close();
    }
}