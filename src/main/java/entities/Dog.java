package entities;

import core.Coordinates;
import core.SimMap;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * Angry dog that eat delivery man
 */
@Setter
@Getter
public class Dog extends Creature {
    private int attackPower;
    private Random random;

    public Dog(int speed, int hp, int attackPower) {
        super(speed, hp);
        this.attackPower = attackPower;
        this.random = new Random();
    }

    @Override
    public String render() {
        return "D";
    }

    @Override
    protected boolean isInteractionAvailable(Entity neigh) {
        if (neigh instanceof DeliveryMan){
            return true;
        }
        return false;
    }
}
