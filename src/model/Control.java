package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import Read.ToJsonReader;

public class Control {


    private Graph<String> grafo;
    private GraphM<String> grafoM;


    public Control()throws Exception{
        grafo = new Graph<>();
        grafoM = new GraphM<>();
        
        /*
        grafo.addVertex("A",0);
        grafo.addVertex("B",1);
        grafo.addVertex("C",2);
        grafo.addVertex("D",3);

        grafo.addArista(0,2,3);
        grafo.addArista(0,1,7);
        grafo.addArista(2,3,8);
        grafo.addArista(2,1,2);
        grafo.addArista(1,3,2);
*/


    }

    public Graph<String> getGrafo() {
        return grafo;
    }

    public void setGrafo(Graph<String> grafo) {
        this.grafo = grafo;
    }

    public GraphM<String> getGrafoM() {
        return grafoM;
    }

    public void setGrafoM(GraphM<String> grafoM) {
        this.grafoM = grafoM;
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
            int F50 = grafoM.dijkstraNumD(0,3);
            int F51 = grafoM.dijkstraNumD(0, 2);
            if(F50>F51){
                return grafoM.dijkstraBase(0, 2);

            }else{
                return grafoM.dijkstraBase(0, 3);
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



    public String proveFinish(int graph, int v, int f){

        if(graph == 1){
            grafo.BFS(v);
            if(grafo.prove(v,f)){
                return "yes, you can finish the game";
            }else{
                return "No, you need to restart from a check point";
            }
        }else{
            grafoM.BFS(v);
            if(grafoM.prove(v,f)){
                return "yes, you can finish the game";
            }else{
                return "No, you need to restart from a check point";
            }
        }

    }
    public String proveFinish(int graph, int v, int f,int f2){

        if(graph == 1){
            grafo.BFS(v);
            if(grafo.prove(f,f2)){
                return "yes, you can finish the game";
            }else{
                return "No, you need to restart from a check point";
            }
        }else{
            grafoM.BFS(v);
            if(grafoM.prove(f,f2)){
                return "yes, you can finish the game";
            }else{
                return "No, you need to restart from a check point";
            }
        }

    }

    public String bosses(){
        return grafo.dijkstraBase(0, 2);
    }
    
    public void loadVertexDataBase() {
    	
    	//ArrayList<Vertex<String>> array = new ArrayList<Vertex<String>>();
    	
    	if(ToJsonReader.readV() != null) {
        	
    		for(int i = 0; i < ToJsonReader.readV().size(); i++) {
    			

    			
    			grafo.vertexes.put(ToJsonReader.readV().get(i).getKey(), ToJsonReader.readV().get(i));
    			
    			grafoM.addVertex(ToJsonReader.readV().get(i).getValue(), ToJsonReader.readV().get(i).getKey());

    		}
    		
    	} else {
    		
    		System.out.println("No hay nada en la base de datos.");
    		
    	}
    	
    	grafo.initialize();
    	
    	for(int j = 0; j <= ToJsonReader.readV().size(); j++) {
    		
    		if(grafo.vertexes.get(j) != null) {
    		
    			System.out.println(grafo.vertexes.get(j).getValue());
    			
    		}
    		
    	}
    	
    	
    }
    
    public void loadEdgeDataBase() throws Exception {
    	
    	if(ToJsonReader.readA() != null) {
        	
    		for(int i = 0; i < ToJsonReader.readA().size(); i++) {
    			
    			//if(grafo.vertexes.get(ToJsonReader.readA().get(i).getFrom()) != null) {
    			
    			//System.out.println(i);
    			//System.out.println("- " + ToJsonReader.readA().get(i).getFrom());
    			//System.out.println("--" + ToJsonReader.readA().get(i).getTo());
    			//System.out.println("---" + ToJsonReader.readA().get(i).getWeight());
    			   			    			
    			//grafo.addArista(ToJsonReader.readA().get(i).getFrom(), ToJsonReader.readA().get(i).getTo(), ToJsonReader.readA().get(i).getWeight());
    			grafo.addArista(ToJsonReader.readA().get(i).getFrom(), ToJsonReader.readA().get(i).getTo(), ToJsonReader.readA().get(i).getWeight());
    			grafoM.addEdge(ToJsonReader.readA().get(i).getFrom(), ToJsonReader.readA().get(i).getTo(), ToJsonReader.readA().get(i).getWeight());    			

    			//}
    		}
    		
    	} else {
    		
    		System.out.println("No hay nada en la base de datos.");
    		
    	} 	
    	
    	
    	for(int j = 0; j < grafo.vertexes.size(); j++) {
    		
    		if(grafo.vertexes.get(j) != null && grafo.vertexes.get(j).aristas != null) {
    			
    			for(int i = 0; i < grafo.vertexes.get(j).aristas.size(); i++) {
    		
    				System.out.println(grafo.vertexes.get(j).aristas.get(i).getWeight());
    				
    			}
    			
    		}
    		
    	}
    	
    	
    }

}

