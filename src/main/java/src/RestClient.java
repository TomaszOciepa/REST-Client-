package src;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) throws IOException {

        URL urlCatFact = new URL("https://cat-fact.herokuapp.com/facts/random");
        InputStreamReader readerCatFact = new InputStreamReader(urlCatFact.openStream());

        CatFact catFact = new Gson().fromJson(readerCatFact, CatFact.class);

        System.out.println(catFact.getText());

        URL urlCatImage = new URL("   https://aws.random.cat/meow");
        InputStreamReader readerCatImage = new InputStreamReader(urlCatImage.openStream());

        JsonObject jsonObject = new JsonParser().parse(readerCatImage).getAsJsonObject();
        String linkImage = jsonObject.get("file").getAsString();

        System.out.println(linkImage);
    }
}
