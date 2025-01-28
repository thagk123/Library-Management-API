import java.util.HashMap;

public class Admin_functions extends Library {

    private HashMap<Book, Integer> lib;

    // Ο constructor δέχεται ένα αντικείμενο Library και αρχικοποιεί το lib
    public Admin_functions(Library library) {
        this.lib = library.getLibrary();
    }

    // Προσθήκη βιβλίου με συγκεκριμένη ποσότητα
    public void addBook(Book book, int quantity) {
        lib.put(book, quantity); // Προσθήκη βιβλίου στη λίστα
        System.out.println("Book added");
    }

    // Διαγραφή βιβλίου από τη βιβλιοθήκη
    public void deleteBook(Book book) {
        lib.remove(book); // Αφαίρεση του βιβλίου από τη λίστα
        System.out.println("Book deleted");
    }

    // Ενημέρωση ποσότητας βιβλίου
    public void updateBook(Book book, int quantity) {
        lib.replace(book, lib.get(book), quantity); // Αντικατάσταση της ποσότητας
        System.out.println("Book updated");
    }
}
