package User;

public class User {

    UserType uType;
    Integer dni;
    String name;
    String surname;
    int age;

    public User(UserType utype, int age , Integer dni, String name, String surname)throws Exception {
        if(age < 18){
            throw new Exception("The user most be 18 or older");
        }
        this.age = age;
        this.uType = uType;
        this.dni = dni;
        this.name = name;
        this.surname = surname;

    }
}
