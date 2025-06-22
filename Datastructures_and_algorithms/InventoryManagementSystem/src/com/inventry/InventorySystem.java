package com.inventry;

import java.util.HashMap;
import java.util.Scanner;

public class InventorySystem {
    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product added.");
    }

    public void updateProduct(int id, int quantity, double price) {
        Product p = inventory.get(id);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        if (inventory.remove(id) != null)
            System.out.println("Product removed.");
        else
            System.out.println("Product not found.");
    }

    public void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventorySystem inv = new InventorySystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. Display\n5. Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID, Name, Qty, Price: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int qty = sc.nextInt();
                    double price = sc.nextDouble();
                    inv.addProduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter ID, new Qty, new Price: ");
                    id = sc.nextInt();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inv.updateProduct(id, qty, price);
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    inv.deleteProduct(id);
                    break;

                case 4:
                    inv.displayInventory();
                    break;

                case 5:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}

