package gestorAplicación.Materiales;

public class Reseña {

	@Override
	public String toString() {
		return "Reseña [Estrellas=" + estrellas + "\n Comentario=" + comentario + "]";
	}

	private int estrellas;
	private String comentario;
    private int id;
    
    
	public Reseña(int estrellas) {
		this("Sin comentario",estrellas);
	}
	
	public Reseña(String comentario) {
		this(comentario, 0);
	}
	
	public Reseña(String comentario, int estrellas) {
		this.comentario=comentario;
		this.estrellas=estrellas;
	}

	public Reseña() {
		
	}

	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
