package com.hackday.play.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by victor on 17-6-3.
 */

public class NetUtils {
    public static String sendRequst(String myurl) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(myurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(8000);
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception p) {
            p.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

        }
        return builder.toString();
    }
}

