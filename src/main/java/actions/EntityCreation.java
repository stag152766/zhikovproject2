package actions;

import core.Coordinates;
import core.SimMap;
import entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EntityCreation implements Action {
    private final int manCount;
    private final int dogCount;
    private final int treeCount;
    private final int building;
    private final int coffeeCount;
    private final SimMap simMap;

    public EntityCreation(SimMap simMap, int manCount, int dogCount, int treeCount, int building, int coffeeCount) {
        this.simMap = simMap;
        this.manCount = manCount;
        this.dogCount = dogCount;
        this.treeCount = treeCount;
        this.building = building;
        this.coffeeCount = coffeeCount;
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
            setCoordinates(0, 1, entity, map);
        }

        for (int i = 0; i < manCount; i++) {
            Entity entity = new DeliveryMan(2, 60);
            setCoordinates(0, 0, entity, map);
        }

        for (int i = 0; i < coffeeCount; i++) {
            Entity entity = new Coffee(20);
            setCoordinates(1, 5, entity, map);
        }

        for (int i = 0; i < treeCount; i++) {
            Entity entity = new Tree();
            setCoordinates(5, 8, entity, map);
        }
    }

    private void setCoordinates(int x, int y, Entity entity, SimMap map) {
        Coordinates coordinates = new Coordinates(x, y);
        entity.setCoordinates(coordinates);
        map.placeEntity(entity, coordinates);
    }
}
