package core;

import entities.Entity;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SimMap {
    // дублирование, у каждой сущности есть координаты чтобы она принимала решение куда и зачем ходить
    private final Map<Coordinates, Entity> entitiesOnMap = new HashMap<>();

    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.setCoordinates(coordinates);
        entitiesOnMap.put(coordinates, entity);
    }

    public void setUpEntityPositions() {

    }

    public boolean isEmptyCell(Coordinates coordinates) {
        return !(entitiesOnMap.containsKey(coordinates));
    }

    public Entity getEntity(Coordinates coordinates) {
        return entitiesOnMap.get(coordinates);
    }
}
