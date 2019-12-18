import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseGradebookUrl {
    private final String homePageUrl;
    public ParseGradebookUrl(String homePageUrl){
        this.homePageUrl = homePageUrl;
    }


    //Uses a RegX function to find the gradebook Url from photo name and constructs it into a usable string.
    private String studentGuNumber(){
        Pattern MY_PATTERN = Pattern.compile("(?<=src=\"Photos)(.*)(?=_Photo.PNG\")");
        String serialNumber = "";
        Matcher m = MY_PATTERN.matcher(homePageUrl);
        if (m.find()) {
            serialNumber = m.group(1);
        }
        return serialNumber;
    }

    // Puts together the url base with the custom student identifier. Returns the string
    public final String createGradeBookUrl(){
        String GradeBookUrl = "https://parent-portland.cascadetech.org/portland/PXP2_Gradebook.aspx?AGU=0&studentGU=";
        for (int i = 4; i < studentGuNumber().length(); i++) {
            GradeBookUrl = GradeBookUrl + studentGuNumber().charAt(i);
        }
        return GradeBookUrl;
    }
}