public class Teacher extends Person{

    private String password;

    public Teacher(String name, String age, String mail, String number, String password) {
        super(name, age, mail, number);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
