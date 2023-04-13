package Battleship;

public class Canoe extends Ship{
    private int size;
    private int hits;

    public Canoe(Point start, Point end) throws Exception {
        super(start, end);
        this.size = 2;
        this.hits = 0;
    }

    public int get_size() {
        return this.size;
    }

    public int get_hits() {
        return this.hits;
    }

    public void hit() {
        this.hits++;
    }

    public boolean is_sunk() {
        return this.hits == this.size;
    }
}