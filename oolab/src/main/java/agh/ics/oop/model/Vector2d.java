package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {

        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {

        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {

        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(Vector2d other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;
        return new Vector2d(newX, newY);
    }

    public Vector2d substract(Vector2d other) {
        int newX = this.x - other.x;
        int newY = this.y - other.y;
        return new Vector2d(newX, newY);
    }

    public Vector2d upperRight(Vector2d other) {
        int upperX = Math.max(this.x, other.x);
        int upperY = Math.max(this.y, other.y);
        return new Vector2d(upperX, upperY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int lowerX = Math.min(this.x, other.x);
        int lowerY = Math.min(this.y, other.y);
        return new Vector2d(lowerX, lowerY);
    }

    public Vector2d opposite() {
        int oppositeX = -this.x;
        int oppositeY = -this.y;
        return new Vector2d(oppositeX, oppositeY);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Vector2d vector2d = (Vector2d) other;
        return x == vector2d.x && y == vector2d.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}

