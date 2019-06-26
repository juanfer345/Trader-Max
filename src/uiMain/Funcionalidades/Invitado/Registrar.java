package uiMain.Funcionalidades.Invitado;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class Registrar extends OpcionDeMenu { // opcion 0
	boolean x = false;
	Integer key;
	public void ejecutar() throws IOException{
		System.out.println("Tipo de cuenta: \n1.Vendedor\n2.Comprador");
		short t = Short.parseShort(MenuDeConsola.br.readLine().trim());
		System.out.println("Nombre: ");
		String n = MenuDeConsola.br.readLine().trim();
		System.out.println("Correo: ");
		String c = MenuDeConsola.br.readLine().trim();
		System.out.println("Cedula: ");
		int cc = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		System.out.println("Contraseña: ");
		String p = MenuDeConsola.br.readLine().trim();

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
				(InicializacionAplicacion.getBDVendedores()).put(2, (Vendedor) InicializacionAplicacion.usuarioActivo);
//				MenuDeConsola.opcionesActivas.clear();
//				MenuDeConsola.opcionesActivas.add(new SubirProducto());
//				MenuDeConsola.opcionesActivas.add(new EliminarProductoCatalogo());
//				MenuDeConsola.opcionesActivas.add(new Salir());
			}else {
				System.out.println("El correo ya se encuentra registrado");
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
//				InicializacionAplicacion.usuarioActivo = new Comprador(n, c, p, cc);
//				InicializacionAplicacion.getBDCompradores().put(4, (Comprador) MenuDeConsola.usuarioActivo);
//				MenuDeConsola.opcionesActivas.clear();
//				MenuDeConsola.opcionesActivas.add(new BuscarProducto());
//				MenuDeConsola.opcionesActivas.add(new MostrarPorCategoria());
//				MenuDeConsola.opcionesActivas.add(new AgregarACarrito());
//				MenuDeConsola.opcionesActivas.add(new BorrarHistorial());
//				MenuDeConsola.opcionesActivas.add(new MostrarHistorial());
//				MenuDeConsola.opcionesActivas.add(new ComprarProducto());
//				MenuDeConsola.opcionesActivas.add(new VaciarCarrito());
//				MenuDeConsola.opcionesActivas.add(new QuitarProductoCarrito());
//				MenuDeConsola.opcionesActivas.add(new AgregarResena());
//				MenuDeConsola.opcionesActivas.add(new Salir());
			}else {
				System.out.println("El correo ya se encuentra registrado");
			}
		}

	}

	public String toString() {
		return "Registrar";
	}
}
