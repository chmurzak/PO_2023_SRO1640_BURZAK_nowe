package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Set<Vector2d> occupiedPositions = new HashSet<>();

    @Override
    public boolean place(Animal animal) {
        if (!occupiedPositions.contains(animal.getPosition())) {
            animals().add(animal);
            occupiedPositions.add(animal.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals().contains(animal)) {
            Vector2d oldPosition = animal.getPosition();
            MoveValidator validator = this;
            animal.move(direction, validator);
            Vector2d newPosition = animal.getPosition();

            if (!oldPosition.equals(newPosition) && canMoveTo(newPosition) && !isOccupied(newPosition)) {
                occupiedPositions.remove(oldPosition);
                occupiedPositions.add(newPosition);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return occupiedPositions.contains(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        for (Animal animal : animals()) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = getLowerLeft();
        Vector2d upperRight = getUpperRight();
        return visualizer.draw(lowerLeft, upperRight);
    }

    protected abstract List<Animal> animals();

    private Vector2d getLowerLeft() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Vector2d position : occupiedPositions) {
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
        }
        return new Vector2d(minX, minY);
    }

    private Vector2d getUpperRight() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (Vector2d position : occupiedPositions) {
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }
        return new Vector2d(maxX, maxY);
    }
}
