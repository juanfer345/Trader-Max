package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.Materiales.Producto;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public abstract class Cuenta {

	public static HashMap <Integer, Producto> catalogo = new HashMap<>();
	ArrayList <OpcionDeMenu> menu;
	protected static ArrayList <OpcionDeMenu> cambioOpDeMen;
	private String nombre, correo, password;
	public int id;
	private int cedula;
	static int contador;
	static int totalCuentas;
	
	//Constructor para usuarios existentes	
	public Cuenta(int id, String nombre, String correo, String password, int cedula) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.cedula = cedula;
	}
	
	//Constructor para usuarios nuevos
	Cuenta(String nombre, String correo, String password, int cedula) {
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.cedula = cedula;
		this.id = contador++;
		totalCuentas++;
		setMenuPredeterminado();
	}
	
	public Cuenta() {setMenuPredeterminado();}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getCorreo() {return correo;}
	public void setCorreo(String correo) {this.correo = correo;}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public int getCedula() {return cedula;}
	public void setCedula(int cedula) {this.cedula = cedula;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
		
	public static int getTotalCuentas() {return totalCuentas;}
	public static void setTotalCuentas(int totalCuentas) {Cuenta.totalCuentas = totalCuentas;}
	
	public static void setMaxID(int contador) {
		Cuenta.contador = contador + 1;
	}
	
	public ArrayList <OpcionDeMenu> getMenu(){
		return menu;
	};
	
	public void setMenu(Deque <Integer> idOpciones) {
		ArrayList<OpcionDeMenu> menuTotal = OpcionDeMenu.getTodasLasOpciones();
		menu = new ArrayList<>();
		while (!idOpciones.isEmpty()) {
			menu.add(menuTotal.get(idOpciones.poll()));
		}
	}
	
	abstract ArrayList<OpcionDeMenu> getMenuPredeterminado();
	
	void setMenuPredeterminado() {
		menu = getMenuPredeterminado();
	};
	
	//M�todo para salir de la aplicaci�n
	public String salir (byte seleccion) {
		if (seleccion == 1) {
			OpcionDeMenu.controlError = true; 
			MenuDeConsola.SalirApp = true;
			return "\nLa aplicaci�n ser� cerrada";
		}
		else if (seleccion == 2) {
			OpcionDeMenu.controlError = true;
			return "";
		}
		else {
			return "Por favor ingrese un n�mero entero en el rango [1,2].";
		}
	}
	
	//B�squeda de producto por c�digo
	public String buscarProducto(int codigo) {
		
		Producto prod;
	    StringBuilder sb = new StringBuilder();
		
		if (catalogo.containsKey(codigo)) {

			prod = catalogo.get(codigo);
			sb.append("\nEl producto fue encontrado: \n");
			sb.append("[Nombre: " + prod.getNombreProducto() + ",/n");
			sb.append("Categoria: " + prod.getCategoria() + ",/n");
			sb.append("Precio: " + prod.getPrecio() + ",/n");
			sb.append("C�digo: " + codigo + ",/n");
			sb.append("Cantidad: " + prod.getCantidad() + "]/n");
			OpcionDeMenu.controlError = true;
			return sb.toString();
		}
		else if (catalogo.isEmpty()) {
			OpcionDeMenu.controlError = true;
			return "El cat�logo se encuentra vac�o.\n";
		}
		else {
			return "Producto no encontrado.\n";
		}
	}
	
	//B�squeda de producto por nombre (puede retornar varios resultados)
	public String buscarProducto(String nombre) {
		
	    StringBuilder sb = new StringBuilder();
	    
	    //B�squeda de cada producto
		catalogo.forEach((k, v) -> {
			Producto prod = catalogo.get(k);
			if (prod.getNombreProducto().contains(nombre)) {
				sb.append(prod.toString() + '\n');
			}
		});
		
		//Comprobaci�n del resultado
		if (sb.length() > 0) {
			OpcionDeMenu.controlError = true;
			return sb.append("\nEl producto fue encontrado: \n" + sb).toString();
		}
		else if (catalogo.isEmpty()) {
			OpcionDeMenu.controlError = true;
			return "El cat�logo se encuentra vac�o.\n";
		}
		else {
			return "Producto no encontrado.\n";
		}
	}
	
	//Mostrar cat�logo (todos los productos)
	public String mostrarCatalogo() {
		
	    StringBuilder sb = new StringBuilder();

		if (!catalogo.isEmpty()) {
			sb.append("\nCat�logo de TRADER-MAX: \n");
			for (Map.Entry <Integer, Producto> entry : catalogo.entrySet()) {
				sb.append(entry.getValue().toString() + '\n');
			}
			OpcionDeMenu.controlError = true;
			return sb.toString();
		}
		else {
			OpcionDeMenu.controlError = true;
			return "El cat�logo se encuentra vac�o.\n";
		}
	}
	
	//Mostrar todos los productos de una categoria
	public String mostrarCategoria(byte cat) {
		
	    StringBuilder sb = new StringBuilder();
	    
		//Verificaci�n de catalogo no vac�o
		if (!catalogo.isEmpty()) {
			//Verificaci�n de �ndice v�lido
			if (cat > 0 && cat < Producto.categorias.length) {
				
				//Ciclo para hallar cada producto de la categor�a adecuada
				(catalogo).forEach((k, v) -> {
					Producto prod = catalogo.get(k);
					if (prod.getCategoria() == Producto.categorias[cat]) {
						sb.append(prod.toString() + '\n');
					}
				});
				OpcionDeMenu.controlError = true;
				return "Categor�a " + Producto.categorias[cat] + ":\n" + sb.toString();
			}
			else {
				return "Categoria inv�lida, por favor ingrese un �ndice dentro del rango establecido.";
			}
		}
		else {
			OpcionDeMenu.controlError = true;
			return "El cat�logo se encuentra vac�o.\n";
		}
	}

	public static ArrayList<OpcionDeMenu> getCambioOpDeMen() {
		return cambioOpDeMen;
	}

	public static void setCambioOpDeMen(ArrayList<OpcionDeMenu> cambioOpDeMen) {
		Cuenta.cambioOpDeMen = cambioOpDeMen;
	}

	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", id=" + id + ", cedula="
				+ cedula;
	}
}