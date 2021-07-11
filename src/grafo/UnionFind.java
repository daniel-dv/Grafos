package grafo;

public class UnionFind {
	private int[] vector;
	
	public UnionFind(int cantNodos) {
		
		this.vector = new int[cantNodos];
		
		for(int i=0; i<cantNodos; i++)
			vector[i]=i;
	}
	
	public int find(int nodo) {
		while(vector[nodo] != nodo)
			nodo = vector[nodo];
		
		return nodo;
	}
	
	public void union(int representanteOrigen, int representanteDestino) {
		if(representanteOrigen<representanteDestino)
			vector[representanteDestino] = representanteOrigen;
		else
			vector[representanteOrigen] = representanteDestino;
	}
	
	public int getCantNodos() {
		return this.vector.length;
	}
}
