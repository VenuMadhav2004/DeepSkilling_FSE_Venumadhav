package com.finance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();
        System.out.print("Enter annual growth rate (e.g., 0.10 for 10%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double future = Forecast.futureValue(principal, rate, years);
        System.out.println("Predicted Value (recursive): ₹" + future);

        double[] memo = new double[years + 1];
        double futureOptimized = Forecast.futureValueMemo(principal, rate, years, memo);
        System.out.println("Predicted Value (optimized): ₹" + futureOptimized);
        sc.close();
    }
}

