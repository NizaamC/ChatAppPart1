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

            System.out.print("First Name: ");
            String firstName = input.nextLine();

            System.out.print("Last Name: ");
            String lastName = input.nextLine();

            String username;

            do {
                System.out.print("Username: ");
                username = input.nextLine();

                if (!login.checkUserName(username)) {
                    System.out.println("Invalid username.");
                }

            } while (!login.checkUserName(username));

            String password;

            do {
                System.out.print("Password: ");
                password = input.nextLine();

                if (!login.checkPasswordComplexity(password)) {
                    System.out.println("Invalid password.");
                }

            } while (!login.checkPasswordComplexity(password));

            String phone;

            do {
                System.out.print("Cell Number: ");
                phone = input.nextLine();

                if (!login.checkCellphoneNumber(phone)) {
                    System.out.println("Invalid phone number.");
                }

            } while (!login.checkCellphoneNumber(phone));

            System.out.println(
                    login.registerUser(
                            username,
                            password,
                            phone,
                            firstName,
                            lastName));
        }

        // ================= LOGIN =================

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

        // ================= MESSAGE LIMIT =================

        System.out.print("\nHow many messages would you like to process? ");

        int maxMessages = input.nextInt();
        input.nextLine();

        int processedMessages = 0;

        // ================= MAIN MENU =================

        int choice;

        do {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1) Send Messages");
            System.out.println("2) Show Recently Sent Messages");
            System.out.println("3) Quit");
            System.out.println("4) Stored Messages");
            System.out.print("Choose option: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                // ==========================================
                // SEND MESSAGE
                // ==========================================

                case 1:

                    if (processedMessages >= maxMessages) {

                        System.out.println(
                                "You have reached your message limit.");
                        break;
                    }

                    System.out.print("Enter recipient (+27...): ");
                    String recipient = input.nextLine();

                    System.out.print("Enter message: ");
                    String text = input.nextLine();

                    Message tempMsg =
                            new Message(recipient, text, "Sent");

                    String validation =
                            tempMsg.validateMessageLength();

                    System.out.println(validation);

                    if (!validation.equals("Message ready to send.")) {
                        break;
                    }

                    System.out.println("\n1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");
                    System.out.print("Choose option: ");

                    int option = input.nextInt();
                    input.nextLine();

                    String flag;

                    if (option == 1) {

                        flag = "Sent";

                    } else if (option == 2) {

                        flag = "Disregard";

                    } else if (option == 3) {

                        flag = "Stored";

                    } else {

                        System.out.println("Invalid option.");
                        break;
                    }

                    Message msg =
                            new Message(recipient, text, flag);

                    System.out.println(msg.sentMessage(option));

                    service.addMessage(msg);

                    if (option == 1) {

                        System.out.println("\n" +
                                msg.printMessage());

                        processedMessages++;
                    }

                    break;

                // ==========================================
                // RECENT MESSAGES
                // ==========================================

                case 2:

                    System.out.println("Coming Soon.");
                    break;

                // ==========================================
                // QUIT
                // ==========================================

                case 3:

                    System.out.println("Goodbye!");
                    break;

                // ==========================================
                // PART 3 MENU
                // ==========================================

                case 4:

                    int storedChoice;

                    do {

                        System.out.println(
                                "\n===== STORED MESSAGE MENU =====");

                        System.out.println(
                                "1. Display Stored Messages");

                        System.out.println(
                                "2. Display Longest Stored Message");

                        System.out.println(
                                "3. Display Report");

                        System.out.println(
                                "4. Back");

                        System.out.print("Choose option: ");

                        storedChoice = input.nextInt();
                        input.nextLine();

                        switch (storedChoice) {

                            case 1:
                                service.displayStoredMessages();
                                break;

                            case 2:
                                service.displayLongestStoredMessage();
                                break;

                            case 3:
                                service.displayReport();
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Invalid option.");
                        }

                    } while (storedChoice != 4);

                    break;

                default:

                    System.out.println("Invalid menu option.");
            }

        } while (choice != 3);

        System.out.println(
                "\nTotal Messages Processed: "
                + Message.returnTotalMessages());

        input.close();
    }
}