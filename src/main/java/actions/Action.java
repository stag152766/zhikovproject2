package actions;

import entities.Entity;

import java.util.Map;

/**
 * Совершает действия над картой
 */
public interface Action {
    void apply(Map<Entity, Integer[]> map);
}
