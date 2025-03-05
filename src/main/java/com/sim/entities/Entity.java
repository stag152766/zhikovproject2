package com.sim.entities;

import com.sim.core.Coordinates;
import com.sim.core.WorldMap;

import java.util.Optional;

public interface Entity {
    Optional<Coordinates> makeMove(WorldMap map);
}
