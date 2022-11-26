package Test;

import junit.framework.TestCase;
import model.Control;

public class TestProblema extends TestCase {

    private Control control;

    public void setUpStage1() throws Exception {
        control = new Control();
    }

    public void testBossesList() throws Exception {
        setUpStage1();
        control.getGrafo().addVertex("A",0);
        control.getGrafo().addVertex("B",1);
        control.getGrafo().addVertex("C",2);
        control.getGrafo().addVertex("D",3);

        control.getGrafo().addArista(0,2,3);
        control.getGrafo().addArista(0,1,7);
        control.getGrafo().addArista(2,3,8);
        control.getGrafo().addArista(2,1,2);
        control.getGrafo().addArista(1,3,2);

        //Camino default, desde el inicio 0 hasta uno de los 2 finales asumiendo c y d como los finales
        assertEquals(control.bossesDeT(1), "Way: { A, C} Difficulty :3");

        assertEquals(control.bossesF(1,3),"Way: { A, C, B, D} Difficulty :7" );

        assertEquals(control.bossesST(1,2,3), "Way: { C, B, D} Difficulty :4");
    }
    public void testBossesMatrix() throws Exception {
        setUpStage1();
        control.getGrafoM().addVertex("A",0);
        control.getGrafoM().addVertex("B",1);
        control.getGrafoM().addVertex("C",2);
        control.getGrafoM().addVertex("D",3);

        control.getGrafoM().addEdge(0,2,3);
        control.getGrafoM().addEdge(0,1,7);
        control.getGrafoM().addEdge(2,3,8);
        control.getGrafoM().addEdge(2,1,2);
        control.getGrafoM().addEdge(1,3,2);

        //Camino default, desde el inicio 0 hasta uno de los 2 finales asumiendo c y d como los finales
        assertEquals(control.bossesDeT(2), "Way : { A, C} Difficulty : 3");

        assertEquals(control.bossesF(2,3),"Way : { A, C, B, D} Difficulty : 7" );

        assertEquals(control.bossesST(2,2,3), "Way : { C, B, D} Difficulty : 4");
    }

    public void testFinishGameList() throws Exception {
        setUpStage1();
        control.getGrafo().addVertex("A",0);
        control.getGrafo().addVertex("B",1);
        control.getGrafo().addVertex("C",2);
        control.getGrafo().addVertex("D",3);

        control.getGrafo().addArista(0,2,3);
        control.getGrafo().addArista(0,1,7);
        control.getGrafo().addArista(2,3,8);
        control.getGrafo().addArista(2,1,2);
        control.getGrafo().addArista(1,3,2);

        assertEquals(control.proveFinish(1,0,2,3),"yes, you can finish the game" );
        assertEquals(control.proveFinish(1,1,2,3),"yes, you can finish the game" );
        assertEquals(control.proveFinish(1,3, 0,1),"No, you need to restart from a check point" );
    }
    public void testFinishGameMatrix() throws Exception {
        setUpStage1();
        control.getGrafoM().addVertex("A",0);
        control.getGrafoM().addVertex("B",1);
        control.getGrafoM().addVertex("C",2);
        control.getGrafoM().addVertex("D",3);

        control.getGrafoM().addEdge(0,2,3);
        control.getGrafoM().addEdge(0,1,7);
        control.getGrafoM().addEdge(2,3,8);
        control.getGrafoM().addEdge(2,1,2);
        control.getGrafoM().addEdge(1,3,2);

        assertEquals(control.proveFinish(2,0,2,3),"yes, you can finish the game" );
        assertEquals(control.proveFinish(2,1,2,3),"yes, you can finish the game" );
        assertEquals(control.proveFinish(2,3, 0,1),"No, you need to restart from a check point" );
    }

}
