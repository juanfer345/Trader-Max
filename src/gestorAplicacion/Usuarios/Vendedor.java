package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.Salir;
import uiMain.Funcionalidades.Cuenta.CerrarSesion;
import uiMain.Funcionalidades.Cuenta.Vendedor.ModificarCantidad;
import uiMain.Funcionalidades.Cuenta.Vendedor.CambiarPrecio;
import uiMain.Funcionalidades.Cuenta.Vendedor.EliminarProductoCatalogo;
import uiMain.Funcionalidades.Cuenta.Vendedor.SubirProducto;

public class Vendedor extends CuentaUsuario {

	public Vendedor() {
		super();
		totalDeOpcionesDefault = 4;
		setOpcionesDeMenuPredeterminadas();
	}

	public Vendedor(String nombre, String correo, String password, int cedula) {
		super(nombre, correo, password, cedula);
		totalDeOpcionesDefault = 4;
		setOpcionesDeMenuPredeterminadas();
	}

	public void setOpcionesDeMenuPredeterminadas() {
		Cuenta.menu.setOpcionesActivas(new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] {
				new SubirProducto(), new EliminarProductoCatalogo(), new ModificarCantidad(),new CambiarPrecio(),new CerrarSesion(),new Salir() })));
	}

	public ArrayList<OpcionDeMenu> getOpcionesDeMenuPredeterminadas() {
		return new ArrayList<OpcionDeMenu>(Arrays.asList(new OpcionDeMenu[] { new SubirProducto(),
				new EliminarProductoCatalogo(),new ModificarCantidad(),new CambiarPrecio(), new CerrarSesion(), new Salir() }));
	}

	public static void subirProducto(Vendedor vendedor, String nombreProducto, String categoria, double precio,
			int cantidad) {
		Producto p = new Producto(vendedor, precio, cantidad, nombreProducto, categoria);
		catalogo.put(p.getCodigoProducto(), p);
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

	public static String modificarCantidad(String nombre, int valorOperar,String operador) {
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
			if(operador == "+"){			
			int can_final = comprobarProducto.getCantidad() + valorOperar;
			comprobarProducto.setCantidad(comprobarProducto.getCantidad() + valorOperar);
			return "Se aument� la cantidad del producto: " + comprobarProducto.getNombreProducto() + " cantidad actual: " + can_final +"\n";
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
			if (p.getCodigoProducto() == cod) {
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
				return "Se elimin� el producto exitosamente";
			} else {
				return "No es un producto propio, no puede ser eliminado";
			}
		}
	}

	@Override
	public ArrayList<OpcionDeMenu> getOpcionesDeMenu() {
		return menu.getOpcionesActivas();
	}

}