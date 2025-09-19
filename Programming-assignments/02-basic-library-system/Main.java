import java.util.Scanner;

public class Main {
    // Scanner for user input
    static Scanner scanner = new Scanner(System.in);

    // Temporary storage for book details entered by user
    static String title;
    static String author;
    static int quantity;

    public static void main(String[] args) {

        // Create a library with a maximum capacity of 100 books
        Library library = new Library(100);

        // I google searched the term "Famous Books"
        library.addBook("Hamlet", "William Shakespeare", 2);
        library.addBook("The Lord of the Rings", "J.R.R. Tolkien", 1);
        library.addBook("The Hobbit", "J.R.R. Tolkien", 2);
        library.addBook("1984", "George Orwell", 1);
        library.addBook("The Alchemist", "Paulo Coelho", 3);
        library.addBook("The Catcher", "J.D. Salinger", 4);
        library.addBook("Harry Potter", "J.K. Rowling", 5);
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1);
        library.addBook("Moby Dick", "Herman Melville", 0);
        library.addBook("Brave New World", "Aldous Huxley", 0);

        int choice;

        // Menu loop continues until user chooses option 6 (Exit)
        do {
            System.out.println("\n\n");
            System.out.println("======| Library Menu |======");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. View all logs");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline after integer input

            switch (choice) {
                case 1: // View all books
                    library.viewAllBooks();
                    break;

                case 2: // Add books
                    getBookDetails(); // get book info from user
                    library.addBook(title, author, quantity);
                    clearVariables(); // reset temporary variables
                    break;

                case 3: // Borrow books
                    getBookDetails();
                    library.borrowBook(title, author, quantity);
                    clearVariables();
                    break;

                case 4: // Return books
                    getBookDetails();
                    library.returnBook(title, author, quantity);
                    clearVariables();
                    break;

                case 5: // View all logs
                    library.viewAllLogs();
                    break;

                default: // Handles invalid options
                if (choice != 6) {
                    System.out.println("Invalid choice. Try again.");
                }
                    break;
            }
        } while (choice != 6); // Exit when choice = 6

        System.out.println("See you again!");
        scanner.close();
    }

    // Helper method: collect book details from user
    static void getBookDetails() {
        System.out.println("Enter the book's title: ");
        title = scanner.nextLine();

        System.out.println("Enter the book's author: ");
        author = scanner.nextLine();
        
        System.out.println("Enter the quantity: ");
        quantity = scanner.nextInt();
    }

    // Helper method: reset input variables after each operation
    static void clearVariables() {
        title = "";
        author = "";
        quantity = 0;
    }
}


class Library {
    Book[] books;   // Represents the current state of the library
    Book[] records; // Logs all transactions (borrow/return history)

    public Library(int capacity) {
        books = new Book[capacity];
        records = new Book[capacity];
    }

    // Add a new book to the library, or increase quantity if it exists
    public void addBook(String title, String author, int quantity) {
        // 1. Check if book already exists in the library
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null &&
                books[i].title.equalsIgnoreCase(title) &&
                books[i].author.equalsIgnoreCase(author)) {

                // If found, increase quantity in both main collection and logs
                books[i].increaseQuantity(quantity);
                return;
            }
        }

        // 2. If it's a new book, insert into the first available slot
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = new Book(title, author, quantity);
                records[i] = new Book(title, author, 0);
                return;
            }
        }

        // If no slot is available, library is full
        System.out.println("Library is full. Cannot add more books.");
    }
    
    // Borrow a book (reduce quantity in library and log the transaction)
    public void borrowBook(String title, String author, int quantity) {
        Book targetBook = null;

        // Find the requested book in the library
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                targetBook = book;
                break;
            }
        }

        // If book not found
        if (targetBook == null) {
            System.out.println("The title or author is incorrect!");
            return;
        }

        // Validate availability
        if (quantity <= 0) {
            System.out.println("The quantity can't be zero or less!");
            return;
        }

        if (targetBook.quantity < quantity) {
            System.out.println("Not enough copies! Available: " + targetBook.quantity);
            return;
        }

        // Find matching record for logging
        Book loggedBook = null;
        for (Book book : records) {
            if (book != null && book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                loggedBook = book;
                break;
            }
        }

        if (loggedBook == null) {
            System.out.println("The title or author is incorrect!");
            return;
        }

        // Update quantities
        targetBook.decreaseQuantity(quantity); // reduce from stock
        loggedBook.increaseQuantity(quantity); // increase in log
    }

    // Return a book (increase quantity in library and update logs)
    public void returnBook(String title, String author, int quantity) {
        Book targetBook = null;

        // Find the requested book
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                targetBook = book;
                break;
            }
        }

        if (targetBook == null) {
            System.out.println("The title or author is incorrect");
            return;
        }

        if (quantity <= 0) {
            System.out.println("The quantity can't be zero or less!");
            return;
        }

        // Find matching record for logging
        Book loggedBook = null;
        for (Book book : records) {
            if (book != null && book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                loggedBook = book;
                break;
            }
        }

        // Validate against over-returning
        if (loggedBook.quantity < quantity) {
            System.out.println("The books returned are more than the ones borrowed");
            return;
        }

        // Update quantities
        targetBook.increaseQuantity(quantity); // add back to stock
        loggedBook.decreaseQuantity(quantity); // adjust logs
    }

    // Display all available books in the library
    public void viewAllBooks() {
        System.out.println("\n\n");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    // Display transaction logs (all borrow/return history)
    public void viewAllLogs() {
        System.out.println("\n\n");
        for (Book book : records) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }
}

class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Increase stock
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    // Decrease stock
    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    // String representation for printing
    public String toString() {
        return "Title: " + title +
            ", Author: " + author +
            ", Quantity: " + quantity;
    }
}
