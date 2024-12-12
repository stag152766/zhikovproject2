package entities;

import core.CoordinatesShift;

import java.util.Collections;
import java.util.Set;

/**
 * The delivery man delivers packages here, reduce cargo weight
 */
public class Building extends Entity {
    @Override
    public String render() {
        return "B";
    }

    @Override
    protected Set<CoordinatesShift> getEntityMovesPattern() {
        return Collections.emptySet();
    }

    @Override
    protected boolean isInteractionAvailable(Entity neigh) {
        return false;
    }
}
