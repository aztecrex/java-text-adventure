package codecraft.adventure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gwiley on 6/29/16.
 */
public final class Room {

    private final Map<Door,Room> passages = new HashMap<>();

    private final List<Item> items = new ArrayList<>();

    void connect(Door via, Room to) {
        this.passages.put(via,to);
        to.passages.put(via.back(),this);
    }

    void add(Item item) {
        items.add(item);
    }


    public void look() {
        System.out.println("You are in a room.");
        System.out.println("You see doors to the " + String.join(", ",passages.keySet().stream().map(Object::toString).collect(Collectors.toList())));
        System.out.println("You see " + String.join(", ",items.stream().map(Object::toString).collect(Collectors.toList())));
    }

    public Room move(String direction) {
        Door door = Door.valueOf(direction);

        if (passages.containsKey(door)) {
            System.out.println("You pass through the " + door + " door.");
            return passages.get(door);
        } else {
            System.out.println("Ouch!");
            return this;
        }
    }


}
