package core;

import entities.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimMap {
    // дублирование, у каждой сущности есть координаты чтобы она принимала решение куда и зачем ходить
    private final Map<Coordinates, Entity> cells = new HashMap<>();

    public void placeEntity(Entity entity, Coordinates coordinates) {
        entity.setCoordinates(coordinates);
        cells.put(coordinates, entity);
    }

    public void setUpEntityPositions() {

    }

    public boolean isEmptyCell(Coordinates coordinates) {
        return !(cells.containsKey(coordinates));
    }

    public Entity getEntityAt(Coordinates coordinates) {
        return cells.get(coordinates);
    }

    public Set<Coordinates> getOccupiedCells() {
        return cells.keySet();
    }

    public void removeEntity(Coordinates coordinates){
        cells.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntityAt(from);
        removeEntity(from);

        placeEntity(entity, to);
    }
}
