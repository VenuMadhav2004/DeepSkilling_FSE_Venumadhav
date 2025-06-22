package com.task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();
        int choice;

        do {
            System.out.println("\n1. Add  2. Delete  3. Search  4. List  5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    tm.addTask(new Task(id, name, status));
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    tm.deleteTask(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    tm.searchTask(sc.nextInt());
                    break;
                case 4:
                    tm.traverseTasks();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        } while (choice != 5);
        sc.close();
    }
}
