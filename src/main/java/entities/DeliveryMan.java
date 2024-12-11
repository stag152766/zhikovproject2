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
    public void makeMove() {
        Coordinates currCoordinates = getCoordinates();
        Coordinates nextCoordinates = selectNextCell(currCoordinates);
        setCoordinates(nextCoordinates);
    }

    private Coordinates selectNextCell(Coordinates currCoordinates) {
        int x = currCoordinates.getX();
        int y = currCoordinates.getY();
        return new Coordinates(x, y);
    }

    @Override
    public String render() {
        return "M";
    }
}
