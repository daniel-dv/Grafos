package grafo;

public class Nodo implements Comparable<Nodo>{
	private int id;
	private int grado;
	
	public Nodo (int nodo, int grado) {
		this.id = nodo;
		this.grado = grado;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.grado-o.grado;
	}
	
	public int getNodo() {
		return this.id;
	}
	
	public int getGrado() {
		return this.grado;
	}
	
}
