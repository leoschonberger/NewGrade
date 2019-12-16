import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class GradeBookOrganizer {
    private String[][] gradeBookValue = new String[25][8];

    public GradeBookOrganizer() {

    }
    // Takes the required information on the Gradebook page and puts it into a 2D array

    //Creates an array of the Course data objects and returns it
    public CourseDataObject[] fillCourseArray(Document gradeBookPage ){
        ArrayList<ArrayList<String>> dataList = fillDataArray(gradeBookPage);
        CourseDataObject[]   dataArray = new  CourseDataObject[9];
       return dataArray;
    }
    public ArrayList<ArrayList<String>> fillDataArray(Document gradeBookPage){
       ArrayList<ArrayList<String>> dataArray = new ArrayList<ArrayList<String>>();
        dataArray.add(new ArrayList<String>());
        dataArray.add(new ArrayList<String>());
        dataArray.add(new ArrayList<String>());
        dataArray.add(new ArrayList<String>());
        dataArray.add(new ArrayList<String>());
        dataArray.add(new ArrayList<String>());
        Elements dataTable = gradeBookPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table");
        Elements courseTitles = dataTable.select("button.course-title");
        Elements teacherNames = dataTable.select("div.teacher");
        Elements roomNumbers = dataTable.select("div.teacher-room");
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

        /*
        System.out.println(dataArray.get(0).get(0));
        System.out.println(dataArray.get(0).get(1));
        System.out.println(dataArray.get(0).get(2));
        System.out.println(dataArray.get(0).get(3));
        System.out.println(dataArray.get(0).get(4));
        System.out.println(dataArray.get(0).get(5));
        System.out.println(dataArray.get(0).get(6));
        System.out.println(dataArray.get(0).get(7));

        System.out.println(dataArray.get(1).get(0));
        System.out.println(dataArray.get(1).get(1));
        System.out.println(dataArray.get(1).get(2));
        System.out.println(dataArray.get(1).get(3));
        System.out.println(dataArray.get(1).get(4));
        System.out.println(dataArray.get(1).get(5));
        System.out.println(dataArray.get(1).get(6));
        System.out.println(dataArray.get(1).get(7));

        System.out.println(dataArray.get(2).get(0));
        System.out.println(dataArray.get(2).get(1));
        System.out.println(dataArray.get(2).get(2));
        System.out.println(dataArray.get(2).get(3));
        System.out.println(dataArray.get(2).get(4));
        System.out.println(dataArray.get(2).get(5));
        System.out.println(dataArray.get(2).get(6));
        System.out.println(dataArray.get(2).get(7));

        System.out.println(dataArray.get(3).get(0));
        System.out.println(dataArray.get(3).get(1));
        System.out.println(dataArray.get(3).get(2));
        System.out.println(dataArray.get(3).get(3));
        System.out.println(dataArray.get(3).get(4));
        System.out.println(dataArray.get(3).get(5));
        System.out.println(dataArray.get(3).get(6));
        System.out.println(dataArray.get(3).get(7));

        System.out.println(dataArray.get(4).get(0));
        System.out.println(dataArray.get(4).get(1));
        System.out.println(dataArray.get(4).get(2));
        System.out.println(dataArray.get(4).get(3));
        System.out.println(dataArray.get(4).get(4));
        System.out.println(dataArray.get(4).get(5));
        System.out.println(dataArray.get(4).get(6));
        System.out.println(dataArray.get(4).get(7));
*/







        return dataArray;
    }

}






/*

  System.out.println(dataArray.get(0).get(0));
        System.out.println(dataArray.get(0).get(1));
        System.out.println(dataArray.get(0).get(2));
        System.out.println(dataArray.get(0).get(3));
        System.out.println(dataArray.get(0).get(4));
        System.out.println(dataArray.get(0).get(5));
        System.out.println(dataArray.get(0).get(6));
        System.out.println(dataArray.get(0).get(7));


 for (int i = 0; i < courseRows.size(); i += 1) {
            Element course = courseRows.get(i);
            Elements courseValue = course.select("td");
            for (int j = 0; j < 4  ; j++) {

                String  currentCourseValue = courseValue.text();
                System.out.println(currentCourseValue);
                gradeBookValue[i][j] = currentCourseValue;
            }
            gradeBookValue[i][6] = course.select("span.mark").text();
            gradeBookValue[i][7] = course.select("span.score").text();
        }


  for (int i = 0; i < CourseList.size(); i++) {
            Element value = CourseList.get(i);
            System.out.println("Element: " + value);
        }

        System.out.println(Course.courseName);



  //Following methods organize the data taken from the Gradebook page and organize it into separate courses through the CourseDataObject and return them to FillCourseArray
    private CourseDataObject CreateCourseOne(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(1) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(1) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(1) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(2) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(2) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "1";
      //  System.out.println(Course.courseName);
        //System.out.println(Course.teacherName);
      //  System.out.println(Course.roomNumber);
      //  System.out.println(Course.gradeNumber);
       // System.out.println(Course.gradeLetter);
     //   System.out.println(Course.periodNumber);
        return Course;
    }
    private CourseDataObject CreateCourseTwo(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(4) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(4) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(4) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(5) > td:nth-child(4) > span.score").text();
        Course.gradeLetter =  htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(5) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "2";
        return Course;
    }
    private CourseDataObject CreateCourseThree(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(7) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(7) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(7) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(8) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(8) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "3";
        return Course;
    }
    private CourseDataObject CreateCourseFour(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(10) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(10) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(10) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(11) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(11) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "4";
        return Course;
    }
    private CourseDataObject CreateCourseFive(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(13) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(13) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(13) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(14) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(14) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "5";
        return Course;
    }
    private CourseDataObject CreateCourseSix(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(16) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(16) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(16) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(17) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(17) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "6";
        return Course;
    }
    private CourseDataObject CreateCourseSeven(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(19) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(19) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(19) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(20) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(20) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "7";
        return Course;
    }
    private CourseDataObject CreateCourseEight(Document htmlPage){
        CourseDataObject Course = new CourseDataObject();
        Course.courseName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(22) > td:nth-child(1) > button").text();
        Course.teacherName = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(22) > td:nth-child(2) > span > span > a").text();
        Course.roomNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(22) > td:nth-child(4) > div").text();
        Course.gradeNumber = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(23) > td:nth-child(4) > span.score").text();
        Course.gradeLetter = htmlPage.select("#ctl00_ctl00_MainContent_PXPMainContent_repSchoolClasses_ctl00_ctl00_SchoolClassesPanel > table > tbody > tr:nth-child(23) > td:nth-child(4) > span.mark").text();
        Course.periodNumber = "8";
        return Course;

    }


 */
