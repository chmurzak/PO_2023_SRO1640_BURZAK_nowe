package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final WorldMap map;
    private final List<MoveDirection> moves;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap map) {
        this.animals = new ArrayList<>();
        this.map = map;
        this.moves = moves;
        createAnimals(positions);
    }

    private void createAnimals(List<Vector2d> positions) {
        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            animals.add(animal);
            map.place(animal);
        }
    }

    public void run() {
        int numberOfMoves = moves.size();
        int numberOfAnimals = animals.size();
        for (int index = 0; index < numberOfMoves; index++) {
            MoveDirection currentMove = moves.get(index);
            int animalIndex = index % numberOfAnimals;
            Animal currentAnimal = animals.get(animalIndex);
            map.move(currentAnimal, currentMove);
            System.out.println(map);
        }
    }
}
