package gestorAplicaci�n.Materiales;

public class Rese�a {
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
	
    public String mostrarRese�a() {
    	return "Comentario: " + comentario + ". Estrellas:" + estrellas;
    		
    	
    }
	
}
