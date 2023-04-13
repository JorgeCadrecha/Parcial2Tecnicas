package Battleship;

import java.util.ArrayList;

public class User {

    private boolean alive;

    private ArrayList<Ship> ships;

    public User(boolean alive, ArrayList<Ship> ships) {
        this.alive = alive;
        this.ships = ships;
    }

    public User(ArrayList<Ship> ships) throws Exception {
        if(ships == null || ships.isEmpty()) {
            throw new Exception("El usuario debe tener al menos un barco");
        }
        this.ships = ships;
        this.alive = true;
    }

    public  ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isAlive() {
        return alive;
    }

    public void die() {
        setAlive(false);
    }

    public boolean attack(){return false;}

    public void getShot(){}
}
