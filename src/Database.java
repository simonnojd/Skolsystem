import java.util.ArrayList;
import java.util.List;

public class Database {

    private Person students;
    private Person teachers;
    private List<Course> courseList = new ArrayList<>();
    private String schoolInfo;

    public void addCourse(Course course){
        courseList.add(course);
    }
    public void addStudent(Person student){
        this.students = students;
    }

    public void addTeacher(Person teacher){
        this.teachers = teachers;
    }

    public Course searchCourse(String string){
        for (Course c : courseList) {
            if (string.equalsIgnoreCase(c.getName())){
                return c;
            }
        }
        return null;
    }

    public Person searchTeacher(String string){
        for (Person t : teachers.getPersons()) {
            if (string.equalsIgnoreCase(t.getName())){
                return t;
            }
        }
        return null;
    }

    public Person searchStudent(String string){
        for (Person s : students.getPersons()) {
            if (string.equalsIgnoreCase(s.getName())){
                return s;
            }
        }
        return null;
    }

    public void printCourse(){
        System.out.println(courseList.get(0).getTeacher());
        for (int i = 0; i < courseList.get(0).getCourseStudentList().size(); i++) {
            System.out.println(courseList.get(0).getCourseStudentList().get(i).getName());
        }
    }

    Course course1 = new Course("Sexualkunskap", teachers);

    public Database(){

 /*       studentList.add(test1);
        studentList.add(test2);

        test1.addCourses(course1);

        course1.addStudent(test1);
        course1.addStudent(test2);

        courseList.add(course1);
        teacherList.add(sigrun);*/
    }
}
