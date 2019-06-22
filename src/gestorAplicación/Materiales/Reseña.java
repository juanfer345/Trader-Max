package gestorAplicaci�n.Materiales;

public class Rese�a {

	@Override
	public String toString() {
		return "Rese�a [Estrellas=" + estrellas + "\n Comentario=" + comentario + "]";
	}

	private int estrellas;
	private String comentario;
    private int id;
    
    
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
