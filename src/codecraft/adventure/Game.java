package codecraft.adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by gwiley on 6/29/16.
 */
public class Game {

    private static final Scanner in = new Scanner(System.in);

    private static Room center = new Room() ;

   private static final Room tl = new Room();
    private static final  Room br = new Room();
    private static final    Room bl = new Room();
    private static final   Room tr = new Room();
    private static final   Room left = new Room();
    private static final    Room right = new Room();
    private static final    Room bottom = new Room();
    private static final    Room top = new Room();
    static {

        center.connect(Door.north,top);
        center.connect(Door.south,bottom);
        center.connect(Door.east,right);
        center.connect(Door.west,left);
        tl.connect(Door.east,top);
        top.connect(Door.east,tr);
        tr.connect(Door.south,right);
        right.connect(Door.south,br);
        br.connect(Door.west,bottom);
        bottom.connect(Door.west,bl);
        bl.connect(Door.north,left);
        left.connect(Door.north,tl);

        center.add(Item.sword);
        left.add(Item.pirhanna);
        tr.add(Item.gold);
        top.add(Item.hat);
        top.add(Item.ruby);
    }


    // TODO create an immutable data structure that is current state and turn this inside out.
    Room room = center;

    private List<Item> inventory = new ArrayList<>();
    {
        inventory.add(Item.hamster);
    }




    private boolean turn() {
        final String input = in.nextLine();
        if (input.equals("quit"))
            return false;

        final String[] command = input.split(" +");
        if (command[0].equals("look"))
            room.look();
        else if (command[0].equals("move"))
            room = room.move(command[1]);
        else if (command[0].equals("inventory")) {
            System.out.println("You are holding " + String.join(", ", inventory.stream().map(Object::toString).collect(Collectors.toList())));
        } else {
            System.out.println("Huh?");
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hi.");
        final Game game = new Game();
        while (game.turn());
        System.out.println("Bye.");
    }

}
