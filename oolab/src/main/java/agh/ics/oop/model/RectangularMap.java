package agh.ics.oop.model;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    private final int width;
    private final int height;
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(width - 1, height - 1));
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()) && !isOccupied(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsKey(animal.getPosition())) {
            Vector2d oldPosition = animal.getPosition();
            MoveValidator validator = this;
            animal.move(direction, validator); 
            Vector2d newPosition = animal.getPosition();

            if (!oldPosition.equals(newPosition) && canMoveTo(newPosition) && !isOccupied(newPosition)) {
                animals.remove(oldPosition);
                animals.put(newPosition, animal);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(width - 1, height - 1);
        return visualizer.draw(lowerLeft, upperRight);
    }
}
