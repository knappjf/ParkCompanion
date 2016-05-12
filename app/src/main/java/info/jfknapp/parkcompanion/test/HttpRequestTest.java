package info.jfknapp.parkcompanion.test;


import org.junit.Test;

import info.jfknapp.parkcompanion.util.HttpRequest;
import info.jfknapp.parkcompanion.util.Util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HttpRequestTest {
    private final String ADDRESS = "http://localhost/php/ParkCompanion/index.php";

    @Test
    public void testConstructorOpensConnection() throws Exception {
        HttpRequest request = new HttpRequest(ADDRESS, Util.CHARSET);

        assertEquals(true, request.isConnected());
    }

    @Test
    public void testAddParamSetsParamString() throws Exception {
        HttpRequest request = new HttpRequest(ADDRESS, Util.CHARSET);
        request.addParam("command", "user");
        request.addParam("option", "list");
        String paramList = request.getParamString();

        assertNotEquals(null, paramList);
    }

    @Test
    public void testExecuteReturnsSuccess() throws Exception {
        HttpRequest request = new HttpRequest(ADDRESS, Util.CHARSET);
        request.addParam("command", "user");
        request.addParam("option", "list");
        request.execute();

        assertEquals(true, request.isResponseCodeSuccess());

        System.out.println(request.getStatus());
    }

}
