import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GradeBookOrganizer {

    public GradeBookOrganizer() {

    }
    // Takes the required information on the Gradebook page and puts it into a 2D array

    //Creates an array of the Course data objects and returns it
    public ArrayList<CourseDataObject> fillCourseArray(Document gradeBookPage ){
        ArrayList<CourseDataObject> dataList = fillDataArray(gradeBookPage);
       return dataList;
    }
    public ArrayList<CourseDataObject> fillDataArray(Document gradeBookPage){
      /*
            DataArray Organization
            0,0 = coursename first course
            1,0 = teachername first course
            2,0 = roomnumber first course
            3.0  Gradeletter first course
            4,0  gradenumber first course
            second slot determines which course you are retrieving info from, 0-7 for the 8 classes
      */
        //Creates a 2D ArrayList of strings and fills it by grabbing information from the gradeBookPage Document
       ArrayList<ArrayList<String>> dataArray = new ArrayList<>();
        dataArray.add(new ArrayList<>());
        dataArray.add(new ArrayList<>());
        dataArray.add(new ArrayList<>());
        dataArray.add(new ArrayList<>());
        dataArray.add(new ArrayList<>());
        dataArray.add(new ArrayList<>());
        // HTML path selector that grabs the data table that contains all other required data
        Elements dataTable = gradeBookPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table");
        // grabs names of all courses by selecting buttons with the class name "course-title" which have the course title as their text
        Elements courseTitles = dataTable.select("button.course-title");
        // grabs teacher name by selecting divisions with the class name "teacher" which have the teacher names
        Elements teacherNames = dataTable.select("div.teacher");
        // grabs the rooms the courses are in by selecting divisions with the class name "teacher-room" which have the rooms
        Elements roomNumbers = dataTable.select("div.teacher-room");
        // grabs the grade letters by selecting
        Elements gradeLetters = dataTable.select("span.mark");
        Elements gradeNumbers = dataTable.select("span.score");
        for (Element Element:courseTitles
             ) {
            dataArray.get(0).add(Element.text());
        }
        for (Element Element:teacherNames
        ) {
            dataArray.get(1).add(Element.text());
        } for (Element Element:roomNumbers
        ) {
            dataArray.get(2).add(Element.text());
        } for (Element Element:gradeLetters
        ) {
            dataArray.get(3).add(Element.text());
        } for (Element Element:gradeNumbers
        ) {
            dataArray.get(4).add(Element.text());
        }
        // Creates an ArrayList full of CourseDataObjects and sets their values using data from the dataArray 2D ArrayList
        ArrayList<CourseDataObject> courseDataObjectArrayList = new ArrayList<>();
        for (int i = 0; i < 8  ; i++) {
            courseDataObjectArrayList.add(new CourseDataObject());
        }
        for (int i = 0; i < 8 ; i++) {
            courseDataObjectArrayList.get(i).courseName = dataArray.get(0).get(i);
            courseDataObjectArrayList.get(i).teacherName = dataArray.get(1).get(i);
            courseDataObjectArrayList.get(i).roomNumber =  dataArray.get(2).get(i);
            courseDataObjectArrayList.get(i).gradeLetter = dataArray.get(3).get(i);
            courseDataObjectArrayList.get(i).gradeNumber = dataArray.get(4).get(i);
        }
        // courseArrayList is returned to fillCourseArray so it can be returned to main
        return courseDataObjectArrayList;
    }

}






