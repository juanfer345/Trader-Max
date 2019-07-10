package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.BuscarProducto;
import uiMain.Funcionalidades.MostrarPorCategoria;
import uiMain.Funcionalidades.Salir;
import uiMain.Funcionalidades.Invitado.IniciarSesion;
import uiMain.Funcionalidades.Invitado.Registrar;

public class Visitante extends Cuenta {

	public Visitante() {
		super();
		this.totalDeOpcionesDefault = 5;
		setOpcionesDeMenuPredeterminadas();
	}
	
	public void setOpcionesDeMenuPredeterminadas() {
		Cuenta.menu.setOpcionesActivas(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new IniciarSesion(), new Registrar(), 
										  new BuscarProducto(), new MostrarPorCategoria(), new Salir()})));
	}
	
	public ArrayList <OpcionDeMenu> getOpcionesDeMenuPredeterminadas() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new IniciarSesion(), new Registrar(), 
				  new BuscarProducto(), new MostrarPorCategoria(), new Salir()}));
	}
	
	public ArrayList <OpcionDeMenu> getOpcionesDeMenu() {
		return menu.getOpcionesActivas();
	}
	
	public HashMap <Integer,Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
	boolean x = false;//si puede ser estatico?
	public  String Registrarse(short t,String n,String c,int cc,String p) {
		
		if (t == 1) {
			(InicializacionAplicacion.getBDCompradores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					x=true;
				}
			});
			(InicializacionAplicacion.getBDVendedores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					x=true;
				}
			});
			(InicializacionAplicacion.getBDAdministradores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					x=true;
				}
			});
			if (x==false) {
				//preguntar con que clave está metiendo eso en las hash, por ahora se deja ir
				InicializacionAplicacion.usuarioActivo = new Vendedor(n, c, p, cc);
				(InicializacionAplicacion.getBDVendedores()).put(InicializacionAplicacion.usuarioActivo.getId(), (Vendedor) InicializacionAplicacion.usuarioActivo);//porque 2
				InicializacionAplicacion.usuarioActivo.setOpcionesDeMenuPredeterminadas();
				return "Registro exitoso";
			}else {
				return "El correo ya se encuentra registrado";
			}
		} else {

			(InicializacionAplicacion.getBDCompradores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					x=true;
				}
			});
			(InicializacionAplicacion.getBDVendedores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					x=true;
				}
			});
			(InicializacionAplicacion.getBDAdministradores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					x=true;
				}
			});
			if(x == false) {
				InicializacionAplicacion.usuarioActivo = new Comprador(n, c, p, cc);
				InicializacionAplicacion.getBDCompradores().put(InicializacionAplicacion.usuarioActivo.getId(), (Comprador) InicializacionAplicacion.usuarioActivo);//porque 4?
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