package algoritmos;

import java.util.List;

import grafo.Arista;
import grafo.GrafoMatriz;

public class Warshall {
	private GrafoMatriz grafo;
	private boolean [][] matriz;
	
	public Warshall (GrafoMatriz grafo) {
		this.grafo = grafo;
		matriz = new boolean [this.grafo.getNodos()][this.grafo.getNodos()];
		grafoAMatriz();
		ejecutar();
	}
	
	private void ejecutar() {
		
		boolean[][] matrizAnt = this.matriz.clone(); 
		for(int k=0; k<matriz.length; k++) {
			for (int i=0; i<matriz.length; i++) {
				for(int j=0; j<matriz.length; j++) {
					if(i!=k && j!=k && i!=j) {
						matriz[i][j] = matriz[i][j] || (matrizAnt[i][k] && matrizAnt[k][i]);
					}
					
				}
			}
			matriz = matrizAnt;
		}
	}
	
	private void grafoAMatriz() {
		List<Arista> aristas = grafo.getAristas();
		for (Arista arista : aristas) {
			System.out.print(arista.getOrigen() + " "+arista.getDestino()+ " ");
			System.out.println(this.matriz[arista.getOrigen()][arista.getDestino()]);
			this.matriz[arista.getOrigen()][arista.getDestino()] = true;
		}
	}
	
	@Override
	public String toString() {
		String salida="";
		for (int i = 0; i<this.matriz.length; i++) {
			for(int j=0; j<this.matriz.length; j++) {
				salida+= this.matriz[i][j]+ " ";
			}
			salida+="\n";
		}
		return salida;	
	}
	
}
