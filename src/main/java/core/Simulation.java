package core;

import actions.Action;
import actions.CreatureMoving;

import java.util.Collection;
import java.util.List;

public class Simulation {
    private final SimMap simMap = new SimMap();
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    private final InputParameters inputParameters = new InputParameters();

    /**
     * запустить бесконечный цикл симуляции и рендеринга
     */
    public void startSimulation() {
        Action creation = inputParameters.initEntityCreationAction();
        List<Action> initialActions = List.of(creation);

        initActions(initialActions);
        renderer.render(simMap);
        List<Action> turnActions = List.of(new CreatureMoving());

        while (true) {
            nextTurn(turnActions);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
        renderer.render(simMap);
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
