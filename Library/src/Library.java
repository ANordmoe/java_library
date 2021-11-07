import java.util.*;

public class Library {
    // Add the missing implementation to this class
    String address;
    ArrayList<Book> arrListBooks = new ArrayList<Book>();

    public Library(String address) {
        this.address = address;
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void addBook(Book incomingBook) {
        arrListBooks.add(incomingBook);
    }

    public void borrowBook(String requestedBook) {

        int length = this.arrListBooks.size();

        for (int i = 0; i < length; i++) {
            // does the library have that book
            if (this.arrListBooks.get(i).getTitle().equals(requestedBook)) {
                System.out.println("We have that. Let's see if it's been checked out");
                // has it been borrowed
                if (this.arrListBooks.get(i).borrowed) {
                    System.out.println("Sorry, someone else has that book right now");
                    // if it hasn't
                } else if (!this.arrListBooks.get(i).borrowed) {
                    System.out.println("got it! here you go");
                }
            } else {
                System.out.println("Sorry, we don't have that in stock");
            }
        }
    }

    public void printAvailableBooks(){
        int length = this.arrListBooks.size();
        for (int i = 0; i < length; i++) {
            if (!this.arrListBooks.get(i).borrowed) {
                System.out.println(this.arrListBooks.get(i).getTitle());
            }
        }
        if (length == 0) {
            System.out.println("Nothing in the library.");
        }
    }

    public void returnBook(String title){
        int length = this.arrListBooks.size();
        for (int i = 0; i < length; i++) {
            if(this.arrListBooks.get(i).getTitle().equals(title)){
                this.arrListBooks.get(i).borrowed = false;
                System.out.println("thanks for returning " + title);
            }
        }
    }


    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries

        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}