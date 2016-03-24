package com.leadertun.android.jsonparsingmysqldb.helper;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by adnen on 15/01/16.
 */
public class MyHelper {


    public final static String TAG = "MedinaArbi";


    public static final String BASE_SERVER_URL = "http://192.168.1.100/android/";
    //public static final String BASE_SERVER_URL = "http://localhost/android/";
    public static final String BASE_GET_ALL_USERS_URL = "showusers2.php";
    public static final String BASE_INSERT_USER_URL = "insertuser.php";


    public static String UserData(String baseUrl, String state) {

        String result = null;
        HttpURLConnection con;
        InputStream is;

        String wsUrl = baseUrl;
        try {

            if (state.equals("insert_user")) {

                wsUrl = BASE_SERVER_URL + BASE_INSERT_USER_URL;

            }

            else if (state.equals("users")) {

                wsUrl = BASE_SERVER_URL + BASE_GET_ALL_USERS_URL ;
                Log.v(TAG, wsUrl);
            }

            con = (HttpURLConnection) (new URL(wsUrl)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\r\n");
            }

            is.close();
            con.disconnect();
            result = buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v(TAG,
                "MyHelper: user response result = " + result);
        return result;

    }


    public static String insertUser(String email, String password) {

        String result = null;
        HttpURLConnection con;
        InputStream is;

        String wsUrl = "";
        try {

            wsUrl = BASE_SERVER_URL + BASE_INSERT_USER_URL;


            con = (HttpURLConnection) (new URL(wsUrl)).openConnection();
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("email", email)
                    .appendQueryParameter("password", password);
            String query = builder.build().getEncodedQuery();

            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();


            con.connect();

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\r\n");
            }

            is.close();
            con.disconnect();
            result = buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v(TAG,
                "MyHelper: user response result = " + result);
        return result;

    }

}
