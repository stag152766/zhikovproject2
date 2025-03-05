package com.sim.actions;

import com.sim.core.Coordinates;
import com.sim.core.WorldMap;
import com.sim.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
public record CreateEntityAction(List<BaseEntity> entities) implements Action {

    @Override
    public void perform(WorldMap map) {
        setUpEntitiesWithDefaultPosition(map);
    }

    private void setUpEntitiesWithDefaultPosition(WorldMap map) {
        assertIsEmpty(map);
        entities.forEach(it -> setCoordinates(it, map));
    }

    private void setCoordinates(BaseEntity entity, WorldMap map) {
        Coordinates coordinates = generateRandomCoordinates();
        // TODO убрать дублирование
        entity.setCoordinates(coordinates);
        map.placeEntity(entity, coordinates);
    }

    private Coordinates generateRandomCoordinates() {
        Set<Coordinates> processedCoordinates = new HashSet<>();
        Random random = new Random();
        Coordinates next;
        do {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            next = new Coordinates(x, y);
        } while (processedCoordinates.contains(next));
        processedCoordinates.add(next);

        return next;
    }

    private static void assertIsEmpty(WorldMap map) {
        Set<Coordinates> occupiedCells = map.getOccupiedCells();
        if (!occupiedCells.isEmpty()) {
            System.out.println("Map is not empty! Cannot create new entity.");
        }
    }
}
