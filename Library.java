import java.util.HashMap;

public class Library {
    private HashMap<Book, Integer> library; // Βιβλιοθήκη που αποθηκεύει βιβλία και ποσότητες

    // Constructor: Αρχικοποιεί την κεντρική λίστα βιβλιοθήκης
    public Library() {
        this.library = new HashMap<>();
    }

    // Επιστροφή της βιβλιοθήκης
    public HashMap<Book, Integer> getLibrary() {
        return library;
    }

    // Εύρεση βιβλίου με βάση τον τίτλο ή τον συγγραφέα
    public Book getBook(String str) {
        for (Book book : library.keySet()) {
            // Επιστροφή αν υπάρχει αντιστοιχία με τίτλο ή συγγραφέα
            if ((book.getTitle().equals(str) || book.getAuthor().equals(str))) {
                return book;
            }
        }
        return null; // Αν δεν βρεθεί το βιβλίο
    }

    // Ενοικίαση βιβλίου
    public void rentBook(Book book) {
        if (library.get(book) > 0) {
            // Μείωση ποσότητας αν είναι διαθέσιμο
            library.replace(book, library.get(book), library.get(book) - 1);
            System.out.println("Book rented");
        } else {
            System.out.println("Book is not available");
        }
    }

    // Επιστροφή βιβλίου
    public void returnBook(Book book) {
        // Αύξηση ποσότητας του βιβλίου
        library.replace(book, library.get(book), library.get(book) + 1);
        System.out.println("Book returned");
    }

    int i = 0; // Μετρητής για εμφάνιση βιβλίων

    // Εμφάνιση διαθέσιμων βιβλίων
    public void see_availability() {
        System.out.println("Available books:");
        for (int quantity : library.values()) {
            if (quantity > 0) {
                System.out.println(library.keySet().toArray()[i]); // Εκτύπωση βιβλίου
            }
        }
        i++;
    }

    // Εύρεση συγκεκριμένου βιβλίου (τίτλος ή συγγραφέας)
    public String get_specific_book(String str) {
        for (Book book : library.keySet()) {
            // Επιστροφή βιβλίου αν είναι διαθέσιμο
            if ((book.getTitle().equals(str) || book.getAuthor().equals(str)) && library.get(book) > 0) {
                int quantity = library.get(book);
                return "Book: " + book.getTitle() + ", Quantity: " + quantity;
            }
        }
        return "No book found with the given title or author, or it is not available.";
    }
}
