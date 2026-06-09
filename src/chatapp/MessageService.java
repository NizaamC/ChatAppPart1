/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author nizaam
 */

public class MessageService {

private ArrayList<Message> sentMessages = new ArrayList<>();
private ArrayList<Message> storedMessages = new ArrayList<>();
private ArrayList<Message> disregardedMessages = new ArrayList<>();

    // ================= ADD MESSAGE =================
public void addMessage(Message msg) {

    if(msg.getFlag().equalsIgnoreCase("Sent")) {
        sentMessages.add(msg);
    }

    if(msg.getFlag().equalsIgnoreCase("Stored")) {
        storedMessages.add(msg);
    }

    if(msg.getFlag().equalsIgnoreCase("Disregard")) {
        disregardedMessages.add(msg);
    }

    saveMessageToJSON(msg);
}

    // ================= SAVE TO JSON =================
    private void saveMessageToJSON(Message msg) {

        JSONArray messageList = new JSONArray();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("messages.json"));
            messageList = (JSONArray) obj;
        } catch (Exception e) {
            // File doesn't exist yet → start fresh
        }

        JSONObject newMsg = new JSONObject();
        newMsg.put("id", msg.getMessageID());
        newMsg.put("hash", msg.getMessageHash());
        newMsg.put("recipient", msg.getRecipient());
        newMsg.put("message", msg.getMessageText());

        messageList.add(newMsg);

        try (FileWriter file = new FileWriter("messages.json")) {
            file.write(messageList.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= VIEW MESSAGES =================
    public void readStoredMessages() {

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("messages.json"));

            JSONArray messageList = (JSONArray) obj;

            for (Object o : messageList) {
                JSONObject msg = (JSONObject) o;

                System.out.println("----------------------");
                System.out.println("Message ID: " + msg.get("id"));
                System.out.println("Hash: " + msg.get("hash"));
                System.out.println("Recipient: " + msg.get("recipient"));
                System.out.println("Message: " + msg.get("message"));
            }

        } catch (Exception e) {
            System.out.println("No stored messages.");
        }
}

// NEW METHODS GO HERE

public void displayStoredMessages() {

    for(Message msg : storedMessages) {

        System.out.println("--------------------");
        System.out.println("Recipient: " + msg.getRecipient());
        System.out.println("Message: " + msg.getMessageText());
    }
}

public void displayLongestStoredMessage() {

    if(storedMessages.isEmpty()) {
        System.out.println("No stored messages.");
        return;
    }

    Message longest = storedMessages.get(0);

    for(Message msg : storedMessages) {

        if(msg.getMessageText().length() >
           longest.getMessageText().length()) {

            longest = msg;
        }
    }

    System.out.println(longest.getMessageText());
}

public void displayReport() {

    System.out.println("\n===== REPORT =====");

    for(Message msg : sentMessages) {

        System.out.println("--------------------");
        System.out.println("Hash: " + msg.getMessageHash());
        System.out.println("Recipient: " + msg.getRecipient());
        System.out.println("Message: " + msg.getMessageText());
    }
}

}