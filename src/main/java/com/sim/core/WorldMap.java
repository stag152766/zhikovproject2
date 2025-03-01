package com.sim.core;

import com.sim.entities.BaseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WorldMap {
    private int rows;
    private int columns;
    // дублирование, у каждой сущности есть координаты, чтобы она принимала решение куда и зачем ходить
    private final Map<Coordinates, BaseEntity> cells = new HashMap<>();


    public WorldMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        BaseEntity entity = getEntityAt(from);
        removeEntity(from);
        placeEntity(entity, to);
    }

    // TODO убрать дублирование
    public void placeEntity(BaseEntity entity, Coordinates coordinates) {
        entity.setCoordinates(coordinates);
        cells.put(coordinates, entity);
    }

    public boolean isEmptyCell(Coordinates coordinates) {
        return !(cells.containsKey(coordinates));
    }

    public BaseEntity getEntityAt(Coordinates coordinates) {
        return cells.get(coordinates);
    }

    public Set<Coordinates> getOccupiedCells() {
        return cells.keySet();
    }

    private void removeEntity(Coordinates coordinates){
        cells.remove(coordinates);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
