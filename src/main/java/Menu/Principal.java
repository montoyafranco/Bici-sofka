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
