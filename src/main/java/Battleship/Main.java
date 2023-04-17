package Battleship;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Intento de Main

        //JUGADOR 1
        List<Ship> player1Ships = new ArrayList<>();
        player1Ships.add(new Frigate(new Point(3, 4), new Point(5, 4)));
        player1Ships.add(new Battleship(new Point(6, 3),new Point(6, 7)));
        player1Ships.add(new Canoe(new Point(1,1),new Point(1,3)));
        User player1 = new User((ArrayList<Ship>) player1Ships);

        //JUGADOR 2
        List<Ship> player2Ships = new ArrayList<>();
        player2Ships.add(new Frigate(new Point(3, 4), new Point(5, 4)));
        player2Ships.add(new Battleship(new Point(6, 3),new Point(6, 7)));
        player2Ships.add(new Canoe(new Point(1,1),new Point(1,3)));
        User player2 = new User((ArrayList<Ship>) player2Ships);

        Map();

        boolean player1Turn = true;
        Scanner scanner = new Scanner(System.in);

        while (player1.isAlive() && player2.isAlive()) {

            User attacker = player1Turn ? player1 : player2;
            User defender = player1Turn ? player2 : player1;

            System.out.println("\nEs el turno del jugador " + (player1Turn ? "1" : "2"));

            int x = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Ingrese la coordenada x del ataque: ");
                    x = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número entero.");
                    scanner.next();
                }
            }

            int y = 0;
            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Ingrese la coordenada y del ataque: ");
                    y = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número entero.");
                    scanner.next();
                }
            }

            Point attackPoint = new Point(x, y);
            boolean hit = defender.attack(attackPoint, attacker);

            if (hit) {
                System.out.println("¡Ataque exitoso!");
            } else {
                System.out.println("¡Ataque fallido!");
            }

            player1Turn = !player1Turn;
        }

    }

    public static void Map(){
        /** Intento de HashMap**/
        HashBarcos barcos = new HashBarcos();
        //Jugador 1
        barcos.cargarBarco(1,"Fragata","Fragata");
        barcos.cargarBarco(2,"BattleShip","BattleShip");
        barcos.cargarBarco(3,"Canoa","Canoa");

        //Jugador 2
        barcos.cargarBarco(4,"Fragata","Fragata");
        barcos.cargarBarco(5,"BattleShip","BattleShip");
        barcos.cargarBarco(6,"Canoa","Canoa");
    }
}
