package com.sim.core;

import com.sim.actions.Action;
import com.sim.render.Renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Simulation {
    private final WorldMap map;
    private final Renderer renderer;
    private final List<Action> initialActions;
    private final List<Action> turnActions;

    public Simulation(WorldMap map, Renderer render) {
        this.map = map;
        this.renderer = render;
        this.initialActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
    }

    public void startSimulation() {
        performActions(initialActions);
        renderer.render(map);

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
        renderer.render(map);
    }

    /**
     * список действий, совершаемых перед стартом симуляции
     */
    private void performActions(Collection<Action> actions) {
        actions.forEach(action -> action.perform(map));
    }

    public void addInitAction(Action action) {
        initialActions.add(action);
    }

    public void addTurnAction(Action action) {
        turnActions.add(action);
    }
}
