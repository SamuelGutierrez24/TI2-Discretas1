package model;

public class Control {


    private Graph<String> grafo;
    //private Graph<String> grafoL;


    public Control()throws Exception{
        grafo = new Graph<>();
        grafo.addVertex("A",0);
        grafo.addVertex("B",2);
        grafo.addVertex("C",3);
        grafo.addVertex("D",4);

        grafo.addArista(0,3,3);
        grafo.addArista(0,2,7);
        grafo.addArista(3,4,8);
        grafo.addArista(3,2,2);
        grafo.addArista(2,4,2);



    }

    public void addVertex(String value, int key)throws Exception{
        grafo.addVertex(value,key);
    }

    /*public void addE(int keyVertex, int keyAdj,int value){
        grafo.addEdge(keyVertex,keyAdj,value);
    }*/

    public String proveConex(){
        String out = "";
        int count = grafo.proveConex();
        int real = grafo.getHashSize();
        if(count == real){
            out = "Is strongly conex";
        }else {
            out= "Is not strongly conex";
        }
        return out;

    }

    public String bosses(int graph){
        return grafo.Dijkstra(0);

    }

}

