package info.jfknapp.parkcompanion.util;


//Adapted from http://www.tutorialspoint.com/android/android_php_mysql.htm
// As well as http://stackoverflow.com/questions/9767952/how-to-add-parameters-to-httpurlconnection-using-post/29561084#29561084


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HttpRequest {
    private String charset;
    private HashMap<String, String> params;
    private URL url;
    private HttpURLConnection conn;
    private BufferedReader reader;
    private JSONObject result;
    private JSONObject data;

    public HttpRequest(String address, String charset) throws IOException {
        this.charset = charset;
        params = new HashMap<>();
        url = new URL(address);
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        Session.log("Created http request");

    }

    public void addParam(String key, String value) throws UnsupportedEncodingException {
        params.put(key, value);
    }

    public void execute() throws IOException, JSONException {
        conn.connect();
        OutputStream os = conn.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os, Util.CHARSET);
        writer.write(getParamString());
        writer.flush();
        writer.close();

        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
            break;
        }
        result = new JSONObject(sb.toString());

    }

    public String getStatus() throws JSONException {
        return result.getString("status");
    }

    public String getData(String key) throws JSONException {
        return data.getString(key);
    }

    private String getParamString() throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean firstParam = true;

        for (Map.Entry<String, String> e : params.entrySet()) {
            if (firstParam) {
                firstParam = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(e.getKey(), Util.CHARSET));
            result.append("=");
            result.append(URLEncoder.encode(e.getValue(), Util.CHARSET));
        }

        return result.toString();
    }
}
