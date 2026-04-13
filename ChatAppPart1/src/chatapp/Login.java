package chatapp;

public class Login {

    private User registeredUser;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";
        return password.matches(regex);
    }

    // ✅ FIXED: Accepts 079... and +27...
    public boolean checkCellphoneNumber(String cellPhone) {

        // Remove spaces
        cellPhone = cellPhone.trim();

        // Convert local SA format → international
        if (cellPhone.startsWith("0") && cellPhone.length() == 10) {
            cellPhone = "+27" + cellPhone.substring(1);
        }

        String regex = "^\\+27\\d{9}$";
        return cellPhone.matches(regex);
    }

    public String registerUser(String username, String password, String cellPhone,
                               String firstName, String lastName) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellphoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        // ✅ Convert BEFORE storing
        cellPhone = cellPhone.trim();
        if (cellPhone.startsWith("0") && cellPhone.length() == 10) {
            cellPhone = "+27" + cellPhone.substring(1);
        }

        registeredUser = new User(username, password, cellPhone, firstName, lastName);

        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        if (registeredUser == null) return false;

        return registeredUser.getUsername().equals(username) &&
               registeredUser.getPassword().equals(password);
    }

    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + registeredUser.getFirstName() + ", " +
                   registeredUser.getLastName() +
                   " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}