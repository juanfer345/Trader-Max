package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.BuscarProducto;
import uiMain.Funcionalidades.MostrarCatalogo;
import uiMain.Funcionalidades.MostrarPorCategoria;
import uiMain.Funcionalidades.Salir;
import uiMain.Funcionalidades.Visitante.IniciarSesion;
import uiMain.Funcionalidades.Visitante.Registrar;

public class Visitante extends Cuenta {

	public Visitante() {
		super();
		this.totalDeOpcionesDefault = 5;
		setOpcionesDeMenuPredeterminadas();
	}
	
	public void setOpcionesDeMenuPredeterminadas() {
		Cuenta.menu.setOpcionesActivas(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new IniciarSesion(), new Registrar(), 
										  new BuscarProducto(), new MostrarPorCategoria(), new MostrarCatalogo(), new Salir()})));
	}
	
	public ArrayList <OpcionDeMenu> getOpcionesDeMenuPredeterminadas() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new IniciarSesion(), new Registrar(), 
				  new BuscarProducto(), new MostrarPorCategoria(), new MostrarCatalogo(), new Salir()}));
	}
	
	public ArrayList <OpcionDeMenu> getOpcionesDeMenu() {
		return menu.getOpcionesActivas();
	}
	
	public HashMap <Integer,Producto> verProductos() {
		return Vendedor.catalogo;
	}
	

	public  String Registrarse(short tipoDeCuenta,String nombreDado,String correoDado,int cedulaDada,String contrasenaDada) {
		boolean correoRegistrado = false;
		if (tipoDeCuenta == 1) {            //busqueda de correo si el usuario quiere ser un VENDEDOR

			for (Entry<Integer, CuentaUsuario> entry : (InicializacionAplicacion.getBDCompradores()).entrySet()) {       //busqueda de correo en el  hash de compradores			
				if((entry.getValue().getCorreo().equals(correoDado))) {
					correoRegistrado=true;
					break;
				}
			}

			for (Entry<Integer, CuentaUsuario> entry : (InicializacionAplicacion.getBDVendedores()).entrySet()) {     //busqueda de correo en el  hash de vendedores				
				if((entry.getValue().getCorreo().equals(correoDado))) {
					correoRegistrado=true;
					break;
				}

			}

			for (Entry<Integer, Administrador> entry : (InicializacionAplicacion.getBDAdministradores()).entrySet()) {	  //busqueda de correo en el  hash de admnin			
				if((entry.getValue().getCorreo().equals(correoDado))) {
					correoRegistrado=true;
					break;
				}

			}

			if (correoRegistrado==false) {		//en caso de que no se encuentre el correo registrado en ninguna tabla
				InicializacionAplicacion.usuarioActivo = new Vendedor(nombreDado, correoDado, contrasenaDada, cedulaDada);
				(InicializacionAplicacion.getBDVendedores()).put(InicializacionAplicacion.usuarioActivo.getId(), (Vendedor) InicializacionAplicacion.usuarioActivo);
				InicializacionAplicacion.usuarioActivo.setOpcionesDeMenuPredeterminadas();
				return "Registro exitoso";
			}else {
				return "El correo ya se encuentra registrado";
			}
		} else {          //busqueda de correo y registro si el usuario quiere ser COMPRADOR


			for (Entry<Integer, CuentaUsuario> entry : (InicializacionAplicacion.getBDCompradores()).entrySet()) {	   //busqueda de correo en el  hash de compradores			
				if((entry.getValue().getCorreo().equals(correoDado))) {
					correoRegistrado=true;
					break;
				}
			}

			for (Entry<Integer, CuentaUsuario> entry : (InicializacionAplicacion.getBDVendedores()).entrySet()) {     //busqueda de correo en el  hash de vendedores	
				if((entry.getValue().getCorreo().equals(correoDado))) {
					correoRegistrado=true;
					break;
				}

			}

			for (Entry<Integer, Administrador> entry : (InicializacionAplicacion.getBDAdministradores()).entrySet()) {	    //busqueda de correo en el  hash de admin		
				if((entry.getValue().getCorreo().equals(correoDado))) {
					correoRegistrado=true;
					break;
				}

			}
			if(correoRegistrado == false) {      //en caso de que no se encuentre el correo registrado en ninguna tabla
				InicializacionAplicacion.usuarioActivo = new Comprador(nombreDado, correoDado, contrasenaDada, cedulaDada);
				InicializacionAplicacion.getBDCompradores().put(InicializacionAplicacion.usuarioActivo.getId(), (Comprador) InicializacionAplicacion.usuarioActivo);
				InicializacionAplicacion.usuarioActivo.setOpcionesDeMenuPredeterminadas();
				return "Registro exitoso";
			}else {
				return"El correo ya se encuentra registrado";
			}
		}
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
//					System.out.println("Contraseña incorrecta. \n1.Volver a intentar\n2.Cancelar");
//					//intentar = Byte.parseByte(br.readLine());	CORREGIR BUFFERED READER
//					if (intentar == 1) {
//						System.out.println("Ingrese la contraseña: ");
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