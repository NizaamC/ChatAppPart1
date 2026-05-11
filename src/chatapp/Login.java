 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
 package chatapp;
      
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
/**
 *
 * @author nizaam
 */


public class Login {

    // ================= VALIDATION =================

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }

    public boolean checkCellphoneNumber(String cellPhone) {

        if (cellPhone.startsWith("0") && cellPhone.length() == 10) {
            cellPhone = "+27" + cellPhone.substring(1);
        }

        return cellPhone.matches("^\\+27\\d{9}$");
    }

    // ================= REGISTER =================

    public String registerUser(String username, String password,
                               String cellPhone, String firstName, String lastName) {

        if (!checkUserName(username)) return "Invalid username.";
        if (!checkPasswordComplexity(password)) return "Invalid password.";
        if (!checkCellphoneNumber(cellPhone)) return "Invalid phone.";

        if (cellPhone.startsWith("0")) {
            cellPhone = "+27" + cellPhone.substring(1);
        }

        saveUserToJSON(username, password, firstName, lastName, cellPhone);

        return "User registered successfully.";
    }

    // ================= LOGIN =================

    public boolean loginUser(String username, String password) {

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("users.json"));

            JSONArray users = (JSONArray) obj;

            for (Object o : users) {
                JSONObject user = (JSONObject) o;

                if (user.get("username").equals(username) &&
                    user.get("password").equals(password)) {
                    return true;
                }
            }

        } catch (Exception e) {
            return false;
        }

        return false;
    }

    // ================= SAVE (APPEND FIXED) =================

    private void saveUserToJSON(String username, String password,
                                String firstName, String lastName, String cellPhone) {

        JSONArray users = new JSONArray();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("users.json"));
            users = (JSONArray) obj;
        } catch (Exception e) {
            // File doesn't exist yet → start fresh
        }

        JSONObject newUser = new JSONObject();
        newUser.put("username", username);
        newUser.put("password", password);
        newUser.put("firstName", firstName);
        newUser.put("lastName", lastName);
        newUser.put("cellPhone", cellPhone);

        users.add(newUser);

        try (FileWriter file = new FileWriter("users.json")) {
            file.write(users.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}