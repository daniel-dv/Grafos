package algoritmos;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grafo.*;

public class Prim {
	private Grafo grafo;
	private Set<Integer> conjuntoG;
	private Set<Integer> conjuntoMST;
	private GrafoLista grafoResultado;
	private double costoMinimo;
	
	
	public Prim (Grafo grafo) {
		this.grafo =grafo;
		this.conjuntoG = new HashSet <Integer>();
		this.conjuntoMST = new HashSet <Integer>();
		this.grafoResultado = new GrafoLista (grafo.getNodos());
		this.costoMinimo = 0;
		calcularPrim();
	}


	private void calcularPrim() {
		List<Integer> adyacentes;
		int nodoSalidaMin = 0;
		
		for (int i=0; i<this.grafo.getNodos(); i++) {
			conjuntoG.add(i);
		}
		
		while(!conjuntoG.isEmpty()) {
			conjuntoG.remove(nodoSalidaMin);
			conjuntoMST.add(nodoSalidaMin);
			double min = Double.MAX_VALUE;
			int nodoLlegadaMin = 0;
			
			for(Integer nodoMST : conjuntoMST) {
				
				adyacentes=grafo.getNodosAdyacentes(nodoMST);
				for (Integer nodoAdyacente : adyacentes) {
					if(conjuntoG.contains(nodoAdyacente)) {
						if(min > this.grafo.getArista(nodoMST, nodoAdyacente)) {
							min = this.grafo.getArista(nodoMST, nodoAdyacente);
							nodoLlegadaMin = nodoAdyacente;
							nodoSalidaMin = nodoMST;
						}
					}
				}
			}
			
			if (min != Double.MAX_VALUE) {
				System.out.println("Nodo: "+ nodoSalidaMin+" Nodo: "+nodoLlegadaMin+" con valor: "+min);
				this.costoMinimo += min;
				this.grafoResultado.setArista(nodoSalidaMin, nodoLlegadaMin, min, false);
				nodoSalidaMin = nodoLlegadaMin;
			}
		}
		
	}
	
	public double getCostoTotal() {
		return this.costoMinimo;
	}
	
	public GrafoLista getGrafoResultado() {
		return this.grafoResultado;
	}
}
