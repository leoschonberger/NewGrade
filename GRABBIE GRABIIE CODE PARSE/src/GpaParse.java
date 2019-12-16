import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class GpaParse {

    //Loads Course History using cookies and connects
    public static Document connectToCourseHistoryPage(Connection.Response loginForm) throws IOException {
        String courseHistoryUrl = "https://parent-portland.cascadetech.org/portland/PXP2_CourseHistory.aspx?AGU=0";
        Document courseHitoryPage = Jsoup.connect(courseHistoryUrl)
                .cookies(loginForm.cookies())
                .post();
        return courseHitoryPage;
    }
    //Grabs the gpa elements using css selectors. Manipulates string to isolate the gpa number, places both into an Array. Unweighted is at 0, weighted is at 1. Returns an Array.
    public static String[] gpaparse(Connection.Response loginForm) throws IOException {
        Elements unweightedGpa = connectToCourseHistoryPage(loginForm).select("#ctl00_ctl00_MainContent_PXPMainContent_CourseHistoryContent > div.right-panel > div:nth-child(1) > div > span.gpa-score");
        Elements weightedGpa = connectToCourseHistoryPage(loginForm).select("#ctl00_ctl00_MainContent_PXPMainContent_CourseHistoryContent > div.right-panel > div:nth-child(2) > div > span.gpa-score");

        String unweightedGpaString = unweightedGpa.toString();
        String weightedGpaString = weightedGpa.toString();

        String crudeUnweightedGpaString = unweightedGpaString.replace("<span class=\"gpa-score\">","");
        String crudeWeightedGpaString = unweightedGpaString.replace("<span class=\"gpa-score\">","");

        String pureUnweightedGpaString = crudeUnweightedGpaString.replace("</span>","");
        String pureWeightedGpaString = crudeWeightedGpaString.replace("</span>","");

        //System.out.println("Unweighted " + pureUnweightedGpaString);
        //System.out.println("Weighted " + pureWeightedGpaString);
        String[] gpaArray = new String[2];
        gpaArray[0] = pureUnweightedGpaString;
        gpaArray[1] = pureWeightedGpaString;
        return gpaArray;
    }
}