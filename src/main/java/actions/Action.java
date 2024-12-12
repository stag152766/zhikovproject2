package actions;

import core.SimMap;

/**
 * Совершает действия над картой
 */
public interface Action {
    void apply(SimMap map);
}
