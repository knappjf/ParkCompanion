package info.jfknapp.parkcompanion.util;

import android.util.ArrayMap;
import android.util.JsonReader;

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
    private Map<String, String> params;
    private URL url;
    private HttpURLConnection conn;
    private BufferedReader reader;
    private String result;
    private JSONObject data;

    public HttpRequest(String address, String charset) throws IOException {
        this.charset = charset;
        url = new URL(address);
        params = new HashMap<>();


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
        OutputStreamWriter writer = new OutputStreamWriter(os, charset);
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

        JSONObject json = new JSONObject(sb.toString());
        result = json.optString("status");

        if (!(json.optString("data").equals(""))) {
            data = new JSONObject(json.optString("data"));
        }

        Session.log("Request executed");
    }

    public String getStatus() throws JSONException {
        return result;
    }

    public JSONObject getData() throws JSONException {
        return data;
    }

    public boolean isConnected() throws IOException {
        if (conn.getResponseCode() > -1) {
            return true;
        }
        return false;
    }

    public boolean isResponseCodeSuccess() throws IOException {
        int response = conn.getResponseCode();

        if (response >= 200 && response < 300) {
            return true;
        }
        return false;
    }

    public String getParamString() throws UnsupportedEncodingException {
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
