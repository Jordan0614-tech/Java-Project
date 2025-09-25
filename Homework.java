
class Utility {
    
    // TODO: Complete the Utility class
    // Dislpay

    public static String[][] studentListToArray(StudentList list) {
        String[][] result = new String[list.size()][4];//make space for fields
        for (int i = 0; i < list.size(); i++) {//go through studens to fill in for display
            Student s = (Student) list.get(i);//gets student info and starts filling in
            result[i][0] = s.getName();
            result[i][1] = s.getStatus();
            result[i][2] = Integer.toString(s.getTotalCredit());
            result[i][3] = String.format("%.2f", s.getTuitionDue());
        }
        return result;//display
    }
    public static String[][] courseListToArray(CourseList list) {//courselist to array
        String[][] result = new String[list.size()][3];//make space for fields
        for (int i = 0; i < list.size(); i++) { //for loop through courses
            Course course = (Course) list.get(i);//go course by course filling in info
            result[i][0] = course.getCode();
            result[i][1] = course.getTitle();
            result[i][2] = String.valueOf(course.getCredit());
        }return result;
    }

}


class StudentList extends BaseList  {
    
    // TODO: Complete the StudentList class


        @Override//control, for method baselist
        public StudentList query(String key) { //goes through studes using key and prints out the new list
            StudentList result = new StudentList();
            for (int i = 0; i < this.size; i++) {
                Student studnt = (Student) internalList[i];
                if (studnt.getName().toLowerCase().contains(key.toLowerCase())) {
                    result.add(studnt);
                }
            }//show newlist with students who matched up
            return result;
        }

                 @Override 
        public boolean contains(Object obj) {//searching for obj
            if (!(obj instanceof Student)) return false;//if it is not a student return false
            for (int i = 0; i < size; i++) {
                if (((Student) internalList[i]).equals(obj)) {

                    return true;//if student
                }
            }
            return false;// no student found at all
        }

        @Override public Student findMatch(String key) {//returns a student if they match the key
            for (int i = 0; i < size; i++) {
                Student studnt = (Student) internalList[i];
                if (studnt.getName().equalsIgnoreCase(key)) {
                    return studnt;
                }
            }
            return null;//doesnt match
        }
    }





class CourseList extends BaseList {
    
    // TODO: Complete the CourseList class

    @Override//control
        public CourseList query(String key) { //doiing the same as studentlist but for courses
            CourseList result = new CourseList();
            for (int i = 0; i < this.size; i++) {
                Course co = (Course) internalList[i];
                if (co.getTitle().toLowerCase().contains(key.toLowerCase())) {
                    result.add(co);
                }
            }
            return result;// return new list of course
        }

        @Override
        public boolean contains(Object obj) { //searching for course obj
        if (!(obj instanceof Course)) return false;// return false if not a course
            for (int i = 0; i < size; i++) {
                if (((Course) internalList[i]).equals(obj)) {
                    return true;//ture if course is found
                }
            }
            return false;//nothing found or didnt work
        }

        @Override//control
     public Course findMatch(String key) { //gets course that matches key
            for (int i = 0; i < size; i++) {
                Course co = (Course) internalList[i];
                if (co.getCode().equalsIgnoreCase(key)) {
                    return co;//course is found
                }
            }
            return null; //courses has no match
    }}
