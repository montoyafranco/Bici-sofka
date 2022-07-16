package Menu;


import java.util.Scanner;

public class Creation {
    public static User newUser() {

        UserType uType = Menu.askUserType();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your dni: " );
        int dni = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your surname: ");

        String surname = scanner.nextLine();

        try {
            return new User (uType,age ,dni,name,surname);
        } catch (Exception err) {
            err.printStackTrace();
        }
        return null;
    }
}
