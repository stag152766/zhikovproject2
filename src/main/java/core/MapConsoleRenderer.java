package core;

import entities.Entity;

import java.util.Map;

public class MapConsoleRenderer {
    public static final int ROWS = 10;
    public static final int COLS = 10;
    private int turnCount = 0;

    public void render(Map<Coordinates, Entity> map) {
        // init empty field
        String[][] field = new String[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int cols = 0; cols < COLS; cols++) {
                field[row][cols] = ".. ";
            }
        }


        // fill entities
        map.forEach((c, e) -> {
            field[c.x][c.y] = " " + e.render() + " ";
        });

        // print result
        turnCount++;
        System.out.println();
        System.out.printf("Turn #%s\n", turnCount);
        System.out.println("_________________________________");
        for (int row = 0; row < ROWS; row++) {
            System.out.print("| ");
            for (int cols = 0; cols < COLS; cols++) {
                System.out.print(field[row][cols]);
            }
            System.out.println("|");
        }
    }
}
