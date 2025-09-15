import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String title;
    static String author;
    static int quantity;

    public static void main(String[] args) {

        Library library = new Library(100);

        library.addBook("The Hobbit", "J.R.R. Tolkien", 2);
        library.addBook("1984", "George Orwell", 1);
        library.addBook("To Kill", "Harper Lee", 3);
        library.addBook("The Catcher", "J.D. Salinger", 4);
        library.addBook("Harry Potter", "J.K. Rowling", 5);
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1);
        library.addBook("Moby Dick", "Herman Melville", 0);
        library.addBook("Pride and Prejudice", "Jane Austen", 2);
        library.addBook("The Lord of the Rings", "J.R.R. Tolkien", 1);
        library.addBook("Brave New World", "Aldous Huxley", 0);


        int choice;

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
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // view books
                    library.viewAllBooks();
                    break;

                case 2: // add books
                    getBookDetails();

                    library.addBook(title, author, quantity);

                    clearVariables();
                    break;
                
                
                case 3: // borrow books
                    getBookDetails();

                    library.borrowBook(title, author, quantity);

                    clearVariables();
                    break;

                // Return a book
                case 4:
                    getBookDetails();

                    library.returnBook(title, author, quantity);

                    clearVariables();
                    break;


                case 5:
                    library.viewAllLogs();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 6);

        System.out.println("See you again!");
        scanner.close();
    }

    static void getBookDetails() {
        System.out.println("Enter the book's title: ");
        title = scanner.nextLine();
        System.out.println("Enter the book's author: ");
        author = scanner.nextLine();
        System.out.println("Enter the quantity: ");
        quantity = scanner.nextInt();
    }

    static void clearVariables() {
        title = "";
        author = "";
        quantity = 0;
    }
}


class Library {
    Book[] books;
    Book[] records;

    public Library(int capacity) {
        books = new Book[capacity];
        records = new Book[capacity];
    }

    // specifed methods
    public void addBook(String title, String author, int quantity) {
        
        // We are adding both in the logs and the books

        // Step 1: check if book already exists
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null &&
                books[i].title.equalsIgnoreCase(title) &&
                books[i].author.equalsIgnoreCase(author)) {
                books[i].increaseQuantity(quantity);
                return; // done
            }
        }

        // Step 2: find first empty slot
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = new Book(title, author, quantity);
                return; // done
            }
        }

        System.out.println("Library is full. Cannot add more books.");

        // Step 1: check if book already exists
        for (int i = 0; i < records.length; i++) {
            if (records[i] != null &&
                records[i].title.equalsIgnoreCase(title) &&
                records[i].author.equalsIgnoreCase(author)) {
                records[i].increaseQuantity(quantity);
                return; // done
            }
        }

        // Step 2: find first empty slot
        for (int i = 0; i < records.length; i++) {
            if (records[i] == null) {
                records[i] = new Book(title, author, quantity);
                return; // done
            }
        }
    }

    public void borrowBook(String title, String author, int quantity) {

        Book targetBook = null;

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                targetBook = book;
                break;
            }
        }

        if (targetBook == null) {
            System.out.println("The title or author is incorrect!");
            return;
        }

        if (targetBook.quantity <= 0) {
            System.out.println("The quantity can't be zero or less!");
            return;
        }

        if (targetBook.quantity < quantity) {
            System.out.println("The quantity is not enough! Please borrow up to this amount " + targetBook.quantity);
            return;
        }

        // =======================================================================================

        Book loggedBook = null;

        for (Book book : records) {
            if (book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                loggedBook = book;
                break;
            }
        }

        // logic
        targetBook.decreaseQuantity(quantity);
        loggedBook.increaseQuantity(quantity);
    }

    public void returnBook(String title, String author, int quantity) {

        Book targetBook = null;

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                targetBook = book;
                break;
            }
        }

        if (targetBook == null) {
            System.out.println("The title or author is incorrect");
            return;
        }

        if (targetBook.quantity <= 0) {
            System.out.println("The quantity can't be zero or less!");
            return;
        }

        // =======================================================================================

        Book loggedBook = null;

        for (Book book : records) {
            if (book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                loggedBook = book;
                break;
            }
        }

        if (loggedBook.quantity < targetBook.quantity) {
            System.out.println("The books returned are more than the ones borrowed");
            return;
        }

        // logic
        targetBook.increaseQuantity(quantity);
        loggedBook.decreaseQuantity(quantity);

    }


    // utility methods

    public void viewAllBooks() {
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    public void viewAllLogs() {
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

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    public String toString() {
        return "Title: " + title +
               ", Author: " + author +
               ", Quantity: " + quantity;
    }
}
