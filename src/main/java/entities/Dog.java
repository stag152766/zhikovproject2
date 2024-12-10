package entities;

import lombok.AllArgsConstructor;
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
    public void makeMove() {
        // attack man
        // run (move to man)
    }

    @Override
    public String render() {
        return "D";
    }
}
