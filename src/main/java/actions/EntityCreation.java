package actions;

import core.Coordinates;
import core.SimMap;
import entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
public class EntityCreation implements Action {
    private final int manCount;
    private final int dogCount;
    private final int treeCount;
    private final int coffeeCount;
    private final Set<Coordinates> processedCoordinates;
    private final Random random;

    public EntityCreation(int manCount, int dogCount, int treeCount, int coffeeCount) {
        this.manCount = manCount;
        this.dogCount = dogCount;
        this.treeCount = treeCount;
        this.coffeeCount = coffeeCount;
        this.processedCoordinates = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public void apply(SimMap map) {
        Set<Coordinates> occupiedCells = map.getOccupiedCells();
        if (!occupiedCells.isEmpty()) {
            System.out.println("Map is not empty! Cannot create new entity.");
        }

        setUpEntitiesWithDefaultPosition(map);
    }

    private void setUpEntitiesWithDefaultPosition(SimMap map) {
        for (int i = 0; i < dogCount; i++) {
            Entity entity = new Dog(1, 30, 20);
            setRandomCoordinates(entity, map);
        }

        for (int i = 0; i < manCount; i++) {
            Entity entity = new DeliveryMan(2, 60);
            setRandomCoordinates(entity, map);
        }

        for (int i = 0; i < coffeeCount; i++) {
            Entity entity = new Coffee(20);
            setRandomCoordinates(entity, map);
        }

        for (int i = 0; i < treeCount; i++) {
            Entity entity = new Tree();
            setRandomCoordinates(entity, map);
        }
    }

    private void setRandomCoordinates(Entity entity, SimMap map) {
        Coordinates coordinates = generateRandomCoordinates();
        entity.setCoordinates(coordinates);
        map.placeEntity(entity, coordinates);
    }

    private Coordinates generateRandomCoordinates() {
        Coordinates next;
        do {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            next = new Coordinates(x, y);
        } while (processedCoordinates.contains(next));
        processedCoordinates.add(next);

        return next;
    }
}
