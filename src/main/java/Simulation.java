import actions.*;
import entities.DeliveryMan;
import entities.Entity;
import entities.Tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {
    // Map size
    public static final int ROWS = 10;
    public static final int COLS = 10;
    private int turnCount = 0;
    private final Map<Entity, Integer[]> entityWithCoordinates = new HashMap<>();

    // range
    private static final int MAX_HP = 100;
    private static final int MAX_ATTACK_POWER = 50;

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
    }

    /**
     * запустить бесконечный цикл симуляции и рендеринга
     */
    private void startSimulation() {

        List<Action> initialActions = List.of(
                new EntityCreation(1,1,1,1,1),
                new EntityLocation(),
                new ExtraCoffee());

        initActions(initialActions);

        List<Action> turnActions = List.of(new CreatureMoving());

        while (true) {
            nextTurn(turnActions);
            break;
        }
    }

    private void renderMap(Map<Entity, Integer[]> map) {
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
        map.forEach((e,c) -> {field[c[0]][c[1]] = " " + e.render() + " ";});


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

    private String[][] initMap() {
        String[][] map = buildEmptyMap();
        initEntitiesWithCoordinates(map);
        return map;
    }

    private static String[][] buildEmptyMap() {
        String[][] map = new String[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                map[row][col] = "_";
            }
        }
        return map;
    }

    private Map<Entity, Integer[]> initEntitiesWithCoordinates(String[][] map) {
        // fill if empty
        // create and set static objects by parameters
        Entity tree = new Tree();
        Integer[] treeXY = {1, 2};
        entityWithCoordinates.put(tree, treeXY);
        map[treeXY[0]][treeXY[1]] = "T";

        Entity courier = new DeliveryMan(2, MAX_HP);
        Integer[] courierXY = {0, 0};
        entityWithCoordinates.put(courier, courierXY);
        map[courierXY[0]][courierXY[1]] = "M";

        return entityWithCoordinates;
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
        renderMap(entityWithCoordinates);
    }

    /**
     * список действий, совершаемых перед стартом симуляции
     */
    private void initActions(Collection<Action> actions) {
        actions.forEach(a -> a.apply(entityWithCoordinates));
    }

    /**
     * список действий, совершаемых каждый ход
     */
    private void turnActions(Collection<Action> actions) {
    }
}
