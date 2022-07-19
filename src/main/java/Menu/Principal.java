package Menu;
import Bicycle.Bicycle;
import Ticket.Ticket;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static Menu.Menu.*;

public class Principal {
    public static List<User> users = new ArrayList<>();
    public static List<Bicycle> bicies = new ArrayList<>();

    public static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        read();


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
                            String typechose = String.valueOf(askTypeBike());
                            System.out.println("type choose" +typechose);
                            int counter = 0;
                            for(Bicycle bicesita : bicies){
                                if (bicesita.getBikeType().equals(typechose) && (bicesita.isAccessible) &&(counter == 0)){
                                    counter++;
                                    System.out.println("Bicycle chosen!" +
                                            "Code: " + bicesita.UniqueCode + "\n" +
                                            "Type: " + bicesita.getBikeType()  + "\n" + "Color:" + bicesita.color);

                                    Ticket newTicket = new Ticket("T-001",bicesita,usuarito, LocalDate.now(), LocalTime.of(1,2),LocalTime.of(1,50),true,false,0,"Active");
                                    tickets.add(newTicket);
                                }


                            }
                            counter = 0;

                        }
                    }
                    System.out.println("A ticket was generated");
                    for (Ticket ticketcito : tickets){
                        System.out.println("Code: " + ticketcito.code + "\n"+
                                "Bicycle:" +  ticketcito.bicycle.UniqueCode  + "\n"+
                                "User:" + ticketcito.user.id + "\n"+
                                "Name:" + ticketcito.user.fullname + "\n"+
                                "Date" + ticketcito.date + "\n"+
                                "Start time :" + ticketcito.initialHour+ "\n"+
                                "End time " + ticketcito.finishHour + "\n"+
                                "Have helment " + ticketcito.hasHelmet + "\n"+
                                "Good condition : " + ticketcito.hasDamage + "\n"+
                                "Status " + ticketcito.status + "\n"+
                                "Amount " + ticketcito.toPay + "\n"+
                                "");
                        String print = Menu.writeT(ticketcito);


                    }
                    System.out.println("--------------");




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
