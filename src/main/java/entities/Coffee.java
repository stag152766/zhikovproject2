package entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Resource for delivery man that increase energy (hp)
 */
@Getter
@Setter
public class Coffee extends Entity {
    private int hp;

    public Coffee(int hp) {
        this.hp = hp;
    }

    @Override
    public void makeMove() {
        // nothing
    }

    @Override
    public String render() {
        return "C";
    }
}
