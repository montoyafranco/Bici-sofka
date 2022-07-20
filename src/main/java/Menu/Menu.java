package Menu;

import Bicycle.Bicycle;
import Ticket.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Menu.Principal.bicies;
import static Menu.Principal.tickets;

public class Menu {

    public static int menu(String message){

        int userInput;
        System.out.println(message);

        System.out.println("Choose an option: ");
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextInt();

        return userInput;
    }

    public static boolean askYesNo(String question) {
        Scanner input = new Scanner(System.in);
        String answer;
        boolean askAgain;

        do {
            System.out.print(question);
            answer = input.nextLine().trim().toUpperCase();
            askAgain = !"Y".equals(answer) && !"N".equals(answer);
        } while (askAgain);

        return "Y".equals(answer);
    }


    static UserType askUserType() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        UserType uType = null;
        do {
            System.out.println(
                    """
                    Introduce your type of user
                         1. Student    2. Professor
                    """           );
            userInput = scanner.nextInt();
            uType = userInput == 1 ?
                    uType.STUDENT : uType.PROFESSOR;
        } while(userInput < 1 || userInput > 2);
        return uType;
    }
    static bicycleType askTypeBike() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        bicycleType uType = null;
        do {
            System.out.println(
                    """
                    Introduce your type of Biky
                         1. MOUNTAIN   2. ROAD
                    """           );
            userInput = scanner.nextInt();
            uType = userInput == 1 ?
                    uType.Mountain : uType.Road;
        } while(userInput < 1 || userInput > 2);
        return uType;
    }



    public static String askId(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please introduce the ID example : S/P-45856668");
        String answer = scan.nextLine();
        return answer;


    }
    public  static void read(){
        File file = new File("src/main/java/Bicycle/bicycles.txt");

        ArrayList<List> lineList = new ArrayList<>();
        String line = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/java/Bicycle/bicycles.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            while ((line = reader.readLine()) != null) {
                lineList.add(List.of(line.split(";")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (List linea : lineList){
            Bicycle bici = null;
            try {
                bici = new Bicycle((String) linea.get(0), (String) linea.get(1), (String) linea.get(2),
                        Boolean.parseBoolean((String) linea.get(3)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            bicies.add(bici);     }

    }
    public static String writeT(Ticket ticket ) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/Bicycle/tickets.txt"));
        for (Ticket ticket1 : tickets){
            writer.write(
                    "Code: " + ticket1.code + "\n"+
                            "Bicycle:" +  ticket1.bicycle.UniqueCode  + "\n"+
                            "User:" + ticket1.user.id + "\n"+
                            "Name:" + ticket1.user.fullname + "\n"+
                            "Date" + ticket1.date + "\n"+
                            "Start time :" + ticket1.initialHour+ "\n"+
                            "End time " + ticket1.finishHour + "\n"+
                            "Have helment " + ticket1.hasHelmet + "\n"+
                            "Good condition : " + ticket1.hasDamage + "\n"+
                            "Status " + ticket1.status + "\n"+
                            "Amount " + ticket1.toPay + "\n"+
                            ""
            );





        }
        writer.close();
        return null;
    }
    public static String Sout1(Ticket ticket ) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/Bicycle/tickets.txt"));
        for (Ticket ticket1 : tickets){
            System.out.println((
                    "Code: " + ticket1.code + "\n"+
                            "Bicycle:" +  ticket1.bicycle.UniqueCode  + "\n"+
                            "User:" + ticket1.user.id + "\n"+
                            "Name:" + ticket1.user.fullname + "\n"+
                            "Date" + ticket1.date + "\n"+
                            "Start time :" + ticket1.initialHour+ "\n"+
                            "End time " + ticket1.finishHour + "\n"+
                            "Have helment " + ticket1.hasHelmet + "\n"+
                            "Good condition : " + ticket1.hasDamage + "\n"+
                            "Status " + ticket1.status + "\n"+
                            "Amount " + ticket1.toPay + "\n"+
                            ""
            ));
        }

        return null;
    }
    public static void Conditionals3() throws IOException {
        String idReturn = Menu.askId();
        for (Ticket bikeReturn : tickets){
//
            if (bikeReturn.user.getId().equals(idReturn)){
                boolean askHelmet = Menu.askYesNo("Do you bring the helmet ok ?");
                boolean askDamage = Menu.askYesNo("Does the bike have damage ?");

                if ((askHelmet == false) && (askDamage)){
                    System.out.println("casco no ok");
                    bikeReturn.setStatusPending();
                    bikeReturn.setHasDamage();
                    bikeReturn.setHasNoHelmet();
                    bikeReturn.setToPayHelmet();
                    bikeReturn.setToPayDamage();



                }else if((askHelmet) && (askDamage)){
                    bikeReturn.setStatusPending();
                    bikeReturn.setHasDamage();
                    bikeReturn.setToPayDamage();

                } else if ((askHelmet == false) && (askDamage == false)) {
                    bikeReturn.setStatusPending();
                    bikeReturn.setHasNoHelmet();
                    bikeReturn.setToPayHelmet();

                }

                bikeReturn.calculateAndAdd();

                Menu.Sout1(bikeReturn);

                String print = Menu.writeT(bikeReturn);

            }
        }


    }
    public static void option4() throws IOException {
        String idReturnCase4 = Menu.askId();
        for (Ticket payTick : tickets){
            if ((payTick.user.getId().equals(idReturnCase4)) && (payTick.status.equals("Pending"))){
                System.out.println("Ticket Found");
                Sout1(payTick);
                boolean payTicketAsk = askYesNo("Do you want to pay ?");
                if (payTicketAsk){
                    System.out.println("--------------");
                    System.out.println("Ticket Updated");
                    payTick.setStatusOk();
                    Sout1(payTick);
                    writeT(payTick);

                }



            }}
    }

}

