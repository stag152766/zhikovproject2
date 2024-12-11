package actions;

import core.Coordinates;
import entities.Entity;

import java.util.Map;

/**
 * Совершает действия над картой
 */
public interface Action {
    void apply(Map<Coordinates, Entity> map);
}
