package entities;

import core.Coordinates;
import core.CoordinatesShift;
import core.SimMap;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * максимально опишем общую логику
 */
@Getter
@Setter
public abstract class Entity {
    protected Coordinates coordinates;

    public Coordinates makeMove(SimMap map) {
        if (this.canMove()) {
            Set<Coordinates> availableMoves = availableMoveCoordinates(map);
            // случайный выбор следующего хода
            Coordinates next = new ArrayList<>(availableMoves).get(0);
            this.setCoordinates(next);
            // мапу обновляем в экшене - сущность не управляет доской
            System.out.printf("%s moved to %s\n", this.render(), next);
            return next;
        } else {
            return this.coordinates;
        }
    }

    public abstract String render();

    /**
     * возвращает координаты для полей, доступных к перемещению
     */
    public Set<Coordinates> availableMoveCoordinates(SimMap map) {
        Set<Coordinates> availableCoordinates = new HashSet<>();
        Set<CoordinatesShift> shifts = getEntityMovesPattern();
        // итерироваться по сдвигам
        // сделать проверку доступности
        for (CoordinatesShift shift : shifts) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.processShift(shift);
                if (isCoordinatesAvailableForMove(newCoordinates, map)) {
                    availableCoordinates.add(newCoordinates);
                }
            }
        }
        // System.out.printf("Available moves for %s: %s\n", map.getEntityAt(coordinates).render(), availableCoordinates);
        return availableCoordinates;
    }

    protected boolean isCoordinatesAvailableForMove(Coordinates coordinates,
                                                    SimMap map) {
        if (map.isEmptyCell(coordinates)) {
            return true;
        }
        Entity neigh = map.getEntityAt(coordinates);
        return isInteractionAvailable(neigh);
    }

    /**
     * Interaction with neigboor entiry (eat, hit)
     */
    protected abstract boolean isInteractionAvailable(Entity neigh);

    // получить сдвиги для данной сущности
    protected abstract Set<CoordinatesShift> getEntityMovesPattern();

    public boolean canMove() {
        return false;
    }
}
