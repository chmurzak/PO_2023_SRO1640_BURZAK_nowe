package agh.ics.oop;

//import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
//import agh.ics.oop.model.Vector2d;

public class World{
    public static void main(String[] args){
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        System.out.println(MapDirection.EAST);
//        System.out.println(MapDirection.EAST.next());
//        System.out.println(MapDirection.NORTH.previous());
//        System.out.println(MapDirection.NORTH.toUnitVector());

        System.out.println("System wystartowal");
        MoveDirection[] parsedArgs = OptionsParser.parse(args);
        run(parsedArgs);
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
