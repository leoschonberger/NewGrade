import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class ParseTeacherImagePage {
    public Document login() throws IOException {
        return Jsoup.connect("https://www.pps.net/domain/2684").post();
    }



}
