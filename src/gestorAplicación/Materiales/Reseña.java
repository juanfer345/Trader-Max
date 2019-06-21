package gestorAplicación.Materiales;

public class Reseña {
	private int estrellas;
	private String comentario;
    private int id; //Añadido para poder utilizarlo en la base de datos (Juanfer)
    
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
	
	//Constructor por default necesario para la BD (Juanfer)
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
	
    public String mostrarReseña() {
    	return "Comentario: " + comentario + ". \nEstrellas:" + estrellas;
    	
    }
    
	// Añadido de aqui pa abajo para la BD (Juanfer)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}