package core;

import entities.Entity;

import java.util.Set;

public class MapConsoleRenderer {
    private final int ROWS = 10;
    private final int COLS = 10;
    private int turnCount = 0;

    public void render(WorldMap map) {
        String[][] field = createEmptyField();
        setEntityLocation(map, field);
        printResult(field);
    }

    private String[][] createEmptyField() {
        String[][] field = new String[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
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
        for (int row = 0; row < ROWS; row++) {
            System.out.print("| ");
            for (int col = 0; col < this.COLS; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println("|");
        }
    }
}
