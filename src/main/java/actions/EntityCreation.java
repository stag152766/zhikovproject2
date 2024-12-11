package actions;

import core.Coordinates;
import entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class EntityCreation implements Action {
    private final int manCount;
    private final int dogCount;
    private final int treeCount;
    private final int building;
    private final int coffeeCount;

    public EntityCreation(int manCount, int dogCount, int treeCount, int building, int coffeeCount) {
        this.manCount = manCount;
        this.dogCount = dogCount;
        this.treeCount = treeCount;
        this.building = building;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void apply(Map<Coordinates, Entity> map) {
        if (!map.isEmpty()) {
            System.out.println("Map is not empty! Cannot create new entity.");
        }

        for (int i = 0; i < dogCount; i++) {
            Entity dog = new Dog(1,30, 20);
            map.put(new Coordinates(1,2), dog);
        }

        for (int i = 0; i < manCount; i++) {
            Entity man = new DeliveryMan(2, 60);
            map.put(new Coordinates(2,3), man);
        }

        for (int i = 0; i < coffeeCount; i++) {
            Entity coffee = new Coffee(20);
            map.put(new Coordinates(3,1), coffee);
        }

        for (int i = 0; i < treeCount; i++) {
            Entity tree = new Tree();
            map.put(new Coordinates(3,6), tree);
        }
    }
}
