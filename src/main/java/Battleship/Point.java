package Battleship;

public class Point {

    private int x;
    private int y;
    private boolean hit;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.hit = false;
    }

    public void hit() {
        this.hit = true;
    }

    public boolean is_hit() {
        return this.hit;
    }

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }
}
