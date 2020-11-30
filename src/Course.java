import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private List<Student> courseStudentList = new ArrayList<>();
    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public List<Student> getCourseStudentList() {
        return courseStudentList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    private String getStudentsInCourse(){
        String string = "";
        for (Student s: courseStudentList) {
            string += s.getName() + "\n";
        }
        return string;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", studentList=" + getStudentsInCourse() +
                ", teacher=" + teacher.getName() +
                '}';
    }

    public void addStudent(Student student){
        courseStudentList.add(student);
    }
}
