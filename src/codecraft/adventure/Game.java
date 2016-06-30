package codecraft.adventure;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gwiley on 6/29/16.
 */
public class Game {

    private static final Scanner in = new Scanner(System.in);

    // TODO create an immutable data structure that is current state and turn this inside out.
    Room room = new Room(Arrays.asList(Door.east,Door.south));






    private boolean turn() {
        final String input = in.nextLine();
        if (input.equals("quit"))
            return false;

        final String[] command = input.split(" +");
        if (command[0].equals("look"))
            room.look();
        else if (command[0].equals("move"))
            room = room.move(command[1]);
        else {
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
