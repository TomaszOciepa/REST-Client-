package src;

import com.google.gson.Gson;
import src.model.GooglePlace;
import src.model.Result;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestGoogleClient {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=54.5188900,18.5318800&radius=500&types=food&key=AIzaSyD6ki1G5x0S63ziEpOZzLHwM2mNzea3_1I");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        GooglePlace googlePlace = new Gson().fromJson(reader, GooglePlace.class);

        for (Result result: googlePlace.getResults()) {

            System.out.println(result.getName());
        }

//        System.out.println(googlePlace);

    }

}
