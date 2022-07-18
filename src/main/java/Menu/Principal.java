package Menu;

import Bicycle.Bicycle;
import Ticket.Ticket;

import java.io.*;
import java.util.*;

import static Menu.Menu.askTypeBike;


public class Principal {
    public static List<User> users = new ArrayList<>();
    public static List<Bicycle> bicies = new ArrayList<>();

    public static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        File file = new File("src/main/java/Bicycle/bicycles.txt");
        Scanner scan;
        ArrayList<List> lineList = new ArrayList<>();
        String line = null;
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Bicycle/bicycles.txt"));
        try {
            while ((line = reader.readLine()) != null) {
                lineList.add(List.of(line.split(";")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        for (List linea : lineList){
            //System.out.println(linea.get(0));
            Bicycle bici = new Bicycle((String) linea.get(0), (String) linea.get(1), (String) linea.get(2),
                    Boolean.parseBoolean((String) linea.get(3)));
            bicies.add(bici);
        }


        //To read bic
       // for(Bicycle aver : bicies){
            //System.out.println(aver.UniqueCode);
           // System.out.println(aver.getAccessible()+ aver.getBikeType()  );
        //}


        boolean seeAgain;

        do {
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
            switch (optSelected) {
                case 1:
                    User user = Creation.newUser();
                    users.add(user);
                    System.out.println("Register completed!");
                    for (User user1 : users) {
                        System.out.println("ID:" + user1.id + "\n" + "Name: " + user1.fullname + "\n" + "Age: " + user1.age);
                    }
                    if (user == null) break;
                    break;
                case 2:
                    //ask for id
                    String id = Menu.askId();
                    for(User usuarito : users){
                        if(usuarito.getId().equals(id)){
                            System.out.println("-----------User in the system Found-------------------");
                            System.out.println("User ID : " + " "+ usuarito.getId() +" User Fullname : "+ usuarito.fullname
                                    +" "+ "User Type :" +usuarito.uType);
                            if (usuarito.hasTicket){
                                System.out.println("The user "+ usuarito.getId()+ "has a ticket with debt.Please cancel it and try again.");
                                break;
                            }
                            System.out.println("Please choose the type of bike:");
                            bicycleType typechose = Menu.askTypeBike();
                            System.out.println(typechose);

                            System.out.println(usuarito);
//                            for(Bicycle aver : bicies){
////                                System.out.println("Bikes Type: " + aver.UniqueCode+" "+ "Bikes Type: " +aver.getBikeType()  );
//                            }
                            System.out.println("----Chosing the bicycle is under construction------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Return of bicycle under construction");
                    break;
                case 4:
                    System.out.println("Payment of tickets under construction");
                    break;
                case 5:
                    System.out.println("Tickets history under construction");
                    break;
                case 6:
                    System.out.println("Bye bye .You choose to exit the program");

                    break;
                default:
                    System.out.println("Please select a valid option!!");
            }
            seeAgain = Menu.askYesNo(
                    "Do you want tu see the menu again?? [Y]/[N]"
            );
            //clearConsole(); aca deberia poder cerrrar la consola
        } while (seeAgain);

    }

}
