package core;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(new SimMap(), new MapConsoleRenderer());
        simulation.startSimulation();
    }
}
