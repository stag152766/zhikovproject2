package entities;

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
        // Поиск пути
    }

    @Override
    public String render() {
        return "M";
    }
}
