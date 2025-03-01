package com.sim.actions;

import com.sim.core.Coordinates;
import com.sim.core.WorldMap;
import com.sim.entities.BaseEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Действие, при котором все существа перемещаются по очереди в течение одного хода
 */
public class MovingAction implements Action {

    @Override
    public void perform(WorldMap map) {
        makeMove(map);
    }

    private void makeMove(WorldMap map) {
        Set<Coordinates> processedCoordinates = new HashSet<>();

        // работаем с актуальными данными после перемещения каждого существа
        for (Coordinates from : new HashSet<>(map.getOccupiedCells())) {
            if (processedCoordinates.contains(from)) {
                continue;
            }

            BaseEntity entity = map.getEntityAt(from);

            if (entity.canMove()) {
                Coordinates to = entity.act(map);
                // из-за дублирования (сущность и мапа содержат координаты)
                // мы вынуждены обновлять мапу (логика инкапсулирована, но приходится обновлять в обоих местах)
                // потенциальное место для ошибок
                // TODO подумать как улучшить
                map.moveEntity(from, to);
                processedCoordinates.add(to);
            }
        }
    }
}
