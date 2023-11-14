package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void animalHaveGoodOrientation() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();

        animal1.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.LEFT);

        assertEquals(MapDirection.EAST, animal1.getOrientation());
        assertEquals(MapDirection.WEST, animal2.getOrientation());
    }

    @Test
    void animalHaveGoodPosition() {
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(1,1));

        animal1.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.BACKWARD);

        assertEquals(new Vector2d(2,3), animal1.getPosition());
        assertEquals(new Vector2d(1,0), animal2.getPosition());
    }

    @Test
    void animalCantGetOutOfBounds(){
        Animal animal1 = new Animal(new Vector2d(0, 4));
        Animal animal2 = new Animal(new Vector2d(1,0));
        animal1.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.BACKWARD);

        assertEquals(new Vector2d(0,4), animal1.getPosition());
        assertEquals(new Vector2d(1,0), animal2.getPosition());
    }
}