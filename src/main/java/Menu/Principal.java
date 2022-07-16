package Menu;

import java.util.*;


public class Principal {


    public static List<User> users = new ArrayList<>();
    //-------------- ARRIBA GUARDO MIS USUARIOS-----


    //Resources.setDefaults(); algo asi me serviria para poner las cosas por default
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean seeAgain; //

        do {
            // Menu.menu ( mensage) imprime lo que le des de parametro y ejecuta NextLine y retorna su valor
            int optSelected = Menu.menu(
                    """
                    ______________________________________
                    |Welcome to the Bici-U Organizer     |
                    |Choose an option:                   |
                    |                                    |
                    |1. Register user.                   |
                    |2. Borrow Bicicle                   |
                    |3. Return Bicycle                   |
                    |4. Pay Tickets                      |
                    |5. Tickets history.                 |
                    |6. Exit     ________________________|   """);
            switch(optSelected) {
                case 1:
                    User user = Creation.newUser();
                    users.add(user);

                    for (User user1 : users){
                        System.out.println(user1.uType + " "+ user1.id +" " +user1.dni + " "+user1.fullname + " "+user1.age);
                    }
                    if(user == null) break;
                    //pets.add(Creation.newPatient(owner));
                    break;

                default:
                    System.out.println("Please select a valid option!!");
            }
            seeAgain = Menu.askYesNo(
                    "Do you want tu see the menu again?? [Y]/[N]"
            );
            //clearConsole(); aca deberia poder cerrrar la consola
        } while(seeAgain);

    }

}
