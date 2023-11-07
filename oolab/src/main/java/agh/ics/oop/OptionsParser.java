package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] tab =new MoveDirection[args.length];
        int index = 0;
        for(String arg: args){
            MoveDirection mdArg = switch (arg){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> null;
            };
            if(mdArg != null){
                tab[index] = mdArg;
                index++;
            }
        }
        MoveDirection[] result = new MoveDirection[index];
        System.arraycopy(tab, 0, result, 0, index);
        return result;
    }
}
