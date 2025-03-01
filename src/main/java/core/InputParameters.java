package core;

import actions.Action;
import actions.CreateEntityAction;

import java.util.Scanner;

public class InputParameters {

    private final Scanner scanner = new Scanner(System.in);

    public Action initEntityCreationAction() {

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
