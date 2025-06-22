package com.employee;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(100);
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add  2. Search  3. Delete  4. List  5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Position: ");
                    String pos = sc.nextLine();
                    System.out.print("Salary: ");
                    double sal = sc.nextDouble();
                    manager.addEmployee(new Employee(id, name, pos, sal));
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    manager.searchEmployee(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    manager.deleteEmployee(sc.nextInt());
                    break;
                case 4:
                    manager.listEmployees();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (choice != 5);
        sc.close();
    }
}
