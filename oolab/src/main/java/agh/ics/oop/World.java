package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World{
    public static void main(String[] args){
        System.out.println("System wystartowal");
//        MoveDirection[] parsedArgs = OptionsParser.parse(args);
//        run(parsedArgs);
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        System.out.println(MapDirection.EAST);
//        System.out.println(MapDirection.EAST.next());
//        System.out.println(MapDirection.NORTH.previous());
//        System.out.println(MapDirection.NORTH.toUnitVector());
//        Animal animal1 = new Animal();
//        Animal animal2 = new Animal(new Vector2d(1,1));
//        System.out.println(animal1);
//        System.out.println(animal2);
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap worldMap = new RectangularMap(6, 6);
        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();
        System.out.println("System zakonczyl dzialanie");

    }

    public static void run(MoveDirection[] parsedArgs){
        for(MoveDirection moveDirection: parsedArgs){
            switch (moveDirection){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
        }
    }
}
