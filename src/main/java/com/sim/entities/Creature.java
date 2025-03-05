package com.sim.entities;

import com.sim.core.CoordinatesShift;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public abstract class Creature extends BaseEntity {
    // number of cells that can make per 1 turn
    private int speed;
    private int hp;

    public Creature(int speed, int hp) {
        this.speed = speed;
        this.hp = hp;
    }

    // допущение: перемещение на 1 соседнюю клетку
    @Override
    protected Set<CoordinatesShift> getEntityMovesPattern() {
        return Set.of(new CoordinatesShift(0,1),
                new CoordinatesShift(0,-1),
                new CoordinatesShift(-1,0),
                new CoordinatesShift(1,0),
                new CoordinatesShift(1,1),
                new CoordinatesShift(1,-1),
                new CoordinatesShift(-1,-1),
                new CoordinatesShift(-1,1)
        );
    }
}
