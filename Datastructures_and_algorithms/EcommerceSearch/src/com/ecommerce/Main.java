package com.ecommerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Apparel"),
            new Product(103, "Book", "Education"),
            new Product(104, "Phone", "Electronics")
        };

        System.out.print("Enter product name to search: ");
        String inputName = sc.nextLine();

        int indexLinear = SearchEngine.linearSearch(products, inputName);
        if (indexLinear != -1)
            System.out.println("Linear Found: " + products[indexLinear]);
        else
            System.out.println("Not Found (Linear)");

        SearchEngine.sortProducts(products);
        int indexBinary = SearchEngine.binarySearch(products, inputName);
        if (indexBinary != -1)
            System.out.println("Binary Found: " + products[indexBinary]);
        else
            System.out.println("Not Found (Binary)");
    }
}

