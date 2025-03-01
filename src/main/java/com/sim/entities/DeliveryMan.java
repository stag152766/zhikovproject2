package com.sim.entities;

/**
 * City courier who deliveries shipment by bicycle
 * run, get a resource (increase hp) or deliver shipment (decrease weight)
 */
public class DeliveryMan extends Creature {

    public DeliveryMan(int speed, int hp) {
        super(speed, hp);
    }

    @Override
    public String render() {
        return "M";
    }

    @Override
    protected boolean isInteractionAvailable(Entity neigh) {
        return false;
    }
}
