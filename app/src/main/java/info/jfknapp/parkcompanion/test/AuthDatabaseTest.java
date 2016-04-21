package info.jfknapp.parkcompanion.test;

import org.junit.Test;

import info.jfknapp.parkcompanion.login.AuthDatabase;

import static org.junit.Assert.*;

public class AuthDatabaseTest extends DatabaseTest{
    private AuthDatabase db = null;

    @Test
    public void testUserExists(){
        AuthDatabase db = new AuthDatabase(TEST_USER, TEST_PASS);
        db.connect(HOST, PORT);

        assertEquals(true, db.userExists(TEST_USER));

        db.close();
    }
}