package core;

import entities.Entity;

import java.util.Set;

public class MapConsoleRenderer {
    private final int ROWS = 10;
    private final int COLS = 10;
    private int turnCount = 0;


    public void render(SimMap map) {
        // init empty field
        String[][] field = new String[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                field[row][col] = ".. ";
            }
        }

        // fill entities
        // need to revert coordinates, because of array structure [Y][X]
        Set<Coordinates> occupiedCells = map.getOccupiedCells();
        for (Coordinates cell: occupiedCells) {
            Entity entity = map.getEntityAt(cell);
            Coordinates coordinates = entity.getCoordinates();
            field[coordinates.y][coordinates.x] = " " + entity.render() + " ";
        }

        // print result
        turnCount++;
        System.out.println();
        System.out.printf("Turn #%s\n", turnCount);
        System.out.println("_________________________________");
        for (int row = 0; row < ROWS; row++) {
            System.out.print("| ");
            for (int col = 0; col < this.COLS; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println("|");
        }
    }
}
