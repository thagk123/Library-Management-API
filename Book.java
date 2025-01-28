public class Book {
    private String title, author; // Τίτλος και συγγραφέας βιβλίου

    // Constructor: Αρχικοποιεί το βιβλίο με τίτλο και συγγραφέα
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Επιστροφή του τίτλου
    public String getTitle() {
        return title;
    }

    // Επιστροφή του συγγραφέα
    public String getAuthor() {
        return author;
    }

    // Ενημέρωση του τίτλου
    public void setTitle(String title) {
        this.title = title;
    }

    // Ενημέρωση του συγγραφέα
    public void setAuthor(String author) {
        this.author = author;
    }
}
