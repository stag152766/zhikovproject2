package actions;

import entities.Entity;

import java.util.Map;
import java.util.Random;

/**
 * Set initial coordinates for all entities
 */
public class EntityLocation implements Action {
    @Override
    public void apply(Map<Entity, Integer[]> map) {
//        // create a snapshot
//        String[][] snapshot = getMapSnapshot(map);
//        // update it each time after adding entity
//
//        // to avoid re-writing - update the snapshot each time after adding entity to map
//
//
//        // for each entity set random coordinates
//        map.forEach((entity, coors) -> setCoordinates(coors));
    }

    private String[][] getMapSnapshot(Map<Entity, Integer[]> map) {

       return null;
    }

    private void setCoordinates(Integer[] coordinates) {
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        coordinates = new Integer[]{x, y};
    }
}
