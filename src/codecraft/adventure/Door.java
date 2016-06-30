package codecraft.adventure;

/**
 * Created by gwiley on 6/29/16.
 */
public enum Door {
    north, south, east, west;

    public Door back() {
        switch(this) {
            case east: return west;
            case west: return east;
            case north: return south;
            case south: return north;
        }
        throw new Error("unexpected missing case");
    }

}
