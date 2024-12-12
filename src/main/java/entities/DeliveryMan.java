package entities;

import core.Coordinates;

/**
 * City courier who deliveries shipment by bicycle
 */
public class DeliveryMan extends Creature {

    public DeliveryMan(int speed, int hp) {
        super(speed, hp);
    }

    // run, get a resource (increase hp) or deliver shipment (decrease weight)
    @Override
    public void makeMove(Coordinates next) {
        setCoordinates(next);
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
