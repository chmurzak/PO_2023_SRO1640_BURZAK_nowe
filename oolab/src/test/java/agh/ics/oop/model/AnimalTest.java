package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    MoveValidator moveValidator = new MoveValidator() {
        @Override
        public boolean canMoveTo(Vector2d position) {
            return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(5, 5));
        }
    };

    @Test
    void animalHaveGoodOrientation() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();

        animal1.move(MoveDirection.RIGHT, moveValidator);
        animal2.move(MoveDirection.LEFT, moveValidator);

        assertEquals(MapDirection.EAST, animal1.getOrientation());
        assertEquals(MapDirection.WEST, animal2.getOrientation());
    }

    @Test
    void animalHaveGoodPosition() {
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(1,1));

        animal1.move(MoveDirection.FORWARD, moveValidator);
        animal2.move(MoveDirection.BACKWARD, moveValidator);

        assertEquals(new Vector2d(2,3), animal1.getPosition());
        assertEquals(new Vector2d(1,0), animal2.getPosition());
    }

    @Test
    void animalCantGetOutOfBounds(){
        int height = 6;
        Animal animal1 = new Animal(new Vector2d(0, height -1));
        Animal animal2 = new Animal(new Vector2d(1,0));

        animal1.move(MoveDirection.FORWARD, moveValidator);
        animal2.move(MoveDirection.BACKWARD, moveValidator);

        assertEquals(new Vector2d(0,height -1), animal1.getPosition());
        assertEquals(new Vector2d(1,0), animal2.getPosition());
    }
}