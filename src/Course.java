import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private List<Person> courseStudentList = new ArrayList<>();
    private Person teacher;

    public Course(String name, Person teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public List<Person> getCourseStudentList() {
        return courseStudentList;
    }

    public Person getTeacher() {
        return teacher;
    }

    private String getStudentsInCourse(){
        String string = "";
        for (Person s: courseStudentList) {
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

    public void addStudent(Person student){
        courseStudentList.add(student);
    }
}
