package com.sim.actions;

import com.sim.core.Coordinates;
import com.sim.core.WorldMap;
import com.sim.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
public class CreateEntityAction implements Action {
    private final int manCount;
    private final int dogCount;
    private final int treeCount;
    private final int coffeeCount;
    private final Set<Coordinates> processedCoordinates;
    private final Random random;

    public CreateEntityAction(int manCount, int dogCount, int treeCount, int coffeeCount) {
        this.manCount = manCount;
        this.dogCount = dogCount;
        this.treeCount = treeCount;
        this.coffeeCount = coffeeCount;
        processedCoordinates = new HashSet<>();
        random = new Random();
    }

    @Override
    public void perform(WorldMap map) {
        setUpEntitiesWithDefaultPosition(map);
    }

    // TODO убрать дублирование
    private void setUpEntitiesWithDefaultPosition(WorldMap map) {
        assertIsEmpty(map);

        for (int i = 0; i < dogCount; i++) {
            setCoordinates(new Dog(1, 30, 20), map);
        }

        for (int i = 0; i < manCount; i++) {
            setCoordinates(new DeliveryMan(2, 60), map);
        }

        for (int i = 0; i < coffeeCount; i++) {
            setCoordinates(new Coffee(20), map);
        }

        for (int i = 0; i < treeCount; i++) {
            setCoordinates(new Tree(), map);
        }
    }

    private void setCoordinates(Entity entity, WorldMap map) {
        setRandomCoordinates(entity, map);
    }

    private static void assertIsEmpty(WorldMap map) {
        Set<Coordinates> occupiedCells = map.getOccupiedCells();
        if (!occupiedCells.isEmpty()) {
            System.out.println("Map is not empty! Cannot create new entity.");
        }
    }

    private void setRandomCoordinates(Entity entity, WorldMap map) {
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
