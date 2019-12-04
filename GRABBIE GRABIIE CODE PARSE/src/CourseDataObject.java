import java.util.ArrayList;
import java.util.List;
public class CourseDataObject {
    public String courseName;
    public String teacherName;
    public String roomNumber;
    public String periodNumber;
    public String gradeLetter; //may be null
    public String gradeNumber;


    public CourseDataObject(String courseName, String teacherName, String roomNumber, String periodNumber, String gradeLetter, String gradeNumber) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.roomNumber = roomNumber;
        this.periodNumber = periodNumber;
        this.gradeLetter = gradeLetter;
        this.gradeNumber = gradeNumber;
    }


    public CourseDataObject() {

    }
}
