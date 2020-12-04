import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String age;
    private String mail;
    private String number;

    public Person(){}

    public Person(String name, String age, String mail, String number) {
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.number = number;
    }

    private List<Course> courseList = new ArrayList<>();

    private List<Person> personList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getNumber() {
        return number;
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void addCourses(Course course){
        courseList.add(course);
    }

    public List<Course> getCourses(){
        return courseList;
    }

    public List<Person> getPersons(){
        return personList;
    }
}