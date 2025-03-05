package com.sim.entities;

import com.sim.core.Coordinates;
import com.sim.core.CoordinatesShift;
import com.sim.core.WorldMap;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Абстрактная сущность, в которой максимально опишем общую логику
 */
@Getter
@Setter
public abstract class BaseEntity implements Entity {
    protected Coordinates coordinates;

    @Override
    public Optional<Coordinates> makeMove(WorldMap map) {
        Set<Coordinates> availableMoves = availableMoveCoordinates(map);
        if (availableMoves.isEmpty()) {
            return Optional.empty();
        } else {
            // случайный выбор следующего хода
            Coordinates next = new ArrayList<>(availableMoves).get(0);
            setCoordinates(next);
            // мапу обновляем в экшене - сущность не управляет доской
            //System.out.printf("%s moved to %s\n", this.render(), next);
            return Optional.of(next);
        }
    }

    /**
     * возвращает координаты для полей, доступных к перемещению
     */
    private Set<Coordinates> availableMoveCoordinates(WorldMap map) {
        Set<Coordinates> availableCoordinates = new HashSet<>();
        Set<CoordinatesShift> shifts = getEntityMovesPattern();

        for (CoordinatesShift shift : shifts) {
            // TODO убрать двойной вызов processShift()
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.processShift(shift);
                if (isCoordinatesAvailableForMove(newCoordinates, map)) {
                    availableCoordinates.add(newCoordinates);
                }
            }
        }
        return availableCoordinates;
    }

    private boolean isCoordinatesAvailableForMove(Coordinates coordinates,
                                                    WorldMap map) {
        if (map.isEmptyCell(coordinates)) {
            return true;
        }
        BaseEntity neigh = map.getEntityAt(coordinates);
        return isInteractionAvailable(neigh);
    }

    /**
     * Interaction with neigboor entiry (eat, hit)
     */
    protected abstract boolean isInteractionAvailable(BaseEntity neigh);

    // получить сдвиги для данной сущности
    protected abstract Set<CoordinatesShift> getEntityMovesPattern();
}
