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
        Person teacherName = null;

        for (Course cor : courseList){
            if (teacherToSearchAndPrint.equalsIgnoreCase(cor.getTeacher().getName())){
                teacherName = cor.getTeacher();
            }
        }

        textToPrint = "Namn: " + teacherName.getName() + "\n" + "Ålder: " + teacherName.getAge() + "\n" + "Mail: " + teacherName.getMail() + "\n" + "Telefonnummer: " + teacherName.getNumber();



        textToPrint += "\n" + teacherName.getName() + " utbildar i de här kurserna: ";
        for (Course co : courseList){
            if (teacherToSearchAndPrint.equalsIgnoreCase(co.getTeacher().getName())){

                textToPrint += "\n" + co.getName();
            }
        }

        textToPrint += "\n" +  teacherName.getName() + " är lärare över de här eleverna: ";
        for (Course c : courseList){
            if (teacherToSearchAndPrint.equalsIgnoreCase(c.getTeacher().getName())){

                for (Person p : c.getCourseStudentList()){
                    if (!textToPrint.contains(p.getName())){
                        textToPrint += "\n" + p.getName();
                    }
                }
            }
        }

        return textToPrint;
    }

    public String printStudent(String studentToSearchAndPrint){
        String textToPrint = null;
        Person studentName = null;

        for (Course c : courseList){
            for (Person p : c.getCourseStudentList()){
                if (studentToSearchAndPrint.equalsIgnoreCase(p.getName())){
                    studentName = p;
                }
            }
        }

        textToPrint = "Namn: " + studentName.getName() + "\n" + "Ålder: " + studentName.getAge() + "\n" + "Mail: " + studentName.getMail() + "\n" + "Telefonnummer: " + studentName.getNumber();

        textToPrint += "\n" +  studentName.getName() + " går på dom här kurserna: ";
        for (Course c : courseList){
            for (Person p : c.getCourseStudentList()){
                if (studentToSearchAndPrint.equalsIgnoreCase(p.getName())){
                    textToPrint += "\n" + c.getName();
                }
            }
        }
        textToPrint += "\n"+  studentName.getName() + " blir utbildad av de här lärarna: ";

        for (Course co : courseList){
            for (Person p : co.getCourseStudentList()){
                if (studentToSearchAndPrint.equalsIgnoreCase(p.getName())){
                    textToPrint += "\n" + co.getTeacher().getName();
                }
            }
        }

        return textToPrint;
    }

    public Database(){

        Teacher teacherOne = new Teacher("Steffe", "40","Steffe@mail.com","0737856513");
        Teacher teacherTwo = new Teacher("Cribb", "65", "Cribb@cribb.net", "8844556644");
        Teacher teacherThree = new Teacher("Anders", "51", "Anders@mail.com","0735654655");
        Teacher teacherFour = new Teacher("Lars", "30","Lars@mail.com","073565465");

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
