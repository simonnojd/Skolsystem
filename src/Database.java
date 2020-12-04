import java.util.ArrayList;
import java.util.List;

public class Database {

    private Person students = new Person();
    private Person teachers = new Person();
    private List<Course> courseList = new ArrayList<>();
    private String schoolInfo;

    public void addCourse(Course course){
        courseList.add(course);
    }

    public void addStudent(Person student){
        this.students.addPerson(student);
    }

    public void addTeacher(Person teacher){
        this.teachers.addPerson(teacher);
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

    public Database(){

        Person teacherOne = new Person("Steffe", "40","Steffe@mail.com","0737856513");
        Person teacherTwo = new Person("Cribb", "65", "Cribb@cribb.net", "8844556644");
        Person teacherThree = new Person("Anders", "51", "Anders@mail.com","0735654655");
        Person teacherFour = new Person("Lars", "30","Lars@mail.com","073565465");

        Course courseOne = new Course("Sexualkunskap", teacherThree);
        Course courseTwo = new Course("Java",teacherFour);
        Course courseThree = new Course("Matematik", teacherTwo);
        Course courseFour = new Course("Idrott", teacherOne);

        Person studentOne = new Person("Lily", "14", "lily@mail.com","0723221354");
        Person studentTwo = new Person("Simon","12","simon_kool@mail.com", "0756516516");
        Person studentThree = new Person("Daniel", "13", "daniel_small@mail.com","98446512");
        Person studentFour = new Person("Kalle", "15" , "kalle@mail.com", "654165131");
        Person studentFive = new Person("Sossen", "14","sosse@sosse.se", "6541321321");

        addCourse(courseOne);
        addCourse(courseTwo);
        addCourse(courseThree);
        addCourse(courseFour);

        addStudent(studentOne);
        addStudent(studentTwo);
        addStudent(studentThree);
        addStudent(studentFour);
        addStudent(studentThree);

        addTeacher(teacherOne);
        addTeacher(teacherThree);
        addTeacher(teacherTwo);
        addTeacher(teacherFour);

        courseOne.addStudent(studentOne);
        courseOne.addStudent(studentTwo);
        courseOne.addStudent(studentThree);

        courseTwo.addStudent(studentThree);
        courseTwo.addStudent(studentFive);

        courseThree.addStudent(studentOne);
        courseThree.addStudent(studentFive);

        courseFour.addStudent(studentFour);
        courseFour.addStudent(studentFive);
        courseFour.addStudent(studentOne);





 /*       studentList.add(test1);
        studentList.add(test2);

        test1.addCourses(course1);

        course1.addStudent(test1);
        course1.addStudent(test2);

        courseList.add(course1);
        teacherList.add(sigrun);*/
    }
}
