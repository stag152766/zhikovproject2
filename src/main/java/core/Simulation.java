package core;

import actions.Action;
import actions.CreatureMoving;
import actions.EntityCreation;

import java.util.Collection;
import java.util.List;

public class Simulation {

    public final SimMap simMap;
    public final MapConsoleRenderer renderer;

    public Simulation(SimMap simMap, MapConsoleRenderer renderer) {
        this.simMap = simMap;
        this.renderer = renderer;
    }

    /**
     * запустить бесконечный цикл симуляции и рендеринга
     */
    public void startSimulation() {
        List<Action> initialActions = List.of(
                new EntityCreation(simMap, 1, 1, 1, 1, 1)
        );

        initActions(initialActions);
        renderer.render(simMap.getEntitiesOnMap());
        List<Action> turnActions = List.of(new CreatureMoving());

        while (true) {
            nextTurn(turnActions);
            break;
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
        turnActions(turnActions);
        renderer.render(simMap.getEntitiesOnMap());
    }

    /**
     * список действий, совершаемых перед стартом симуляции
     */
    private void initActions(Collection<Action> actions) {
        actions.forEach(action -> action.apply(simMap));
    }

    /**
     * список действий, совершаемых каждый ход
     */
    private void turnActions(Collection<Action> actions) {
        actions.forEach(action -> action.apply(simMap));
    }
}
