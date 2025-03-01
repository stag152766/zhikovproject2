package com.sim.entities;

import com.sim.core.Coordinates;
import com.sim.core.WorldMap;

public interface Entity {
    Coordinates act(WorldMap map);
}
