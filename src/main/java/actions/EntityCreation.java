package actions;

import core.Coordinates;
import core.SimMap;
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
    public void apply(SimMap simMap) {
        Map<Coordinates, Entity> map = simMap.getEntitiesOnMap();
        setUpEntitiesWithDefaultPosition(map);
    }

    private void setUpEntitiesWithDefaultPosition(Map<Coordinates, Entity> map) {
        if (!map.isEmpty()) {
            System.out.println("Map is not empty! Cannot create new entity.");
        }

        for (int i = 0; i < dogCount; i++) {
            Entity entity = new Dog(1, 30, 20);
            Coordinates coordinates = new Coordinates(0, 1);
            entity.setCoordinates(coordinates);
            map.put(coordinates, entity);
        }

        for (int i = 0; i < manCount; i++) {
            Entity entity = new DeliveryMan(2, 60);
            Coordinates coordinates = new Coordinates(0, 0);
            entity.setCoordinates(coordinates);
            map.put(coordinates, entity);
        }

        for (int i = 0; i < coffeeCount; i++) {
            Entity entity = new Coffee(20);
            Coordinates coordinates = new Coordinates(1, 5);
            entity.setCoordinates(coordinates);
            map.put(coordinates, entity);
        }

        for (int i = 0; i < treeCount; i++) {
            Entity entity = new Tree();
            Coordinates coordinates = new Coordinates(5, 8);
            entity.setCoordinates(coordinates);
            map.put(coordinates, entity);
        }
    }
}
