package model;

public class Control {


    private Graph<String> grafo;
    private GraphM<String> grafoM;


    public Control()throws Exception{
        grafo = new Graph<>();
        grafoM = new GraphM<>();
        grafo.addVertex("A",0);
        grafo.addVertex("B",1);
        grafo.addVertex("C",2);
        grafo.addVertex("D",3);

        grafo.addArista(0,2,3);
        grafo.addArista(0,1,7);
        grafo.addArista(2,3,8);
        grafo.addArista(2,1,2);
        grafo.addArista(1,3,2);



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

    public String bossesDe(int graph){
        if(graph == 1){
            int F50 = grafo.dijkstraNumD(0,3);
            int F51 = grafo.dijkstraNumD(0, 2);
            if(F50>F51){
                return grafo.dijkstraBase(0, 2);

            }else{
                return grafo.dijkstraBase(0, 3);
            }
        }else{
            int F50 = grafoM.dijkstraNumD(0,50);
            int F51 = grafoM.dijkstraNumD(0, 51);
            if(F50>F51){
                return grafoM.dijkstraBase(0, 51);

            }else{
                return grafoM.dijkstraBase(0, 50);
            }
        }
    
    }

    public String bossesF(int graph, int f){
        if(graph==1){
            return grafo.dijkstraBase(0, f);
        }else{
            return grafoM.dijkstraBase(0, f);
        }
    }

    public String bossesST(int graph, int s, int f){
        
        if(graph==1){
            return grafo.dijkstraBase(s, f);
        }else{
            return grafoM.dijkstraBase(s, f);
        }
    }

    public String proveFinish(int graph, int v){

        if(graph == 1){
            grafo.BFS(v);
            if(grafo.prove()){
                return "yes, you can finish the game";
            }else{
                return "No, you need to restart from a check point";
            }
        }else{
            grafoM.BFS(v);
            if(grafoM.prove()){
                return "yes, you can finish the game";
            }else{
                return "No, you need to restart from a check point";
            }
        }

    }

    public String bosses(){
        return grafo.dijkstraBase(0, 3);
    }

}

