package entities;

/**
 * The delivery man delivers packages here, reduce cargo weight
 */
public class Building extends Entity {
    @Override
    public String render() {
        return "B";
    }
}
