package anudippractice;
import java.util.Arrays;
import java.util.Scanner;

public class librarySystem {
    public String[] bookTitles;
    public int count;

    public librarySystem(int capacity) {
        bookTitles = new String[capacity];
        count = 0;
    }

    public void addBookTitle(String title) {
        if (count == bookTitles.length) {
            System.out.println("The library is full. Cannot add more books.");
            return;
        }
        bookTitles[count] = title;
        count++;
    }

    public void removeBookTitle(String title) {
        int index = searchBookTitle(title);
        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            bookTitles[i] = bookTitles[i + 1];
        }
        bookTitles[count - 1] = null;
        count--;
    }

    public int searchBookTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (bookTitles[i].equals(title)) {
                return i;
            }
        }
        return -1; // Not found
    }

    public void listAllBookTitles() {
        if (count == 0) {
            System.out.println("No books in the library.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(bookTitles[i]);
        }
    }

    public void sortBookTitles() {
        Arrays.sort(bookTitles, 0, count);
    }

    public static void main(String[] args) {
        librarySystem library = new librarySystem(10); // Set capacity to 10 for example
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add a Book Title");
            System.out.println("2. Remove a Book Title");
            System.out.println("3. Search for a Book Title");
            System.out.println("4. List All Book Titles");
            System.out.println("5. Sort Book Titles");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String titleToAdd = scanner.nextLine();
                    library.addBookTitle(titleToAdd);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeBookTitle(titleToRemove);
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String titleToSearch = scanner.nextLine();
                    int index = library.searchBookTitle(titleToSearch);
                    if (index != -1) {
                        System.out.println("Book found at index: " + index);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    library.listAllBookTitles();
                    break;
                case 5:
                    library.sortBookTitles();
                    System.out.println("Books sorted.");
                    break;
                case 6:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}

