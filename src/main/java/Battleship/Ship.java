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

    public boolean isAlreadyHit(Point point) {
        int x = point.get_x();
        int y = point.get_y();
        if (direction == CardinalPoints.NORTH) {
            return x == start.get_x() && y >= start.get_y() && y <= end.get_y();
        } else if (direction == CardinalPoints.SOUTH) {
            return x == start.get_x() && y >= end.get_y() && y <= start.get_y();
        } else if (direction == CardinalPoints.EAST) {
            return y == start.get_y() && x >= start.get_x() && x <= end.get_x();
        } else {
            // WEST
            return y == start.get_y() && x >= end.get_x() && x <= start.get_x();
        }
    }
    public boolean getShot(Point shotPoint) {
        if (isSunk) {
            return false;
        }
        if (isAlreadyHit(shotPoint)) {
            hits++;
            if (hits == size) {
                isSunk = true;
            }
            return true;
        }
        return false;
    }
}
