package codecraft.adventure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gwiley on 6/29/16.
 */
public final class Room {

    private final Map<Door,Room> passages;

    public Room(Collection<Door> doors) {
        final HashMap<Door,Room> passages = new HashMap<>();
        doors.forEach(d -> passages.put(d,this));
        this.passages = Collections.unmodifiableMap(passages);
    }


    public void look() {
        System.out.println("You are in a room.");
        System.out.println("You see doors to the " + String.join(", ",passages.keySet().stream().map(Object::toString).collect(Collectors.toList())));
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
