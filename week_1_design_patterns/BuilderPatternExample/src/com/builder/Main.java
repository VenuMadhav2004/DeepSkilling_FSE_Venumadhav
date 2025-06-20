package com.builder;

public class Main {

	public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .build();
        Computer workstation = new Computer.Builder("AMD Ryzen 9", "64GB")
                .setStorage("2TB SSD")
                .setGraphicsCard("NVIDIA Quadro RTX")
                .build();

        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Workstation: " + workstation);
    }

}
