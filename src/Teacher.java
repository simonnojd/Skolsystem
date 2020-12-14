/**
 * Created by Christoffer Grännby
 * Date: 2020-12-10
 * Time: 11:24
 * Project: NoobGruppen
 * Copyright: MIT
 */
public class Teacher extends Person {

    String password = "1234";

    public Teacher(String name, String age, String mail, String number){
        super.name = name;
        super.age = age;
        super.mail = mail;
        super.number = number;
    }

    public String getPassword() {
        return password;
    }
}
