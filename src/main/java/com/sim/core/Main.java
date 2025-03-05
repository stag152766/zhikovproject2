package com.sim.core;

import com.sim.actions.CreateEntityAction;
import com.sim.actions.MovingAction;
import com.sim.entities.*;
import com.sim.render.ConsoleRenderer;
import com.sim.render.Renderer;

import java.util.List;

/*
Пошаговая симуляция 2D мира, населенного курьерами и злыми собаками.
Кроме существ, мир содержит ресурсы (кофе), которым питаются курьеры, и статические объекты,
с которыми нельзя взаимодействовать (дереья) они просто занимают место.

2D мир представляет из себя матрицу NxM, каждое существо или объект занимают клетку целиком,
нахождение в клетке нескольких объектов/существ - недопустимо.


Реализовать симуляцию - DONE
Настройка различных значений (размер поля, диапозоны НР, скорости, атаки хищников)
Приостановить бесконечный цикл симуляции и рендеринга из консоли
Рендерер (консольный интерфейс) - DONE
Поиск пути (алгоритм в ширину, А*) - рандомный DONE
 */
public class Main {
    public static void main(String[] args) {
        WorldMap map = new WorldMap(10, 10);
        Renderer renderer = new ConsoleRenderer();
        Simulation sim = new Simulation(map, renderer);

//        PathFinderStrategy randomPathFinder = new RandomPathFinder();
//        PathFinderStrategy smartPathFinder = new SmartPathFinder();

        List<BaseEntity> entities = List.of(
                new Dog(3, 20, 5),
                new Dog(3, 20, 5),
                new Dog(3, 20, 5),
                new DeliveryMan(1, 30),
                new DeliveryMan(1, 30),
                new DeliveryMan(1, 30),
                new Coffee(),
                new Coffee(),
                new Tree(),
                new Tree(),
                new Tree()
        );

        sim.addInitAction(new CreateEntityAction(entities));
        sim.addTurnAction(new MovingAction());

        sim.startSimulation();
    }
}
