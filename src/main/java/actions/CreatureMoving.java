package actions;

import core.Coordinates;
import core.SimMap;
import entities.Entity;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CreatureMoving implements Action {
    @Override
    public void apply(SimMap map) {
        // for each creature make random move
        // be sure that new cell is empty
        Map<Coordinates, Entity> entitiesOnMap = map.getEntitiesOnMap();
        Iterator<Map.Entry<Coordinates, Entity>> iterator = entitiesOnMap.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Coordinates, Entity> entry = iterator.next();
            Entity entity = entry.getValue();
            Set<Coordinates> coordinates = entity.availableMoveCoordinates(map);
            Iterator<Coordinates> iteratorSet = coordinates.stream().iterator();
            Coordinates next = iteratorSet.next();
            entity.makeMove(next);
            entitiesOnMap.put(next, entity);
        }
    }
}
