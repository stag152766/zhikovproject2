package entities;

import core.CoordinatesShift;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Set;

/**
 * Some static object
 */
@Getter
@Setter
public class Tree extends Entity {

    @Override
    public String render() {
        return "T";
    }

    @Override
    protected boolean isInteractionAvailable(Entity entity) {
        return false;
    }

    @Override
    protected Set<CoordinatesShift> getEntityMovesPattern() {
        return Collections.emptySet();
    }
}