package core;

import actions.Action;
import actions.MovingAction;

import java.util.Collection;
import java.util.List;

public class Simulation {
    private final WorldMap grid = new WorldMap();
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    private final InputParameters inputParameters = new InputParameters();

    public void startSimulationLoopWithRendering() {
        Action creation = inputParameters.initEntityCreationAction();
        List<Action> initialActions = List.of(creation);
        performActions(initialActions);

        renderer.render(grid);

        List<Action> turnActions = List.of(new MovingAction());

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
     * TODO приостановить бесконечный цикл симуляции и рендеринга
     */
    private void pauseSimulation() {
    }

    /**
     * просимулировать и отрендерить один ход
     */
    private void nextTurn(List<Action> turnActions) {
        performActions(turnActions);
        renderer.render(grid);
    }

    /**
     * список действий, совершаемых перед стартом симуляции
     */
    private void performActions(Collection<Action> actions) {
        actions.forEach(action -> action.perform(grid));
    }
}
