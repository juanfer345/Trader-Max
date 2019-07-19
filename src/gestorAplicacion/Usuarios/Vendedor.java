package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.MenuConsola.Salir;
import uiMain.MenuConsola.Cuenta.CerrarSesion;
import uiMain.MenuConsola.Cuenta.Vendedor.CambiarPrecio;
import uiMain.MenuConsola.Cuenta.Vendedor.EliminarProductoCatalogo;
import uiMain.MenuConsola.Cuenta.Vendedor.ModificarCantidad;
import uiMain.MenuConsola.Cuenta.Vendedor.SubirProducto;

public class Vendedor extends CuentaConBanco {

	private static final int totalDeOpcionesDefault = 6;

	//Constructor para usuarios existentes
	public Vendedor(int idCuenta, String nombre, String correo, String password, int cedula) {
		super(idCuenta, nombre, correo, password, cedula);
	}

	//Constructor para usuarios nuevos
	public Vendedor(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
	}

	public ArrayList<OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { 
				new ModificarCantidad(), new CambiarPrecio(), new EliminarProductoCatalogo(), 
				new SubirProducto(), new CerrarSesion(), new Salir() }));
	}

	public int getTotalDeOpcionesDefault() {
		return totalDeOpcionesDefault;
	}

	public static void subirProducto(Vendedor vendedor, String nombreProducto, String categoria, double precio,
			int cantidad) {
		Producto p = new Producto(nombreProducto, categoria, vendedor, precio, cantidad);
		catalogo.put(p.getId(), p);
	}

	public static String cambiarPrecio(String nombre, double precio) {
		Producto comprobarProducto = null;
		//comprobar que el producto este en el catalogo
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getNombreProducto().equals(nombre) && iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				comprobarProducto = iteradorCatalogo;
				break;
			}
		}
		if (comprobarProducto == null) {
			return "El producto no existe, no se puede cambiar el precio\n";
		}
		//cambiar precio
		else {
			comprobarProducto.setPrecio(precio);
			return "Se ha cambiado el precio del producto: " + comprobarProducto.getNombreProducto() + ". Precio actual: "
			+ comprobarProducto.getPrecio()+"\n";
		}
	}

	public static String ModificarCantidad(String nombre, int valorOperar,String operador) {
		Producto comprobarProducto = null;
		//comprobar que el producto esta en el catalogo
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getNombreProducto().equals(nombre) && iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				comprobarProducto = iteradorCatalogo;
				break;
			}
		}
		if (comprobarProducto == null) {
			return "El producto no existe, no se puede modificar la cantidad\n";
		} 
		else {
			//aumentar cantidad
			if(operador.equals("+")){			
			int can_final = comprobarProducto.getCantidad() + valorOperar;
			comprobarProducto.setCantidad(comprobarProducto.getCantidad() + valorOperar);
			return "Se aumentó la cantidad del producto: " + comprobarProducto.getNombreProducto() + " cantidad actual: " + can_final +"\n";
			}
			//disminuir cantidad
			else {
				int can_final = comprobarProducto.getCantidad() - valorOperar;
				if (can_final>=0) {									
				comprobarProducto.setCantidad(comprobarProducto.getCantidad() - valorOperar);
				return "Se redujo la cantidad del producto: " + comprobarProducto.getNombreProducto() + " cantidad actual: " + can_final +"\n";
			}
				else {
				 return "No hay suficientes productos, no se puede disminuir su cantidad";
				}
				}
		}
	}
	public String eliminarProductoCatalogo(int cod) {
		Producto mens = null;
		for (Map.Entry<Integer, Producto> entry : catalogo.entrySet()) {
			Producto p = entry.getValue();
			if (p.getId() == cod) {
				mens = p;
				break;
			}
		}
		if (mens == null) {
			return "No existe el producto";
		} else {
			int id = this.id;
			int id_mens = mens.getVendedor().getId();
			if (id == id_mens) {
				catalogo.remove(cod);
				return "Se eliminó el producto exitosamente";
			} else {
				return "No es un producto propio, no puede ser eliminado";
			}
		}
	}
}