package algoritmos;

import java.util.List;
import java.util.Stack;

import grafo.*;

public class DFS {
	private Grafo grafo;
	//private Grafo arbol;
	private boolean [] nodosVisitados;
	private int nodoInicio;
	
	public DFS (Grafo grafo, int nodoInicio) {
		this.grafo = grafo;
		this.nodosVisitados = new boolean[this.grafo.getNodos()]; 
		this.nodoInicio = nodoInicio;
		ejecutar();
	}

	
	private void ejecutar() {

		Stack<Integer> pila= new Stack<Integer>();
		pila.push(this.nodoInicio);
		this.nodosVisitados[nodoInicio] = true;
		while(!pila.isEmpty()) {
				int nodoActual = pila.pop();
				List<Integer> adyacentes= grafo.getNodosAdyacentes(nodoActual);
				
				for (Integer adyacente : adyacentes) {
					if(!this.nodosVisitados[adyacente]) {
						this.nodosVisitados[adyacente] =true;
						pila.add(adyacente);
					}
				}
		}
	}
	
	public boolean hayCamino(int nodoFin) {
		return this.nodosVisitados[nodoFin];
	}
	
	
}
