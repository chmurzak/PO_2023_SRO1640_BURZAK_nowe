package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void vectorsAreEquals(){
        Vector2d vector1 = new Vector2d(2, 5);
        Vector2d vector2 = new Vector2d(2, 5);
        Vector2d vector3 = new Vector2d(3, 5);

        assertEquals(vector1, vector2);
        assertNotEquals(vector1, vector3);
    }

    @Test
    void vectorsCanBeAdded(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(1, 2);

        Vector2d vector3 = vector1.add(vector2);

        assertEquals(3, vector3.getX());
        assertEquals(5, vector3.getY());
    }

    @Test
    void vectorsCanBeSubstracted(){
        Vector2d vector1 = new Vector2d(3,4);
        Vector2d vector2 = new Vector2d(5,1);

        Vector2d vector3 = vector1.substract(vector2);

        assertEquals(-2,vector3.getX());
        assertEquals(3,vector3.getY());
    }

    @Test
    void vectorsAreOpposite(){
        Vector2d vector1 = new Vector2d(-1,2);

        Vector2d oppositeVector = vector1.opposite();

        assertEquals(1, oppositeVector.getX());
        assertEquals(-2, oppositeVector.getY());
    }

    @Test
    void vectorCanBePrinted(){
        Vector2d vector1 = new Vector2d(2,5);

        String printedVector = "(2,5)";

        assertEquals(printedVector, vector1.toString());
    }

    @Test
    void vectorPrecedes(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(1,2);

        assertTrue(vector2.precedes(vector1));
    }

    @Test
    void vectorFollows(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(1,2);

        assertTrue(vector1.follows(vector2));
    }

    @Test
    void vectorUpperRight(){
        Vector2d vector1 = new Vector2d(-2, 3);
        Vector2d vector2 = new Vector2d(-1, 2);

        Vector2d upperRightVector = vector1.upperRight(vector2);

        assertEquals(-1, upperRightVector.getX());
        assertEquals(3, upperRightVector.getY());
    }

    @Test
    void vectorLowerLeft(){
        Vector2d vector1 = new Vector2d(-2, 3);
        Vector2d vector2 = new Vector2d(-1, 2);

        Vector2d lowerLeftVector = vector1.lowerLeft(vector2);

        assertEquals(-2, lowerLeftVector.getX());
        assertEquals(2, lowerLeftVector.getY());
    }
}