package actions;

import entities.Entity;

import java.util.Map;

public class CreatureMoving implements Action {

    @Override
    public void apply(Map<Entity, Integer[]> map) {
        // for each creature make random move
        // be sure that new cell is empty
//
//        String[][] snapshot = getStateSnapshot(map);
//        map.forEach((entity, coordinates) -> entity.makeMove());
    }

//    private String[][] getStateSnapshot(Map<Entity, Integer[]> map) {
//
//    }
}
