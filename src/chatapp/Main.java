/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chatapp;

import java.util.Scanner;

/**
 *
 * @author nizaam
 */

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();
        MessageService service = new MessageService();

        System.out.println("=== Welcome to QuickChat ===");

        // ================= REGISTER OR LOGIN =================
        System.out.println("1) Register");
        System.out.println("2) Login");
        System.out.print("Choose option: ");
        int startChoice = input.nextInt();
        input.nextLine();

        if (startChoice == 1) {

            System.out.println("\n=== REGISTRATION ===");

            System.out.print("Enter First Name: ");
            String firstName = input.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = input.nextLine();

            String username;
            do {
                System.out.print("Enter Username: ");
                username = input.nextLine();
                if (!login.checkUserName(username)) {
                    System.out.println("Invalid username.");
                }
            } while (!login.checkUserName(username));

            String password;
            do {
                System.out.print("Enter Password: ");
                password = input.nextLine();
                if (!login.checkPasswordComplexity(password)) {
                    System.out.println("Invalid password.");
                }
            } while (!login.checkPasswordComplexity(password));

            String phone;
            do {
                System.out.print("Enter Cellphone: ");
                phone = input.nextLine();
                if (!login.checkCellphoneNumber(phone)) {
                    System.out.println("Invalid phone.");
                }
            } while (!login.checkCellphoneNumber(phone));

            System.out.println(login.registerUser(username, password, phone, firstName, lastName));
        }

        // ================= LOGIN LOOP =================
        boolean loggedIn = false;

        while (!loggedIn) {

            System.out.println("\n=== LOGIN ===");

            System.out.print("Username: ");
            String user = input.nextLine();

            System.out.print("Password: ");
            String pass = input.nextLine();

            if (login.loginUser(user, pass)) {
                loggedIn = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect details. Try again.");
            }
        }

        // ================= MESSAGE COUNT =================
        System.out.print("\nHow many messages would you like to send? ");
        int maxMessages = input.nextInt();
        input.nextLine();

        int sentCount = 0;

        // ================= MAIN MENU =================
        int choice;

        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose option: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    if (sentCount >= maxMessages) {
                        System.out.println("You have reached your message limit.");
                        break;
                    }

                    System.out.print("Enter recipient (+27...): ");
                    String recipient = input.nextLine();

                    System.out.print("Enter message: ");
                    String text = input.nextLine();

                    Message msg = new Message(recipient, text);

                    // Validate message
                    String validation = msg.validateMessageLength();
                    System.out.println(validation);

                    if (!validation.equals("Message ready to send.")) {
                        break;
                    }

                    // Options
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");
                    System.out.print("Choose option: ");

                    int option = input.nextInt();
                    input.nextLine();

                    String result = msg.sentMessage(option);
                    System.out.println(result);

                    if (option == 1) {
                        service.addMessage(msg);
                        System.out.println(msg.printMessage());
                        sentCount++;
                    }

                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        // ================= TOTAL =================
        System.out.println("Total messages sent: " + Message.returnTotalMessages());
    }
}