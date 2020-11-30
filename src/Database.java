import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
   // private List<Object> bigList = new ArrayList<>();


    public void addStudent(Student student){
        studentList.add(student);
    }

    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    public Course searchCourse(String string){
        for (Course c : courseList) {
            if (string.equalsIgnoreCase(c.getName())){
                return c;
            }
        }
        return null;
    }

    public Student searchStudent(String string){
        for (Student s : studentList) {
            if (string.equalsIgnoreCase(s.getName())){
                return s;
            }
        }
        return null;
    }

    public Teacher searchTeacher(String string){
        for (Teacher t : teacherList) {
            if (string.equalsIgnoreCase(t.getName())){
                return t;
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


    Student test1 = new Student("Elias", "21",
            "test@gmail.com", "0704955146", "mammagatan 12", "pappa");
    Student test2 = new Student("Eggdad", "21",
            "test@gmail.com", "0704955146", "mammagatan 12", "pappa");

    Teacher sigrun = new Teacher("Sigrun", "40",
            "test123@gmail.com", "484848484", "sigge");

    Course course1 = new Course("Biologi", sigrun);

    public Database(){

        studentList.add(test1);
        studentList.add(test2);

        test1.addCourses(course1);

        course1.addStudent(test1);
        course1.addStudent(test2);

        courseList.add(course1);
        teacherList.add(sigrun);
    }
}
