package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args){
        List<MoveDirection> directionsList = new ArrayList<>();
        for(String arg: args){
            MoveDirection mdArg = switch (arg){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> null;
            };
            if(mdArg != null){
                directionsList.add(mdArg);
            }
        }
        return directionsList;
    }
}
