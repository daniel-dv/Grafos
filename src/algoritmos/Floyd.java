package algoritmos;

import grafo.GrafoMatriz;

public class Floyd {
	private GrafoMatriz grafo;
	private double [][] matriz;
	public Floyd (GrafoMatriz grafo) {
		this.grafo = grafo;
		matriz = new double [this.grafo.getNodos()][this.grafo.getNodos()];
		matriz=grafo.getMatriz().clone();
		ejecutar();
	}
	
	private void ejecutar() {
		double[][] matrizAnt = matriz.clone(); 
		for (int i=0; i<matriz.length; i++)
			matriz[i][i]=0;
		
		for(int k=0; k<matriz.length; k++) {
			for (int i=0; i<matriz.length; i++) {
				for(int j=0; j<matriz.length; j++) {
					if(i!=k && j!=k && i!=j) {
						double min = Math.min(matrizAnt[i][j], matrizAnt[i][k]+matrizAnt[k][j]);
						matriz[i][j] = min;
					}
					
				}
			}
			matrizAnt = matriz;
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
