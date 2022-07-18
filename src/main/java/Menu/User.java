package Menu;

public class User {

    UserType uType;
    public int dni;
    public String name;
    public String surname;
    public String fullname;
    public int age;
    public String id   ;
    public boolean hasTicket = false;

    public boolean isHasTicket() {
        return hasTicket;
    }

    public String getId() {
        return id;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    // agrergar type despues UserType uType
    public User(UserType uType , int age , int dni, String name, String surname)throws Exception {
        if(age < 18){
            throw new Exception("The user most be 18 or older");
        }
        this.age = age;
        this.uType = uType;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.fullname = name +" "+ surname;
        setId(this.uType,this.dni);
    }

    public void setId(UserType uType,int dni) {


        if(uType == uType.STUDENT){

            this.id =   uType.STUDENT.toString().charAt(0) + "-" + String.valueOf(this.dni);
        }
        if(uType == uType.PROFESSOR){

            this.id =   uType.PROFESSOR.toString().charAt(0) + "-" + String.valueOf(this.dni);
        }
    }
    @Override
    public String toString(){
        return
               "Data :"+ '\n' + "Type "+ uType +'\n'+ "DNI :" + dni +'\n'+"Name :" + name +'\n'+"Surname :"+surname+ '\n'
                       +"Fullname:"+ fullname+ "Age:" +age +'\n'+
                       "Id: "+ id +'\n'+"TICKET STATE :" +hasTicket  ;
    }
}
