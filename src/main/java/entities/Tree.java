package entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Some static object
 */
@Getter
@Setter
public class Tree extends Entity {

    @Override
    public String render() {
        return "T";
    }
}
