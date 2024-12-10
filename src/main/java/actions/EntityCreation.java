package actions;

import entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class EntityCreation implements Action {
    private int manCount;
    private int dogCount;
    private int treeCount;
    private int building;
    private int coffeeCount;

    public EntityCreation(int manCount, int dogCount, int treeCount, int building, int coffeeCount) {
        this.manCount = manCount;
        this.dogCount = dogCount;
        this.treeCount = treeCount;
        this.building = building;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void apply(Map<Entity, Integer[]> map) {
        if (!map.isEmpty()) {
            System.out.println("Map is not empty! Cannot create new entity.");
        }

        for (int i = 0; i < dogCount; i++) {
            Entity dog = new Dog(1,30, 20);
            map.put(dog, new Integer[]{1 ,5});
        }

        for (int i = 0; i < manCount; i++) {
            Entity man = new DeliveryMan(2, 60);
            map.put(man, new Integer[]{2 ,3});
        }

        for (int i = 0; i < coffeeCount; i++) {
            Entity coffee = new Coffee(20);
            map.put(coffee, new Integer[]{5 ,3});
        }

        for (int i = 0; i < treeCount; i++) {
            Entity tree = new Tree();
            map.put(tree, new Integer[]{5 ,8});
        }
    }
}
