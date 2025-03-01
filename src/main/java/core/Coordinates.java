package core;

import java.util.Objects;

public class Coordinates {
    public final int x;
    public final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canShift(CoordinatesShift shift) {
        Coordinates next = this.processShift(shift);
        return next.x >= 0 && next.x <= 9 && next.y >= 0 && next.y <= 9;
    }

    // расчет сдвига
    public Coordinates processShift(CoordinatesShift shift) {
        int newX = this.x + shift.xShift;
        int newY = this.y + shift.yShift;
        return new Coordinates(newX, newY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
