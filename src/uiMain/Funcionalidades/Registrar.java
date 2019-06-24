package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class Registrar extends OpcionDeMenu { // opcion 0
	boolean x= false;
	Integer key;
	public void ejecutar() throws IOException{
		System.out.println("Tipo de cuenta: \n1.Vendedor\n2.Comprador");
		short t = scn.nextShort();
		System.out.println("Nombre: ");
		String n = br.readLine();
		System.out.println("Correo: ");
		String c = scn.next();
		System.out.println("Cedula: ");
		String cc = scn.next();
		System.out.println("Contraseña: ");
		String p = scn.next();

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
			usuario = new Vendedor(n, c, p, cc);
			(InicializacionAplicacion.getBDVendedores()).put(vendedores, (Vendedor) usuario);
			activo.clear();
			activo.add(new SubirProducto());
			activo.add(new EliminarProductoCatalogo());
			activo.add(new Salir());
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
			if(x==false) {
			usuario = new Comprador(n, c, p, cc);
			InicializacionAplicacion.getBDCompradores().put(compradores, (Comprador) usuario);
			activo.clear();
			activo.add(new BuscarProducto());
			activo.add(new BuscarCategoria());
			activo.add(new AgregarACarrito());
			activo.add(new BorrarHistorial());
			activo.add(new MostrarHistorial());
			activo.add(new ComprarProductos());
			activo.add(new VaciarCarrito());
			activo.add(new QuitarProductoCarrito());
			activo.add(new AgregarReseña());
			activo.add(new Salir());
			}else {
				System.out.println("El correo ya se encuentra registrado");
			}
		}

	}

	public String toString() {
		return "Registrar";
	}
}
