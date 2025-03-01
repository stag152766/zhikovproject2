package com.sim.core;

import com.sim.actions.Action;
import com.sim.actions.MovingAction;
import com.sim.render.Renderer;

import java.util.Collection;
import java.util.List;

public class Simulation {
    private final WorldMap grid;
    private final Renderer renderer;
    private final List<Action> initialActions;
    private final List<Action> turnActions;

    public Simulation(WorldMap worldMap, Renderer render) {
        this.grid = worldMap;
        this.renderer = render;
        initialActions = List.of(new InputParameter().buildCreationAction());
        turnActions = List.of(new MovingAction());
    }

    public void startSimulation() {
        performActions(initialActions);
        renderer.render(grid);

        while (true) {
            nextTurn(turnActions);
            try {
                Thread.sleep(1000);
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
