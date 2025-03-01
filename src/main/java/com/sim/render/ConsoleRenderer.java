package com.sim.render;

import com.sim.core.Coordinates;
import com.sim.core.WorldMap;
import com.sim.entities.Entity;

import java.util.Set;

public class ConsoleRenderer implements Renderer {
    private int turnCount = 0;
    private int rows;
    private int cols;

    @Override
    public void render(WorldMap map) {
        this.rows = map.getRows();
        this.cols = map.getColumns();
        String[][] field = createEmptyField();
        setEntityLocation(map, field);
        printResult(field);
    }

    private String[][] createEmptyField() {
        String[][] field = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                field[row][col] = ".. ";
            }
        }
        return field;
    }

    private void setEntityLocation(WorldMap map, String[][] field) {
        Set<Coordinates> occupiedCells = map.getOccupiedCells();
        for (Coordinates cell: occupiedCells) {
            Entity entity = map.getEntityAt(cell);
            Coordinates coordinates = entity.getCoordinates();
            // need to revert coordinates, because of array structure [Y][X]
            field[coordinates.y][coordinates.x] = " " + entity.render() + " ";
        }
    }

    private void printResult(String[][] field) {
        printHeader();
        print(field);
    }

    private void printHeader() {
        turnCount++;
        System.out.println();
        System.out.printf("Turn #%s\n", turnCount);
        System.out.println("_________________________________");
    }

    private void print(String[][] field) {
        for (int row = 0; row < rows; row++) {
            System.out.print("| ");
            for (int col = 0; col < this.cols; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println("|");
        }
    }
}
