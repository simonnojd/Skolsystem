import java.util.List;

public class Student extends Person{

    private String address;
    private String guardian;

    public Student(String name, String age, String mail,
                   String number, String adress, String guardian) {
        super(name, age, mail, number);
        this.address = adress;
        this.guardian = guardian;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGuardian() {
        return guardian;
    }
}
