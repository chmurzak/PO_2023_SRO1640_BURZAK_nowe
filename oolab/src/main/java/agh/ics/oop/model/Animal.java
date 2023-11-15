package agh.ics.oop.model;

import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;

public class Animal {
    private Vector2d position;
    private MapDirection orientation;

    public Vector2d getPosition() {
        return position;
    }
    public MapDirection getOrientation() {
        return orientation;
    }

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(Vector2d position) {
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return String.format("Orientacja zwierzaka: %s\nPozycja zwierzaka: %s", orientation, position);
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d newPositionF = this.position.add(this.orientation.toUnitVector());
                if(0<=newPositionF.getX() && newPositionF.getX()<=4 && 0<=newPositionF.getY() && newPositionF.getY()<=4){
                    this.position = newPositionF;
                }
            }
            case BACKWARD -> {
                Vector2d newPositionB = this.position.subtract(this.orientation.toUnitVector());
                if(0<=newPositionB.getX() && newPositionB.getX()<=4 && 0<=newPositionB.getY() && newPositionB.getY()<=4){
                    System.out.println(newPositionB);
                    this.position = newPositionB;
                }
            }
        }
    }
}