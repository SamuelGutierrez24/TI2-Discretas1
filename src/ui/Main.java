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
        System.out.println("Select the graph to import(First the graph vertexes txt and then the graph edges txt).");
        ppal.importar();
        int option = -1;
        int graph = 0;
        do {
            option = ppal.showMenu();
            ppal.operation(option);
        } while (option != 0);
    }

    public int showMenu() {
        System.out.println("Menu: \n" +
                "(1) Exit \n" +
                "(2) Show the the order of bosses for pass the game in the less difficulty \n" +
                "(3) Prove that you can finish the game");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public int selecGraph(){
    	
    	
        System.out.println("Select the type of graph implementation for solve the problem: \n " +
                "(1) Adjacency list \n" +
                "(2) Adjacency matrix");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void operation(int option) throws Exception {
        switch (option) {

            case 1:
            	
            	System.exit(0);
                break;
            case 2:
            	int graph = selecGraph();           
                dijks(graph);
                break;
            case 3:
            	graph = selecGraph();
            	System.out.println("Input the key of the boss you are:");
            	int boss =  sc.nextInt();
            	sc.nextLine();
            	System.out.println(control.proveFinish(graph,boss,50,51));
                break;
            default:
                System.out.println("Invalid input");

        }
    }

    public void dijks(int graph){

        System.out.println("Select a case : \n" +
        "(1) Default (From firts level boss to the less difficulty final) \n" +
        "(2) Select one of the finals and show the order for less difficulty \n " +
        "(3) Show the route with less difficulty of bosses from 2 vetex of your select\n");
        int i = sc.nextInt();
        sc.nextLine();

        switch(i){
            case 1:
            System.out.println(control.bossesDe(graph));
            break;
            case 2:
            System.out.println("Select a final : \n (1) Final 1 (vertex 50) \n (2) Final 2 (vertex 51) ");
            int finall = sc.nextInt();
            sc.nextLine();
            if(finall == 1){
                finall = 50;
            }else{
                finall = 51;
            }
            System.out.println(control.bossesF(graph, finall));
            break;
            case 3:
            System.out.println("Remember your final boss key can not be upper than your start boss key");
            System.out.println("Input the key of the boss from where you start your route:");
            int start = sc.nextInt();
            sc.nextLine();
            System.out.println("Input the key of the boss where you finish the route:");
            int to = sc.nextInt();
            sc.nextLine();
            System.out.println(control.bossesST(graph, start, to));
        }


    }

    public void importar() throws Exception{
    	
    	control.loadVertexDataBase();
    	control.loadEdgeDataBase();
        
    }

}





