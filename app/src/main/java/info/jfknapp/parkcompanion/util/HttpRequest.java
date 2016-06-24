package info.jfknapp.parkcompanion.util;

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
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class HttpRequest {
    private String charset;
    private Map<String, String> params;
    private URL url;
    private HttpURLConnection conn;
    private BufferedReader reader;
    private String result;
    private Object data;

    public HttpRequest(String address, String charset) throws IOException {
        this.charset = charset;
        url = new URL(address);
        params = new HashMap<>();


        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        Logger.log("Created http request");
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

//        Read results into StringBuilder
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            break;
        }

//        Create JSONObject from json string sent from server
        JSONObject json = new JSONObject(sb.toString());

//        Extract status string from JSONObject
        result = json.optString("status");

//        Try to get JSONObject type from data field
        if(json.has("data")){
             data = json.optJSONObject("data");  //If not a json object, data will be null
        }

        if (data == null){
            data = json.optJSONArray("data");
        }

        Logger.log("Request executed");
    }

    public String getStatus() throws JSONException {
        return result;
    }

    public Object getData() {
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
