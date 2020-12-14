import java.util.ArrayList;
import java.util.List;

public class Database {

    private Person students = new Person();
    private Person teachers = new Person();
    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void addStudent(Person student) {
        this.students.addPerson(student);
    }

    public void addTeacher(Person teacher) {
        this.teachers.addPerson(teacher);
    }

    public Course searchCourse(String string) {
        for (Course course : courseList) {
            if (string.equalsIgnoreCase(course.getName())) {
                return course;
            }
        }
        return null;
    }

    public Person searchTeacher(String string) {
        for (Person person : teachers.getPersons()) {
            if (string.equalsIgnoreCase(person.getName())) {
                return person;
            }
        }
        return null;
    }

    public Person searchStudent(String string) {
        for (Person person : students.getPersons()) {
            if (string.equalsIgnoreCase(person.getName())) {
                return person;
            }
        }
        return null;
    }

    public String printCourse(String courseToSearchAndPrint) {
        Course courseToPrint = searchCourse(courseToSearchAndPrint);

        String textToPrint = "Kurs: " + courseToPrint.getName() + "\n" + "Lärare: " + courseToPrint.getTeacher().getName() + "\n" + "Studenter: ";

        for (Person p : courseToPrint.getCourseStudentList()) {
            textToPrint += "\n" + p.getName();
        }

        return textToPrint;
    }

    public String printTeacher(String teacherToSearchAndPrint) {
        Person teacher = searchTeacher(teacherToSearchAndPrint);

        String textToPrint = "Namn: " + teacher.getName() + "\n" + "Ålder: " + teacher.getAge() + "\n" + "Mail: " + teacher.getMail() + "\n" + "Telefonnummer: " + teacher.getNumber() + "\n" + teacher.getName() + " utbildar de här kurserna: ";


        for (Course findCourse : teacher.getCourses()){
            textToPrint += "\n" + findCourse.getName();
        }


        textToPrint += "\n" + teacher.getName() + " är lärare över de här eleverna: ";

        for (Course courseStudents : teacher.getCourses()){
            for (Person studentInClass : courseStudents.getCourseStudentList()){
                if (!textToPrint.contains(studentInClass.getName())){
                   textToPrint += "\n" + studentInClass.getName();
                }
            }
        }


        return textToPrint;
    }

    public String printStudent(String studentToSearchAndPrint) {
        Person studentName = searchStudent(studentToSearchAndPrint);

        String textToPrint = "Namn: " + studentName.getName() + "\n" + "Ålder: " + studentName.getAge() + "\n" + "Mail: " + studentName.getMail() + "\n" + "Telefonnummer: " + studentName.getNumber() + "\n" + studentName.getName() + " går på dom här kurserna: ";

        for (Course coursesStudentIsIn : studentName.getCourses()){
            textToPrint += "\n" + coursesStudentIsIn.getName();
        }

        textToPrint += "\n" + studentName.getName() + " blir utbildad av de här lärarna: ";

        for (Course coursesStudentHas : studentName.getCourses()){
                textToPrint += "\n" + coursesStudentHas.getTeacher().getName();
        }


        return textToPrint;
    }


    public Database() {

        Person teacherOne = new Person("Steffe", "40", "Steffe@mail.com", "0737856513");
        Person teacherTwo = new Person("Cribb", "65", "Cribb@cribb.net", "8844556644");
        Person teacherThree = new Person("Anders", "51", "Anders@mail.com", "0735654655");
        Person teacherFour = new Person("Lars", "30", "Lars@mail.com", "073565465");

        Course courseOne = new Course("Svenska", teacherThree);
        Course courseTwo = new Course("Java", teacherFour);
        Course courseThree = new Course("Matematik", teacherTwo);
        Course courseFour = new Course("Idrott", teacherOne);

        Person studentOne = new Person("Lily", "14", "lily@mail.com", "0723221354");
        Person studentTwo = new Person("Simon", "12", "simon_kool@mail.com", "0756516516");
        Person studentThree = new Person("Daniel", "13", "daniel_small@mail.com", "98446512");
        Person studentFour = new Person("Kalle", "15", "kalle@mail.com", "654165131");
        Person studentFive = new Person("Elias", "14", "elias@mail.se", "6541321321");

        teacherOne.addCourses(courseFour);
        teacherTwo.addCourses(courseThree);
        teacherThree.addCourses(courseOne);
        teacherFour.addCourses(courseTwo);

        studentOne.addCourses(courseOne);
        studentOne.addCourses(courseFour);
        studentOne.addCourses(courseThree);

        studentTwo.addCourses(courseOne);

        studentThree.addCourses(courseOne);
        studentThree.addCourses(courseTwo);

        studentFour.addCourses(courseFour);

        studentFive.addCourses(courseTwo);
        studentFive.addCourses(courseThree);
        studentFive.addCourses(courseFour);

        addCourse(courseOne);
        addCourse(courseTwo);
        addCourse(courseThree);
        addCourse(courseFour);

        addStudent(studentOne);
        addStudent(studentTwo);
        addStudent(studentThree);
        addStudent(studentFour);
        addStudent(studentFive);

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
    }
}
