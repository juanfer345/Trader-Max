package gestorAplicacion.Materiales;

import gestorAplicacion.Usuarios.Comprador;

public class Resena {	
	
    private Comprador comp;
	private String comentario;
	private int estrellas, id;
	static int contador;
    
	//Constructor para reseñas existentes
	public Resena(int id, String comentario, int estrellas) {
		this.id = id;
		this.estrellas = estrellas;
		this.comentario = comentario;
	}

	//Constructor para reseñas nuevas
	public Resena(Comprador comp, int estrellas) {
		this(comp, "Sin comentario", estrellas);
	}
	
	//Constructor para reseñas nuevas
	public Resena(Comprador comp, String comentario) {
		this(comp, comentario, 0);
	}
	
	//Constructor para reseñas nuevas
	public Resena(Comprador comp, String comentario, int estrellas) {
		this.comp = comp;
		this.comentario = comentario;
		this.estrellas = estrellas;
		id = contador++;
	}
	
	public int getEstrellas() {return estrellas;}
	public void setEstrellas(int estrellas) {this.estrellas = estrellas;}
	
	public Comprador getComprador() {return this.comp;}
	public void setComprador(Comprador comprador) {this.comp = comprador;}
	
	public String getComentario() {return comentario;}
	public void setComentario(String comentario) {this.comentario = comentario;}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public static void setMaxID(int contador) {
		Resena.contador = contador + 1;
	}
	
	@Override
	public String toString() {
		return "Reseña [Estrellas=" + estrellas + "\n Comentario=" + comentario + "]";
	}
}