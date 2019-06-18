package gestorAplicación.Materiales;

public class Reseña {
	private int estrellas;
	private String comentario;
	
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
    	return "Comentario: " + comentario + ". Estrellas:" + estrellas;
    		
    	
    }
	
}
