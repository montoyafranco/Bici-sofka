package Menu;

import java.util.Scanner;

public class Menu {

    // Follow the structure of sanipet
    //
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
                    """
            );
            userInput = scanner.nextInt();

            uType = userInput == 1 ?
                    uType.STUDENT : uType.PROFESSOR;

        } while(userInput < 1 || userInput > 2);

        return uType;
    }
}

