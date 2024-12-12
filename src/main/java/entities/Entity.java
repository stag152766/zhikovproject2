package entities;

import core.Coordinates;
import core.CoordinatesShift;
import core.SimMap;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public abstract class Entity {
    protected Coordinates coordinates;

    // поиск пути
    public void makeMove(Coordinates next) {
        // do nothing by default
    }

    public abstract String render();

    // возвращает координаты для полей, доступных к перемещению
    // максимально опишем общую логику
    public Set<Coordinates> availableMoveCoordinates(SimMap map) {
        Set<Coordinates> availableCoordinates = new HashSet<>();
        Set<CoordinatesShift> shifts = getEntityMovesPattern();
        // проитерироваться по сдвигам
        // сделать проверку доступности
        for (CoordinatesShift shift : shifts) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.processShift(shift);
                if (isCoordinatesAvailableForMove(newCoordinates, map)) {
                    availableCoordinates.add(newCoordinates);
                }
            }
        }
        return availableCoordinates;
    }

    protected boolean isCoordinatesAvailableForMove(Coordinates coordinates,
                                                    SimMap map) {
        if (map.isEmptyCell(coordinates)) return true;
        Entity neigh = map.getEntity(coordinates);
        return isInteractionAvailable(neigh);
    }

    protected abstract boolean isInteractionAvailable(Entity neigh);

    // получить сдвиги для данной сущности
    protected abstract Set<CoordinatesShift> getEntityMovesPattern();
}
