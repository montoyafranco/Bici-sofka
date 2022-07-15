package User;

public class User {

    //UserType uType;
    public int dni;
    public String name;
    String surname;
    public String fullname;
    public int age;

    // agrergar type despues UserType uType
    public User( int age , int dni, String name, String surname)throws Exception {
        if(age < 18){
            throw new Exception("The user most be 18 or older");
        }
        this.age = age;
        //this.uType = uType;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.fullname = name +" "+ surname;

    }
}
