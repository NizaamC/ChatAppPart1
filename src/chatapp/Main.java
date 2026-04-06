package chatapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        String firstName, lastName, username, password, cellPhone;

        System.out.println("=== REGISTRATION ===");

        System.out.print("Enter First Name: ");
        firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = input.nextLine();

        // 🔹 Username loop
        do {
            System.out.print("Enter Username: ");
            username = input.nextLine().trim();

            if (!login.checkUserName(username)) {
                System.out.println("Username is not correctly formatted; please ensure it contains an underscore and is no more than 5 characters.");
            }

        } while (!login.checkUserName(username));

        System.out.println("Username successfully captured.");

        // 🔹 Password loop
        do {
            System.out.print("Enter Password: ");
            password = input.nextLine().trim();

            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted; must contain 8 characters, capital letter, number, and special character.");
            }

        } while (!login.checkPasswordComplexity(password));

        System.out.println("Password successfully captured.");

        // 🔹 Cellphone loop (FIXED)
        do {
            System.out.print("Enter Cellphone (e.g. 079... or +27...): ");
            cellPhone = input.nextLine().trim();

            if (!login.checkCellphoneNumber(cellPhone)) {
                System.out.println("Cell phone number incorrectly formatted. Enter 10 digits starting with 0 or include +27.");
            }

        } while (!login.checkCellphoneNumber(cellPhone));

        System.out.println("Cell phone number successfully captured.");

        // Register user
        login.registerUser(username, password, cellPhone, firstName, lastName);

        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter Username: ");
        String loginUser = input.nextLine().trim();

        System.out.print("Enter Password: ");
        String loginPass = input.nextLine().trim();

        boolean status = login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus(status));

        // Menu
        if (status) {
            int choice;

            do {
                System.out.println("\n=== MAIN MENU ===");
                System.out.println("1. Send Message");
                System.out.println("2. View Messages");
                System.out.println("3. Logout");
                System.out.print("Choose option: ");

                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Send Message feature coming in Part 2.");
                        break;
                    case 2:
                        System.out.println("View Messages feature coming in Part 2.");
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 3);
        }

        System.out.println("Program ended.");
    }
}