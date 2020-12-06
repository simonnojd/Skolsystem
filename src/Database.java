import java.util.ArrayList;
import java.util.List;

public class Database {

    private Person students = new Person();
    private Person teachers = new Person();
    private List<Course> courseList = new ArrayList<>();

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
        for (Course course : courseList) {
            if (string.equalsIgnoreCase(course.getName())){
                return course;
            }
        }
        return null;
    }
    public Person searchTeacher(String string){
        for (Person person : teachers.getPersons()) {
            if (string.equalsIgnoreCase(person.getName())){
                return person;
            }
        }
        return null;
    }

    public Person searchStudent(String string){
        for (Person person : students.getPersons()) {
            if (string.equalsIgnoreCase(person.getName())){
                return person;
            }
        }
        return null;
    }
    public String printCourse(String courseToSearchAndPrint){
        String textToPrint = null;

        for (Course c : courseList){
            if (courseToSearchAndPrint.equalsIgnoreCase(c.getName())){
                textToPrint = "Kurs: " + c.getName() + "\n" + "Lärare: " + c.getTeacher().getName() + "\n" + "Studenter: ";
                for (Person p : c.getCourseStudentList()){
                    textToPrint += "\n" + p.getName();
                }
            }
        }

        return textToPrint;
    }

    public String printTeacher(String teacherToSearchAndPrint){
        String textToPrint = null;

        for (Course c : courseList){
            if (teacherToSearchAndPrint.equalsIgnoreCase(c.getTeacher().getName())){
                if (textToPrint == null){
                    textToPrint = c.getTeacher().getName() + " är lärare över de här eleverna: ";
                }
                for (Person p : c.getCourseStudentList()){
                    textToPrint += "\n" + p.getName();
                }
            }
        }
        return textToPrint;
    }

    public String printStudent(String studentToSearchAndPrint){
        String textToPrint = null;

        for (Course c : courseList){
            for (Person p : c.getCourseStudentList()){
                if (studentToSearchAndPrint.equalsIgnoreCase(p.getName())){
                    if (textToPrint == null){
                        textToPrint = p.getName() + " går på dom här kurserna: ";
                    }
                    textToPrint += "\n" + c.getName();
                }
            }
        }


        return textToPrint;
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
