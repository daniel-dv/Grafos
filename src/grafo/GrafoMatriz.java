package grafo;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GrafoMatriz extends Grafo implements Cloneable{

	private double [][] matrizAdyacencia;

	public GrafoMatriz(int tamano) {
		this.matrizAdyacencia = new double[tamano][tamano];
		for(int i=0; i<tamano; i++) 
			for(int j=0; j<tamano; j++)
				this.matrizAdyacencia[i][j]=Double.MAX_VALUE;
	}

	@Override
	public int getNodos() {
		return this.matrizAdyacencia.length;
	}

	@Override
	public void setArista(int desde, int hasta, double costo, boolean esDirigido) {
		this.matrizAdyacencia[desde][hasta] = costo;
		if (!esDirigido)
			this.matrizAdyacencia[hasta][desde] = costo;
	}

	@Override
	public Double getArista(int desde, int hasta) {
		return this.matrizAdyacencia[desde][hasta]!=Double.MAX_VALUE?this.matrizAdyacencia[desde][hasta]:null;
	}
	
	public double [][] getMatriz(){
		return this.matrizAdyacencia;
	}
	
	public List<Arista> getAristas(){
		List<Arista> aristas = new LinkedList<Arista>();
		for (int i=0; i<this.matrizAdyacencia.length; i++)
			for(int j=0; j<this.matrizAdyacencia.length; j++) {
				if(this.matrizAdyacencia[i][j] != Double.MAX_VALUE)
					aristas.add(new Arista(i, j, this.matrizAdyacencia[i][j]));
			}
		return aristas;
	}
	
	public double[] obtenerAdyacentes(int nodo) {
		return this.matrizAdyacencia[nodo];
	}

	@Override
	public List<PriorityQueue<Adyacente>> getGrafo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getNodosAdyacentes(int nodo) {
		List<Integer> lista = new LinkedList <Integer>();
			for (int j=0; j<this.matrizAdyacencia.length; j++) {
				if (this.matrizAdyacencia[nodo][j] != Double.MAX_VALUE)
					lista.add(j);
			}
		return lista;
	}

	@Override
	public List<Adyacente> getAdyacentes(int nodo) {
		// TODO Auto-generated method stub
		return null;
	}
}


