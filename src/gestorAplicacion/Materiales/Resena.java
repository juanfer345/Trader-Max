/* 
   Clase Resena (p�blica)
   
   Prop�sito:
   Se definen y se crean las rese�as de cada producto
   
   Estructuras de datos relevantes:
 */

package gestorAplicacion.Materiales;

import gestorAplicacion.Usuarios.Comprador;

public class Resena {

	//Atributos
	private Comprador comp;
	private String comentario;
	private int estrellas, id = 1;
	static int contador;

	// Constructor para rese�as existentes
	public Resena(int id, String comentario, int estrellas) {
		/*
		   Prop�sito: Construye la rese�a de un Producto
		   
		   Par�metros de entrada: 
		   - int id: Codigo de identificaci�n para rese�as
		   - int estrellas, String comentario: Opini�n del usuario acerca del producto
		 */
		this.id = id;
		this.estrellas = estrellas;
		this.comentario = comentario;
	}

	// Constructor para rese�as nuevas (Llama a otro constructor)
	public Resena(Comprador comp, int estrellas) {
		this(comp, "Sin comentario", estrellas);
	}

	// Constructor para rese�as nuevas (Llama a otro constructor)
	public Resena(Comprador comp, String comentario) {
		this(comp, comentario, 0);
	}

	// Constructor para rese�as nuevas
	public Resena(Comprador comp, String comentario, int estrellas) {
		this.comp = comp;
		this.comentario = comentario;
		this.estrellas = estrellas;
		id = contador++;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public Comprador getComprador() {
		return this.comp;
	}

	public void setComprador(Comprador comprador) {
		this.comp = comprador;
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

	public static void setMaxID(int contador) {
		Resena.contador = contador + 1;
	}

	@Override
	public String toString() {
		return "Rese�a [Estrellas=" + estrellas + "\n Comentario=" + comentario + "]";
	}
}