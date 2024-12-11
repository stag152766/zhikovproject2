package actions;

import core.Coordinates;
import entities.Entity;

import java.util.Map;

public class CreatureMoving implements Action {
    @Override
    public void apply(Map<Coordinates, Entity> map) {
        // for each creature make random move
        // be sure that new cell is empty
    }
}
