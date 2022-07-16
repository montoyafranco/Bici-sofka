package Menu;

import Bicycle.Bicycle;

import java.io.*;
import java.util.*;


public class Principal {


    public static List<User> users = new ArrayList<>();
    public static List<Bicycle> bicies = new ArrayList<>();
    //-------------- ARRIBA GUARDO MIS USUARIOS-----


    //Resources.setDefaults(); algo asi me serviria para poner las cosas por default
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        File file = new File("src/main/java/Bicycle/bicycles.txt");
        Scanner scan;
        ArrayList<List> newLine = new ArrayList<>();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Bicycle/bicycles.txt"));
            while ((line = reader.readLine()) != null) {
                newLine.add(List.of(line.split(";")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       for (List linea : newLine){
           System.out.println(linea.get(0));
          Bicycle bici = new Bicycle((String) linea.get(0), (String) linea.get(1), (String) linea.get(2),Boolean.parseBoolean((String) linea.get(3)));
          bicies.add(bici);
       }
       for(Bicycle aver : bicies){
           System.out.println(aver.getAccessible()+ aver.getBikeType()  );
       }


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
