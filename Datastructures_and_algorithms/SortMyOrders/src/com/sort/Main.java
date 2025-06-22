package com.sort;

public class Main {
	public static void main(String[] args) {
	Order[] orders1 = {
            new Order(201, "Alice", 4500.50),
            new Order(202, "Bob", 1500.00),
            new Order(203, "Charlie", 7900.75),
            new Order(204, "Daisy", 3100.20)
        };

        Order[] orders2 = orders1.clone();

        System.out.println("Before Sorting:");
        for (Order o : orders1) System.out.println(o);

        OrderSorter.bubbleSort(orders1);
        System.out.println("\nSorted by Bubble Sort:");
        for (Order o : orders1) System.out.println(o);

        OrderSorter.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nSorted by Quick Sort:");
        for (Order o : orders2) System.out.println(o);
    }
}
