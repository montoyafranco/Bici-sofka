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
                            if(usuarito.hasTicket){
                                System.out.println("The user "+ usuarito.getId()+ "has a ticket with debt.Please cancel it and try again.");
                                break;
                            }else{
                                System.out.println("Please choose the type of bike:");
                                String typechose = String.valueOf(askTypeBike());
                                System.out.println("Type chosen: "+" " +typechose);
                                int counter = 0;
                                for(Bicycle bicesita : bicies){
                                    if (bicesita.getBikeType().equals(typechose) && (bicesita.isAccessible) &&(counter == 0)){
                                        counter++;
                                        System.out.println("Bicycle chosen!" +
                                                "Code: " + bicesita.UniqueCode + "\n" +
                                                "Type: " + bicesita.getBikeType()  + "\n" + "Color:" + bicesita.color);

                                        usuarito.setHasTicket(true);         //------ make the status of user as has ticket
                                        Ticket newTicket = new Ticket("T-001",bicesita,usuarito, LocalDate.now(), LocalTime.of(1,2),LocalTime.of(1,50),true,true,0,"Active");

                                        bicesita.setAccessible();            //----- Make the bicycle accesible status = false
                                        tickets.add(newTicket);
                                        System.out.println("A ticket was generated");
                                        for (Ticket ticketcito : tickets){
                                            Menu.Sout1(ticketcito);
                                            String print = Menu.writeT(ticketcito);
                                        }
                                        System.out.println("--------------");
                                    }
                                }
                                //System.out.println(bicies);   To see if the changues aply
                                counter = 0;
                            }}
                    }

                    break;
                case 3:
                    String idReturn = Menu.askId();
                    for (Ticket bikeReturn : tickets){
//                        System.out.println(bikeReturn);
                        if (bikeReturn.user.getId().equals(idReturn)){
                            boolean askHelmet = Menu.askYesNo("Do you bring the helmet ok ?");
                            boolean askDamage = Menu.askYesNo("Does the bike have damage ?");


                            //setear status ..este de abajo es si esta todo ok
                            bikeReturn.setStatusOk();


                            //aca imprime como este la cosa no importa
                            Menu.Sout1(bikeReturn);
//
                            //aca crea ticket
                            String print = Menu.writeT(bikeReturn);
                            //si tiene -tod0 ok aca
                            //bikeReturn.setStatusPending();

                            //si tiene
                        }
                    }





//                    System.out.println("Caso 1- sin deuda todo en buenas condiciones ");
//                    System.out.println("Caso 2 -bici dañada y sin casco");
//                    System.out.println("caso 3 -");
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