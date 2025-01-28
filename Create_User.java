import java.util.Scanner;

public class Create_User {

    private String username, password; // Όνομα χρήστη και κωδικός
    private Scanner sc;

    // Constructor: Αρχικοποιεί το αντικείμενο με Scanner για είσοδο δεδομένων
    public Create_User(Scanner sc) {
        this.sc = sc;
    }

    // Δημιουργία στοιχείων χρήστη
    public void create_credentials() {
        System.out.println("Put username");
        this.username = sc.nextLine(); // Εισαγωγή ονόματος χρήστη
        System.out.println("Put password");
        this.password = sc.nextLine(); // Εισαγωγή κωδικού
    }

    public void setAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Επιστροφή ονόματος χρήστη
    public String get_username() {
        return this.username;
    }

    // Επιστροφή κωδικού χρήστη
    public String get_password() {
        return this.password;
    }
}
