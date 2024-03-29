import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Login {
    private static final String USER_AGENT = "\"Mozilla/5.0 (Windows NT\" +\n" + "          \" 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2\"";
    //Scanner getLogin = new Scanner(System.in);
    private String USER_ID = "lschonberge9522";
    private String USER_PASSWORD = "lschonberge9522";
    public Connection.Response loginForm;

    public static void main(String[] args) throws IOException, InterruptedException {
        new Login();
    }

    public Login() throws IOException, InterruptedException {

        loginForm = Jsoup.connect("https://parent-portland.cascadetech.org/portland/PXP2_Login_Student.aspx?regenerateSessionId=True")
                .method(Connection.Method.GET)
                .userAgent(USER_AGENT)
                .execute(); //This gets the actual data from the website
        Document loginDoc = loginForm.parse(); // this is the document that contains response html


        //We need to get the values for the login form
        Element e = loginDoc.select("input[id=__VIEWSTATE]").first();
        String viewState = e.attr("value");

        e = loginDoc.select("input[id=__EVENTVALIDATION]").first();
        String eventValidation = e.attr("value");


        //We now have all the data needed to fill in the login form and login
        Document doc = Jsoup.connect("https://parent-portland.cascadetech.org/portland/PXP2_Login_Student.aspx?regenerateSessionId=True")
                .data("__VIEWSTATE", viewState)
                .data("__EVENTVALIDATION", eventValidation)
                .data("ctl00$MainContent$username", USER_ID)
                .data("ctl00$MainContent$password", USER_PASSWORD)
                .cookies(loginForm.cookies())
                .post(); //logs in

        InpoQuotes.quoteotd();
        /*
        String HomePageHtml = doc.toString();
        TimeUnit.SECONDS.sleep(1);
        checkLogin(doc);
        ParseGradebookUrl StringParserForGradeBookUrl = new ParseGradebookUrl(HomePageHtml);
        String gradeBookUrl = StringParserForGradeBookUrl.createGradeBookUrl();
        GradeBookParse.ConnectToGradesPage(loginForm, gradeBookUrl);
        GpaParse.gpaparse(loginForm);
        Document gradeBookPage = GradeBookParse.ConnectToGradesPage(loginForm, gradeBookUrl);
        GradeBookOrganizer gradebook = new GradeBookOrganizer();
       ArrayList<CourseDataObject> dataList = gradebook.fillCourseArray(gradeBookPage);
         */

       /*
        for (int i = 0; i < 8; i++) {
            System.out.println(dataList.get(i).courseName);
            System.out.println(dataList.get(i).teacherName);
            System.out.println(dataList.get(i).roomNumber);
            System.out.println(dataList.get(i).gradeNumber);
            System.out.println(dataList.get(i).gradeLetter);
        }
        */
    }
    //Returns a boolean value based on weather login was successful or not
    public boolean checkLogin(Document doc){
        boolean loggedIn = false;
        if (doc.toString().contains("Return to common login")){
            loggedIn = false;}
        else {
            loggedIn = true;
        }
        return loggedIn;
    }




}
