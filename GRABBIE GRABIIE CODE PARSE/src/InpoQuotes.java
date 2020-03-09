import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.*;
import java.io.IOException;

public class InpoQuotes {

    public static void quoteotd() throws IOException {
        String json = Jsoup.connect("http://quotes.rest/qod.json").ignoreContentType(true).execute().body();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        System.out.println(jsonObject.get("quote").getAsString());
    }
}

