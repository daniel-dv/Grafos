package algoritmos;

import java.util.LinkedList;
import java.util.List;

import grafo.*;

public class BFS {
    private Grafo grafo;
    private int nodoInicio;
    private int [] distanciaNodos;
    private Grafo arbol;

    public BFS(Grafo grafo, int nodoInicio) {
        this.grafo = grafo;
        this.nodoInicio = nodoInicio;
        this.arbol = new GrafoLista (this.grafo.getNodos());
        this.distanciaNodos = new int[grafo.getNodos()];
        for (int i=0; i<grafo.getNodos(); i++)
        	this.distanciaNodos[i]= Integer.MAX_VALUE;
        this.distanciaNodos[nodoInicio] = 0;
        ejecutar();
    }

    private void ejecutar() {
        List<Integer> visited = new LinkedList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited.add(nodoInicio);
        queue.add(nodoInicio);
        int nodoActual;

        while (queue.size() != 0) {
            nodoActual = queue.poll();
            List<Integer> adyacentes = grafo.getNodosAdyacentes(nodoActual);
	            for (Integer adyacente : adyacentes) {
	            	if (this.distanciaNodos[adyacente]==Integer.MAX_VALUE) {
	            		this.distanciaNodos[adyacente] = this.distanciaNodos[nodoInicio]+1;
	            		queue.add(adyacente);
	            		arbol.setArista(nodoActual, adyacente, 1, true);
	            	}
	            }
        }
    }
    
    public boolean hayCamino(int nodoFin) {
    	return this.distanciaNodos[nodoFin]!=Integer.MAX_VALUE;
    }
    
    public int[] getDistancias () {
    	return this.distanciaNodos;
    }
    
    public int getDistancia(int nodoFin) {
    	return this.distanciaNodos[nodoFin];
    }
    
    public Grafo getArbol() {
    	return this.arbol;
    }
}
