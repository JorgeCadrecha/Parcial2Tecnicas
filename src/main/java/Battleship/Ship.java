package Battleship;

public class Ship {
    private  int size;
    private  Point start;
    private  Point end;
    private  CardinalPoints direction;
    private int hits;
    private boolean isSunk;


    public Ship(Point start, Point end) throws Exception {
        if (start.get_x() != end.get_x() && start.get_y() != end.get_y()) {
            throw new Exception("Los puntos no están en línea recta");
        }
        int size;
        if (start.get_x() == end.get_x()) {
            size = Math.abs(start.get_y() - end.get_y()) + 1;
            direction = start.get_y() < end.get_y() ? CardinalPoints.SOUTH : CardinalPoints.NORTH;
        } else {
            size = Math.abs(start.get_x() - end.get_x()) + 1;
            direction = start.get_x() < end.get_x() ? CardinalPoints.EAST : CardinalPoints.WEST;
        }
        if (size > 5 || size < 1) {
            throw new Exception("El tamaño del barco no es valido");
        }
        this.size = size;
        this.start = start;
        this.end = end;
        this.hits = 0;
        this.isSunk = false;
    }

    public int getSize() {
        return size;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public int getHits() {
        return hits;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }
}
