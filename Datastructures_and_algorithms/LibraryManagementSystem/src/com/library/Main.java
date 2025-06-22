package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Programming", "James Gosling"),
            new Book(2, "Python Crash Course", "Eric Matthes"),
            new Book(3, "Data Structures", "Seymour Lipschutz"),
            new Book(4, "C Programming", "Dennis Ritchie")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title to search: ");
        String searchTitle = sc.nextLine();

        int indexLinear = BookSearch.linearSearch(books, searchTitle);
        if (indexLinear != -1)
            System.out.println("Found (Linear): " + books[indexLinear]);
        else
            System.out.println("Not Found (Linear)");

        BookSearch.sortBooks(books);

        int indexBinary = BookSearch.binarySearch(books, searchTitle);
        if (indexBinary != -1)
            System.out.println("Found (Binary): " + books[indexBinary]);
        else
            System.out.println("Not Found (Binary)");
        sc.close();
    }
}
