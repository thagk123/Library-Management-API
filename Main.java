import java.util.ArrayList; // Για τη χρήση της λίστας ArrayList
import java.util.Scanner; // Για είσοδο από το πληκτρολόγιο

public class Main {
    public static void main(String[] args) {
        Library library = new Library(); // Δημιουργία ενός αντικειμένου Library (βιβλιοθήκης)
        Scanner sc = new Scanner(System.in); // Scanner για είσοδο δεδομένων από τον χρήστη

        // Δημιουργία διαχειριστή (admin)
        Create_User admin = new Create_User(sc);
        admin.setAdmin("Thanos", "123"); // Ορισμός των στοιχείων του διαχειριστή (όνομα χρήστη και κωδικός)

        Admin_functions admin_functions = new Admin_functions(library); // Σύνδεση του admin με τη βιβλιοθήκη

        // Προσθήκη βιβλίων από τον διαχειριστή
        Book book = new Book("The Hobbit", "J.R.R. Tolkien");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("No Longer Human", "Osamu Dazai");

        admin_functions.addBook(book, 4); // Προσθήκη του βιβλίου "The Hobbit" με 4 αντίτυπα
        admin_functions.addBook(book2, 5); // Προσθήκη του βιβλίου "1984" με 5 αντίτυπα
        admin_functions.addBook(book3, 0); // Προσθήκη του βιβλίου "No Longer Human" με 0 αντίτυπα (μη διαθέσιμο)

        ArrayList<Create_User> users = new ArrayList<>(); // Δημιουργία λίστας χρηστών (user accounts)

        // Ερώτηση στον χρήστη αν είναι χρήστης ή διαχειριστής
        System.out.println("Are you a user or an admin?");
        String str = sc.nextLine();

        if (str.equals("user")) { // Αν είναι χρήστης
            System.out.println("Create an account");
            Create_User user = new Create_User(sc); // Δημιουργία λογαριασμού χρήστη
            user.create_credentials(); // Εισαγωγή στοιχείων χρήστη (username και password)
            System.out.println(user.get_username()); // Εμφάνιση ονόματος χρήστη
            System.out.println(user.get_password()); // Εμφάνιση κωδικού χρήστη
            users.add(user); // Προσθήκη του χρήστη στη λίστα

            // Παροχή επιλογών στον χρήστη
            System.out.println("Press '1' to search a book, '2' to see available books, '3' to rent a book that is free, '4' to return a book and '5' to exit");
            while (true) { // Επανάληψη για επιλογές χρήστη
                int number2 = Integer.parseInt(sc.nextLine()); // Λήψη επιλογής χρήστη
                switch (number2) {
                    case 1: // Αναζήτηση βιβλίου
                        System.out.println(library.get_specific_book(sc.nextLine()));
                        break;
                    case 2: // Εμφάνιση διαθέσιμων βιβλίων
                        library.see_availability();
                        break;
                    case 3: // Ενοικίαση βιβλίου
                        System.out.println("Enter the name or the author of the book you want to rent");
                        String na_au = sc.nextLine();
                        if (library.getBook(na_au) == null) { // Έλεγχος αν υπάρχει το βιβλίο
                            System.out.println("No book found with the given title or author press the number again");
                        } else {
                            library.rentBook(library.getBook(na_au)); // Ενοικίαση βιβλίου
                        }
                        break;
                    case 4: // Επιστροφή βιβλίου
                        System.out.println("Enter the name or the author of the book you want to return");
                        String na_au_2 = sc.nextLine();
                        if (library.getBook(na_au_2) == null) { // Έλεγχος αν υπάρχει το βιβλίο
                            System.out.println("No book found with the given title or author press the number again");
                        } else {
                            library.returnBook(library.getBook(na_au_2)); // Επιστροφή βιβλίου
                        }
                        break;
                    case 5: // Έξοδος
                        System.exit(0);
                }
            }
        }
        // Αν είναι admin
        else {
            while (true) { // Είσοδος διαχειριστή
                System.out.println("Log in");
                System.out.println("Enter your username");
                String username = sc.nextLine();
                System.out.println("Enter your password");
                String password = sc.nextLine();
                if (!admin.get_username().equals(username) || !admin.get_password().equals(password)) { // Έλεγχος στοιχείων admin
                    System.out.println("Wrong credentials");
                    continue;
                }
                break; // Σωστά στοιχεία, προχωράει στο μενού admin
            }

            // Παροχή επιλογών στον admin
            System.out.println("Press '1' to add a book, '2' to remove a book, '3' to update a book and '4' to exit");
            while (true) { // Επανάληψη για επιλογές admin
                int number3 = Integer.parseInt(sc.nextLine()); // Λήψη επιλογής admin
                switch (number3) {
                    case 1: // Προσθήκη βιβλίου
                        System.out.println("Enter the title of the book you want to add");
                        String title = sc.nextLine();
                        System.out.println("Enter the author of the book you want to add");
                        String author = sc.nextLine();
                        System.out.println("Enter the quantity of the book you want to add");
                        int quantity = Integer.parseInt(sc.nextLine());
                        Book book6 = new Book(title, author);
                        admin_functions.addBook(book6, quantity);
                        break;
                    case 2: // Αφαίρεση βιβλίου
                        System.out.println("Enter the title or the author of the book you want to remove");
                        String na_au_2 = sc.nextLine();
                        if (library.getBook(na_au_2) == null) { // Έλεγχος αν υπάρχει το βιβλίο
                            System.out.println("No book found with the given title or author press the number again");
                        } else {
                            admin_functions.deleteBook(library.getBook(na_au_2)); // Διαγραφή βιβλίου
                        }
                        break;
                    case 3: // Ενημέρωση ποσότητας βιβλίου
                        System.out.println("Enter the title or the author of the book you want to update and then the new after you press enter");
                        String na_au_3 = sc.nextLine();
                        if (library.getBook(na_au_3) == null) { // Έλεγχος αν υπάρχει το βιβλίο
                            System.out.println("No book found with the given title or author press the number again");
                        } else {
                            int num = Integer.parseInt(sc.nextLine());
                            admin_functions.updateBook(library.getBook(na_au_3), num); // Ενημέρωση ποσότητας
                        }
                        break;
                    case 4: // Έξοδος
                        System.exit(0);
                }
            }
        }
    }
}