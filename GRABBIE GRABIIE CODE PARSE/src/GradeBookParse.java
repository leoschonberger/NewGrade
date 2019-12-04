import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class GradeBookParse {
    //Uses GradeBook URL and cookies from loginForm to open the GradesPage
    public static Document ConnectToGradesPage(Connection.Response loginForm, String GradeBookUrl) throws IOException {
        ParseGradebookUrl parseGradebookUrl = new ParseGradebookUrl(GradeBookUrl);
        Document doc = Jsoup.connect(parseGradebookUrl.createGradeBookUrl())
                .cookies(loginForm.cookies())
                .post(); //logs in

        Document GradeBookPage = doc;
        return GradeBookPage;
    }
}