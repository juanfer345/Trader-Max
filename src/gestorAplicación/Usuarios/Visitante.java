package gestorAplicaci�n.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.buscarCategoria;
import uiMain.Funcionalidades.buscarProducto;
import uiMain.Funcionalidades.iniciarSesion;
import uiMain.Funcionalidades.registrar;
import uiMain.Funcionalidades.salir;

public class Visitante extends Cuenta {
	
	public void setMenuPredeterminado() {
		Cuenta.menu.cambiarMenu(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
										  new buscarProducto(), new buscarCategoria(), new salir()})), this);
	}
	
	public void setMenu(ArrayList <OpcionDeMenu> opcionesActivas) {
		Cuenta.menu.cambiarMenu(opcionesActivas, this);
	}
	
	public Visitante() {
		super();
		Cuenta.menu = new MenuDeConsola(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new iniciarSesion(), new registrar(), 
				  		new buscarProducto(), new buscarCategoria(),new salir()})), this);
	}
	
	public HashMap <Integer,Producto> verProductos() {
		return Vendedor.catalogo;
	}

	public static Deque<Producto> buscarCategoria(String cat) {
		Deque<Producto> colaProd = new LinkedList<Producto>();
		(Vendedor.catalogo).forEach((k, v) -> {
			Producto p = Vendedor.catalogo.get(k);
			if (p.getCategoria() == cat) {
				colaProd.add(p);
			}
		});
		return colaProd;
	}

//	public String IniciarSesion(String c, String p) {
//		Integer key = -1;
//		Cuenta us;
//		byte intentar = 1;
//		(InicializacionAplicacion.getBDCompradores()).forEach((k, v) -> {
//			if ((v.getCorreo().equals(c))) {
//				key = k;
//			}
//		});
//		if (key != -1 && (InicializacionAplicacion.getBDCompradores()).get(key).getPassword().equals(p)) {
//			us = (InicializacionAplicacion.getBDCompradores()).get(key);
//		} else if (key == -1) {
//			(InicializacionAplicacion.getBDVendedores()).forEach((k, v) -> {
//				if ((v.getCorreo().equals(c))) {
//					key = k;
//				}
//			});
//			if (key != -1 && (InicializacionAplicacion.getBDVendedores()).get(key).getPassword().equals(p)) {
//				us = (InicializacionAplicacion.getBDVendedores()).get(key);
//			}
//		} else {
//			(InicializacionAplicacion.getBDAdministradores()).forEach((k, v) -> {
//				if ((v.getCorreo().equals(c))) {
//					key = k;
//				}
//			});
//			if (key != -1 && (InicializacionAplicacion.getBDAdministradores()).get(key).getPassword().equals(p)) {
//				us = (InicializacionAplicacion.getBDAdministradores()).get(key);
//			}
//		}
//		if (key == -1) {
//			System.out.println("El correo no se encuentra registrado");
//		} else {
//			do {
//				if (us.getPassword().equals(p)) {
//					Cuenta usuario = us;
//					break;
//				} else {
//					System.out.println("Contrase�a incorrecta. \n1.Volver a intentar\n2.Cancelar");
//					//intentar = Byte.parseByte(br.readLine());	CORREGIR BUFFERED READER
//					if (intentar == 1) {
//						System.out.println("Ingrese la contrase�a: ");
//						//p = scn.next();
//					}
//				}
//			} while (intentar != 1);
//			if (intentar == 2) {
//				// se devuelve al inicializador de aplicacion
//			}
//		}
//	}

}