package ui;
import model.Control;

import java.util.Scanner;

public class Main {
    private Control control;
    private Scanner sc;

    public Main() throws Exception {
        control = new Control();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        Main ppal = new Main();
        ppal.prueba();
        int option = -1;
        int graph = 0;
        do {
            graph = ppal.selecGraph();
            option = ppal.showMenu();
            ppal.operation(option, graph);
        } while (option != 0);
    }

    public int showMenu() {
        System.out.println("Menu: \n" +
                "(1) Import graph \n" +
                "(2) Show the the order of bosses for pass the game in the less difficulty \n" +
                "(3) Prove that you can finish the game");

        int option = sc.nextInt();
        return option;
    }

    public int selecGraph() {
        System.out.println("Select the type of graph implementation for solve the problem: \n " +
                "(1) Adjacency list \n" +
                "(2) Adjacency matrix");
        int option = sc.nextInt();
        return option;
    }

    public void operation(int option, int graph) {
        switch (option) {

            case 1:
                System.out.println("no se");
                break;
            case 2:
                control.bosses(graph);
                break;
            default:
                System.out.println("Invalid input");

        }
    }

    public void prueba(){
        System.out.println(control.bosses(0));
    }
}





