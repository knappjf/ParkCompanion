package info.jfknapp.parkcompanion.test;

import org.junit.Test;

import info.jfknapp.parkcompanion.util.Database;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    public final String HOST = "localhost";
    public final int PORT = 3306;
    public final String TEST_USER="admin";
    public final String TEST_PASS="123";

    @Test
    public void testConnect(){
        Database db = new Database(TEST_USER, TEST_PASS);

        assertEquals(db.SUCCESS, db.connect(HOST, PORT));
        db.close();
    }

    @Test
    public void testClose(){
        Database db = new Database(TEST_USER, TEST_PASS);
        db.connect(HOST, PORT);

        assertEquals(db.SUCCESS, db.close());
    }
}