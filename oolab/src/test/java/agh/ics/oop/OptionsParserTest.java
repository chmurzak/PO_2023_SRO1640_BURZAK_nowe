package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void testParse(){
        String[] args = { "f", "b", "c", "r", "r", "l"};
        MoveDirection[] expectedDirections = {
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT
        };

        assertArrayEquals(expectedDirections, OptionsParser.parse(args));
    }
}