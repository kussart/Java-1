package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kussani on 08.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String site = "https://yandex.ru";

        URL url = null;
        try {
            url = new URL(site);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection httpURLConnection;
        httpURLConnection = (HttpURLConnection) url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        StringBuilder result = new StringBuilder();
        String responce;
        while ((responce = bufferedReader.readLine()) != null){
            result.append(responce);
        }
        System.out.println(httpURLConnection.getResponseCode());
        System.out.println(result);

    }
}
