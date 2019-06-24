package gestorAplicaci�n.Materiales;
import gestorAplicaci�n.Usuarios.Comprador;

public class Resena {	

	@Override
	public String toString() {
		return "Rese�a [Estrellas=" + estrellas + "\n Comentario=" + comentario + "]";
	}

	private int estrellas;
	private String comentario;
    private int id;
    Comprador comp;
    
    
	public Resena(int estrellas) {
		this("Sin comentario",estrellas);
	}
	
	public Resena(String comentario) {
		this(comentario, 0);
	}
	
	public Resena(String comentario, int estrellas) {
		this.comentario=comentario;
		this.estrellas=estrellas;
	}

	public Resena() {
		
	}

	public int getEstrellas() {
		return estrellas;
	}
	
	public void setComprador(Comprador comprador) {
		this.comp = comprador;
	}
	
	public Comprador getComprador() {
		return this.comp;
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
