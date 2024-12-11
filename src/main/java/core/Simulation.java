package core;

import actions.Action;
import actions.CreatureMoving;
import actions.EntityCreation;
import entities.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {
    public static final int ROWS = 10;
    public static final int COLS = 10;
    private int turnCount = 0;
    private final Map<Coordinates, Entity> coordinatesToEntity = new HashMap<>();

    /**
     * запустить бесконечный цикл симуляции и рендеринга
     */
    public void startSimulation() {
        List<Action> initialActions = List.of(
                new EntityCreation(1, 1, 1, 1, 1));

        initActions(initialActions);
        renderMap(coordinatesToEntity);
        List<Action> turnActions = List.of(new CreatureMoving());

        while (true) {
            nextTurn(turnActions);
            break;
        }
    }

    private void renderMap(Map<Coordinates, Entity> map) {
        // M - delivery man
        // D - dog
        // C - coffee
        // T - tree
        // B - building
        String[][] field = new String[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int cols = 0; cols < COLS; cols++) {
                field[row][cols] = ".. ";
            }
        }

        map.forEach((c, e) -> {
            field[c.getX()][c.getY()] = " " + e.render() + " ";
        });

        System.out.println();
        System.out.println("_________________________________");
        for (int row = 0; row < ROWS; row++) {
            System.out.print("| ");
            for (int cols = 0; cols < COLS; cols++) {
                System.out.print(field[row][cols]);
            }
            System.out.println("|");
        }
    }

    /**
     * приостановить бесконечный цикл симуляции и рендеринга
     */
    private void pauseSimulation() {
    }

    /**
     * просимулировать и отрендерить один ход
     */
    private void nextTurn(List<Action> turnActions) {
        turnCount++;
        System.out.printf("Turn #%s", turnCount);
        turnActions(turnActions);
        renderMap(coordinatesToEntity);
    }

    /**
     * список действий, совершаемых перед стартом симуляции
     */
    private void initActions(Collection<Action> actions) {
        actions.forEach(action -> action.apply(coordinatesToEntity));
    }

    /**
     * список действий, совершаемых каждый ход
     */
    private void turnActions(Collection<Action> actions) {
    }
}
