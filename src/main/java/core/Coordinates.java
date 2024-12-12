package core;

import java.util.Objects;

public class Coordinates {
    public final int x;
    public final int y;

    // расчет сдвига
    public Coordinates processShift(CoordinatesShift shift) {
        return new Coordinates(this.x + shift.xShift, this.y + shift.yShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        Coordinates next = this.processShift(shift);
        return next.x >= 0 && next.x <= 9 && next.y >= 0 && next.y <= 9;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
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
}
