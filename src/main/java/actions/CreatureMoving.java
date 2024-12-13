package actions;

import core.Coordinates;
import core.SimMap;
import entities.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Все существа перемещаются по очереди в течение одного хода (как в шахматах)
 */
public class CreatureMoving implements Action {

    @Override
    public void apply(SimMap map) {
        Set<Coordinates> processedCoordinates = new HashSet<>();

        for (Coordinates from : new HashSet<>(map.getOccupiedCells())) {
            if (processedCoordinates.contains(from)) {
                continue;
            }

            Entity entity = map.getEntityAt(from);

            if (entity.canMove()) {
                Coordinates to = entity.makeMove(map);
                map.moveEntity(from, to);
                processedCoordinates.add(to);
            }
        }
    }
}
