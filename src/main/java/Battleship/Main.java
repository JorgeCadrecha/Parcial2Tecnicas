package Battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Intento de Main

        //JUGADOR 1
        List<Ship> player1Ships = new ArrayList<>();
        /**¡Arreglar que solo ataca a la posición (3,4) y cambiar las posiciones por las que quiera el usuario cuando se vaya a entregar!**/
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

        boolean player1Turn = true;
        Scanner scanner = new Scanner(System.in);

        while (player1.isAlive() && player2.isAlive()) {
            User attacker = player1Turn ? player1 : player2;
            User defender = player1Turn ? player2 : player1;
            System.out.println("Es el turno del jugador " + (player1Turn ? "1" : "2"));

            System.out.print("Ingrese la coordenada x del ataque: ");
            int x = scanner.nextInt();

            System.out.print("Ingrese la coordenada y del ataque: ");
            int y = scanner.nextInt();

            Point attackPoint = new Point(x, y);
            boolean hit = defender.attack(attackPoint, attacker);

            if (hit) {
                System.out.println("¡Ataque exitoso!");
            } else {
                System.out.println("¡Ataque fallido!");
            }

            player1Turn = !player1Turn;
        }

        if (!player1.isAlive()) {
            System.out.println("¡El jugador 2 ha ganado!");
        } else if (!player2.isAlive()) {
            System.out.println("¡El jugador 1 ha ganado!");
        } else {
            System.out.println("¡Ambos jugadores se han rendido!");
        }
    }
}