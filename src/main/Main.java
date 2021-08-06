package main;

import java.util.LinkedList;
import java.util.List;

import algoritmos.*;
import grafo.*;

public class Main {
	public static void main(String[] args) {

		//probarDijkstra();
		// probarPrim();
		// probarKruskal();
		// probarFloyd();
		// probarWarshall();
		//probarPrimParcial();
		//probarBFS();
		probarDFS();
	}

	public static void probarFloyd() {
		GrafoMatriz grafo = new GrafoMatriz(3);
		grafo.setArista(0, 1, 8, true);
		grafo.setArista(1, 0, 3, true);
		grafo.setArista(0, 2, 5, true);
		grafo.setArista(2, 1, 2, true);
//		System.out.println(grafo);
		Floyd floyd = new Floyd(grafo);
		System.out.println(floyd);
	}
	
	public static void probarBFS() {
		Grafo grafo = new GrafoLista(6);
		grafo.setArista(0, 1, 1, false);
		grafo.setArista(0, 2, 1, false);
		grafo.setArista(1, 3, 1, false);
		grafo.setArista(2, 3, 1, false);
		grafo.setArista(2, 4, 1, false);
		grafo.setArista(3, 5, 1, false);
		grafo.setArista(3, 4, 1, false);
		BFS bfs = new BFS (grafo, 0);
		System.out.println(bfs.getArbol());
	}
	
	public static void probarDFS() {
		Grafo grafo = new GrafoMatriz(6);
		grafo.setArista(0, 1, 1, false);
		grafo.setArista(0, 2, 1, false);
		grafo.setArista(1, 3, 1, false);
		grafo.setArista(2, 3, 1, false);
		grafo.setArista(2, 4, 1, false);
		grafo.setArista(3, 5, 1, false);
		grafo.setArista(3, 4, 1, false);
		DFS dfs = new DFS (grafo, 0);
		System.out.println(dfs.getArbol());
	}

	public static void probarPrimParcial() {
		Grafo grafo = new GrafoLista(5);
		grafo.setArista(0, 2, 4, false);
		grafo.setArista(0, 1, 5, false);
		grafo.setArista(0, 3, 5, false);
		grafo.setArista(0, 4, 5, false);
		grafo.setArista(1, 2, 2, false);
		grafo.setArista(1, 3, 2, false);
		grafo.setArista(1, 4, 3, false);
		grafo.setArista(3, 4, 2, false);
		Prim prim = new Prim (grafo);
		prim.getGrafoResultado();
	}

	public static void probarWarshall() {
		GrafoMatriz grafo = new GrafoMatriz(3);
		grafo.setArista(0, 1, 8, true);
		grafo.setArista(1, 0, 3, true);
		grafo.setArista(0, 2, 5, true);
		grafo.setArista(2, 1, 2, true);
//		System.out.println(grafo);
		Warshall warshall = new Warshall(grafo);
		System.out.println(warshall);
	}

	public static void probarPrim() {
		Grafo grafo = new GrafoLista(9);
		grafo.setArista(0, 1, 4, false);
		grafo.setArista(0, 8, 8, false);
		grafo.setArista(1, 8, 11, false);
		grafo.setArista(1, 3, 8, false);
		grafo.setArista(2, 8, 7, false);
		grafo.setArista(2, 3, 2, false);
		grafo.setArista(2, 7, 6, false);
		grafo.setArista(3, 4, 7, false);
		grafo.setArista(3, 6, 4, false);
		grafo.setArista(4, 6, 14, false);
		grafo.setArista(4, 5, 9, false);
		grafo.setArista(5, 6, 10, false);
		grafo.setArista(6, 7, 2, false);
		grafo.setArista(7, 8, 1, false);
//		System.out.println(grafo);
		Prim prim = new Prim(grafo);
		System.out.println(prim.getGrafoResultado());
//		System.out.println(prim.getCostoTotal());
	}

	public static void probarKruskal() {
		List<Arista> aristas = new LinkedList<Arista>();
		aristas.add(new Arista(0, 1, 4));
		aristas.add(new Arista(0, 8, 8));
		aristas.add(new Arista(1, 8, 11));
		aristas.add(new Arista(1, 3, 8));
		aristas.add(new Arista(2, 8, 7));
		aristas.add(new Arista(2, 3, 2));
		aristas.add(new Arista(2, 7, 6));
		aristas.add(new Arista(3, 4, 7));
		aristas.add(new Arista(3, 6, 4));
		aristas.add(new Arista(4, 6, 14));
		aristas.add(new Arista(4, 5, 9));
		aristas.add(new Arista(5, 6, 10));
		aristas.add(new Arista(6, 7, 2));
		aristas.add(new Arista(7, 8, 1));

//		System.out.println(grafo);
		Kruskal kruskal = new Kruskal(aristas, 9);
		Grafo grafoResultado = kruskal.getGrafoResultado();
		System.out.println(kruskal.getCostoMinimo());
		System.out.println(grafoResultado);
	}

	public static void probarDijkstra() {
		// Creacion de un grafo
		Grafo grafo = new GrafoLista(5);

		grafo.setArista(0, 3, 30, false);
		grafo.setArista(0, 1, 10, false);
		grafo.setArista(0, 4, 100, false);
		grafo.setArista(1, 2, 50, false);
		grafo.setArista(2, 4, 10, false);
		grafo.setArista(3, 4, 60, false);
		grafo.setArista(3, 2, 20, false);

		// Dijkstra nos retorna un vector con las distancias desde el nodo de origen
		// (enviado por parametro) a todos los nodos del grafo
		int desde = 0;
		Dijkstra dijkstra = new Dijkstra(grafo, desde);
		double[] distancias = dijkstra.getDistancias();
		for (int i = 0; i < distancias.length; i++)
			System.out.println("Distancia al nodo " + i + ": " + distancias[i]);

		// Mostramos camino desde el nodo origen hasta el nodo 4
		int hasta = 4;
		List<Integer> camino = dijkstra.obtenerCamino(hasta);

		for (int nroNodo : camino) {
			System.out.println(nroNodo);
		}
	}
}
