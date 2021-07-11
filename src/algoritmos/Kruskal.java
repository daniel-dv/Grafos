package algoritmos;

import java.util.List;
import java.util.PriorityQueue;

import grafo.*;

public class Kruskal {
	private GrafoLista grafoResultado;
	private List<Arista> aristas;
	private UnionFind unionFind;
	private int cantNodos;
	private double costoMinimo;

	public Kruskal(List<Arista> aristas, int cantNodos) {
		this.aristas = aristas;
		this.cantNodos = cantNodos;
		this.grafoResultado = new GrafoLista(cantNodos);
		this.costoMinimo = 0;
		this.unionFind = new UnionFind(cantNodos);
		ejecutar();
	}

	private void ejecutar() {
		PriorityQueue<Arista> arista = new PriorityQueue<Arista>();

		arista.addAll(this.aristas);

		int i = 0;

		while (i < this.cantNodos - 1) {
			Arista actual = arista.poll();
			
			int representanteOrigen = unionFind.find(actual.getOrigen());
			int representanteDestino = unionFind.find(actual.getDestino());
			
			if(representanteOrigen != representanteDestino) {
				i++;
				unionFind.union(representanteOrigen, representanteDestino);
				grafoResultado.setArista(actual.getOrigen(), actual.getDestino(), actual.getCosto(), false);
				costoMinimo+= actual.getCosto();
			}
		}
	}
	
	public double getCostoMinimo() {
		return this.costoMinimo;
	}
	
	public GrafoLista getGrafoResultado() {
		return this.grafoResultado;
	}
}
