package com.sim.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Angry dog that eat delivery man
 */
@Setter
@Getter
public class Dog extends Creature {
    private int attackPower;

    public Dog(int speed, int hp, int attackPower) {
        super(speed, hp);
        this.attackPower = attackPower;
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
