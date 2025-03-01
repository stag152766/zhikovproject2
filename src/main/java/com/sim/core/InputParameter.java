package com.sim.core;

import com.sim.actions.Action;
import com.sim.actions.CreateEntityAction;

import java.util.Scanner;

public class InputParameter {

    private final Scanner scanner = new Scanner(System.in);

    public Action buildCreationAction() {

        System.out.println("Enter dog amount: ");
        int dogCount = scanner.nextInt();

        System.out.println("Enter delivery man amount: ");
        int manCount = scanner.nextInt();

        System.out.println("Enter tree amount: ");
        int treeCount = scanner.nextInt();

        System.out.println("Enter coffee amount: ");
        int coffeeCount = scanner.nextInt();

        return new CreateEntityAction(manCount, dogCount, treeCount, coffeeCount);
    }
}
