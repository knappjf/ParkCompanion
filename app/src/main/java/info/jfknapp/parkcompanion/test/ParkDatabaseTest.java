package info.jfknapp.parkcompanion.test;

import org.junit.Test;

import info.jfknapp.parkcompanion.parks.Park;
import info.jfknapp.parkcompanion.parks.ParkDatabase;

import static org.junit.Assert.*;

public class ParkDatabaseTest extends DatabaseTest{
    @Test
    public void testParkDatabase() throws Exception{
        String name = "Test Park";

        Park park = new Park(name);
        park.setDescription("Test Description");
        park.setPhone("5555555555");
        park.setSupervisor("Test Supervisor");

        ParkDatabase db = new ParkDatabase(TEST_USER, TEST_PASS);
        db.connect(HOST, PORT);

        assertNotEquals(name, db.getPark(name));

        db.addPark(park);
        assertEquals(name, db.getPark(name).getName());

        db.deletePark(park);
        assertNotEquals(name, db.getPark(name));

        db.close();
    }
}