import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String title;
    static String author;
    static int quantity;

    public static void main(String[] args) {

        Library libraryLog = new Library(100);
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
            System.out.println("2. Borrow a book");
            System.out.println("3. Add a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                // view books
                case 1:
                    library.viewAllBooks();
                    break;

                // borrow books
                case 2:
                    getBookDetails();

                    // logic
                    library.borrowBook(title, quantity);
                    libraryLog.addBook(title, author, quantity);

                    // clear variables
                    clearVariables();
                    break;

                // add books
                case 3:
                    getBookDetails();

                    // logic
                    library.addBook(title, author, quantity);

                    // clear variables
                    clearVariables();
                    break;

                // Return a book
                case 4:
                    getBookDetails();

                    // logic
                    if (libraryLog.doesExist(title, author, quantity)) {

                        library.returnBook(title, quantity);
                        libraryLog.returnBook(title, quantity);
                        System.out.println("Book Sucessfully returned!");

                    } else {
                        System.out.println("Incorrect book details, or Book does not belong to the library!");
                        
                    }

                    // clear variables
                    clearVariables();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 5);

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

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = new Book(title, author, quantity);
                break;

            } else {
                books[i].increaseQuantity(quantity);
            }
        }

        for (int i = 0; i < records.length; i++) {
            if (records[i] == null) {
                records[i] = new Book(title, author, quantity);
                break;

            } else {
                records[i].increaseQuantity(quantity);
            }
        }
    }

    public void borrowBook(String title, String author, int quantity) {

        Book targetBook = null;

        for (Book book : books) {
            if (book.title.equals(title) && book.author.equals(author) && book.quantity == quantity) {
                targetBook = book;
                break;
            }
        }

        if (targetBook == null) {
            System.out.println("0");
        }

        if (targetBook.quantity <= 0) {
            System.out.println("0");
        }

        if (targetBook.quantity < quantity) {
            System.out.println("0");
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
            System.out.println("0");
        }

        if (targetBook.quantity <= 0) {
            System.out.println("0");
        }

        // =======================================================================================

        Book loggedBook = null;

        for (Book book : records) {
            if (book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                loggedBook = book;
                break;
            }
        }

        if (loggedBook.quantity > targetBook.quantity) {
            System.out.println("0");
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
