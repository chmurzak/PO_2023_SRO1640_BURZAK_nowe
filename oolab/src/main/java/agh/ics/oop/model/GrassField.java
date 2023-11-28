package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Grass> grassList = new ArrayList<>();
    private final Random random = new Random();

    public GrassField(int numberOfGrassFields) {
        for (int i = 0; i < numberOfGrassFields; i++) {
            placeGrassRandomly();
        }
    }

    private void placeGrassRandomly() {
        int x, y;
        do {
            x = random.nextInt((int) Math.sqrt(grassList.size() * 10));
            y = random.nextInt((int) Math.sqrt(grassList.size() * 10));
        } while (isOccupied(new Vector2d(x, y)));

        Grass grass = new Grass(new Vector2d(x, y));
        grassList.add(grass);
    }

    @Override
    protected List<Animal> animals() {
        return animals;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return true;
    }
}
