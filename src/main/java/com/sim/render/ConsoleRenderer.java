package com.sim.render;

import com.sim.core.Coordinates;
import com.sim.core.WorldMap;
import com.sim.entities.*;

import java.util.Set;

public class ConsoleRenderer implements Renderer {

    @Override
    public void render(WorldMap map) {
        int rows = map.getRows();
        int cols = map.getColumns();
        String[][] field = createEmptyField(rows, cols);
        setEntityLocation(map, field);
        printResult(field, rows, cols);
    }

    private String[][] createEmptyField(final int rows, final int cols) {
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
            BaseEntity entity = map.getEntityAt(cell);
            Coordinates coordinates = entity.getCoordinates();
            // need to revert coordinates, because of array structure [Y][X]
            field[coordinates.y][coordinates.x] = " " + printChar(entity) + " ";
        }
    }

    private String printChar(BaseEntity entity) {
        if (entity instanceof DeliveryMan) {
            return "M";
        }
        if (entity instanceof Dog) {
            return "D";
        }
        if (entity instanceof Coffee) {
            return "C";
        }
        if (entity instanceof Tree) {
            return "T";
        }
        throw new IllegalArgumentException("Entity character is not found");
    }

    private void printResult(String[][] field, int rows, int cols) {
        printHeader();
        printField(field, rows, cols);
    }

    private void printHeader() {
        System.out.println();
        System.out.println("Next turn");
        System.out.println("_________________________________");
    }

    private void printField(String[][] field, final int rows, final int cols) {
        for (int row = 0; row < rows; row++) {
            System.out.print("| ");
            for (int col = 0; col < cols; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println("|");
        }
    }
}
