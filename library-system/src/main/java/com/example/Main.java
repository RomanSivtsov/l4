package com.example;

import com.example.library.Book;
import com.example.library.Library;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library1 = new Library("Central Library");
    private static Library library2 = new Library("City Library");

    public static void main(String[] args) {
        initializeLibraries();
        printInitialBooks();

        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBookFromUserInput();
                    break;
                case "2":
                    printBooksByAuthor();
                    break;
                case "3":
                    printBookDetails();
                    break;
                case "4":
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }

    private static void initializeLibraries() {
        library1.addBook(new Book("1984", "George Orwell", 1949));
        library1.addBook(new Book("Animal Farm", "George Orwell", 1945));
        library1.addBook(new Book("War and Peace", "Leo Tolstoy", 1869));
        library2.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866));
        library2.addBook(new Book("1984", "George Orwell", 1949));
    }

    private static void printInitialBooks() {
        System.out.println("Initial books in the libraries:");
        System.out.println("Library: " + library1.getName());
        library1.printAllBooks();
        System.out.println("Library: " + library2.getName());
        library2.printAllBooks();
    }

    private static void displayMenu() {
        System.out.println("\nChoose an action:");
        System.out.println("1. Add a book");
        System.out.println("2. Display all books by an author from each library");
        System.out.println("3. Display book details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBookFromUserInput() {
        System.out.println("\nEnter book details:");
        System.out.print("Book title: ");
        String title = scanner.nextLine();
        System.out.print("Book author: ");
        String author = scanner.nextLine();
        System.out.print("Year of publication: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Choose a library:");
        System.out.println("1. " + library1.getName());
        System.out.println("2. " + library2.getName());
        System.out.print("Enter the library number: ");
        int libraryIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (libraryIndex < 0 || libraryIndex >= 2) {
            System.out.println("Invalid library number.");
            return;
        }

        if (libraryIndex == 0) {
            library1.addBook(new Book(title, author, year));
            System.out.println("The book \"" + title + "\" was added to \"" + library1.getName() + "\".");
        } else {
            library2.addBook(new Book(title, author, year));
            System.out.println("The book \"" + title + "\" was added to \"" + library2.getName() + "\".");
        }
    }

    private static void printBooksByAuthor() {
        System.out.print("Enter the author's name: ");
        String author = scanner.nextLine();

        System.out.println("\nBooks by \"" + author + "\" in the libraries:");
        System.out.println("Library: " + library1.getName());
        library1.printBooksByAuthor(author);
        System.out.println("Library: " + library2.getName());
        library2.printBooksByAuthor(author);
    }

    private static void printBookDetails() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        System.out.println("Checking the libraries:");
        library1.findBookByTitle(title);
        library2.findBookByTitle(title);
    }
}