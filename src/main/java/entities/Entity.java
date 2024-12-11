package entities;

import core.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity {
    protected Coordinates coordinates;
    // поиск пути
    public void makeMove() {
     // do nothing by default
    }

    public abstract String render();
}
