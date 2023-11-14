package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Animal> animals;
    private List<MoveDirection> moves;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves){
        this.animals = new ArrayList<>();
        this.moves = moves;
        int numberOfAnimals = positions.size();

        for(int index = 0; index < numberOfAnimals; index++){
            Vector2d position = positions.get(index);
            Animal animal = new Animal(position);
            animals.add(animal);
        }
    }

    public void run(){
        int numberOfMoves = moves.size();
        int numberOfAnimals = animals.size();
        for(int index = 0; index < numberOfMoves; index++){
            MoveDirection currentMove = moves.get(index);
            Animal currentAnimal = animals.get(index % numberOfAnimals);
            currentAnimal.move(currentMove);
            String animalOut = String.format("Zwierzę %d: %s", index % numberOfAnimals, currentAnimal.getPosition());
            System.out.println(animalOut);
        }
    }
}
