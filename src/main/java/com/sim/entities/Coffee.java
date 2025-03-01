package com.sim.entities;

import com.sim.core.CoordinatesShift;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Resource for delivery man that increase energy (hp)
 */
@Getter
@Setter
public class Coffee extends BaseEntity {
    private int hp;

    public Coffee(int hp) {
        this.hp = hp;
    }

    @Override
    protected Set<CoordinatesShift> getEntityMovesPattern() {
        return Set.of();
    }

    @Override
    protected boolean isInteractionAvailable(BaseEntity neigh) {
        return false;
    }
}
