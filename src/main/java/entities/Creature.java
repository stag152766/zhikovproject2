package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature extends Entity {
    // number of cells that can make per 1 turn
    private int speed;
    private int hp;

    public Creature(int speed, int hp) {
        this.speed = speed;
        this.hp = hp;
    }
}
