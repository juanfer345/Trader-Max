package gestorAplicaci�n.Materiales;

public class Rese�a {
	private int estrellas;
	private String comentario;
    private int id; //A�adido para poder utilizarlo en la base de datos (Juanfer)
    
	public Rese�a(int estrellas) {
		this("Sin comentario",estrellas);
	}
	
	public Rese�a(String comentario) {
		this(comentario, 0);
	}
	
	public Rese�a(String comentario, int estrellas) {
		this.comentario=comentario;
		this.estrellas=estrellas;
	}
	
	//Constructor por default necesario para la BD (Juanfer)
	public Rese�a() {
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
	
    public String mostrarRese�a() {
    	return "Comentario: " + comentario + ". \nEstrellas:" + estrellas;
    	
    }
    
	// A�adido de aqui pa abajo para la BD (Juanfer)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}