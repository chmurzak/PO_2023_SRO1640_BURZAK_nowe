package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void simmulationCorrectlyInterpretsImput(){
        List<Vector2d> positions = Arrays.asList(new Vector2d(2, 2), new Vector2d(1, 1));
        List<MoveDirection> moves = Arrays.asList(MoveDirection.LEFT,MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.BACKWARD);

        WorldMap map = new RectangularMap(6, 6);
        Simulation simulation = new Simulation(positions, moves, map);

        simulation.run();


    }
}