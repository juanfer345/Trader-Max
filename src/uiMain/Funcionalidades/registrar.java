package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicaci�n.InicializacionAplicacion;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class registrar extends OpcionDeMenu { // opcion 0
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
		System.out.println("Contrase�a: ");
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
			//preguntar con que clave est� metiendo eso en las hash, por ahora se deja ir
			usuario = new Vendedor(n, c, p, cc);
			(InicializacionAplicacion.getBDVendedores()).put(vendedores, (Vendedor) usuario);
			opcionesActivas.clear();
			opcionesActivas.add(new subirProducto());
			opcionesActivas.add(new eliminarProducto());
			opcionesActivas.add(new salir());
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
			opcionesActivas.clear();
			opcionesActivas.add(new buscarProducto());
			opcionesActivas.add(new buscarCategoria());
			opcionesActivas.add(new agregarACarrito());
			opcionesActivas.add(new borrarHistorial());
			opcionesActivas.add(new mostrarHistorial());
			opcionesActivas.add(new comprarProductos());
			opcionesActivas.add(new vaciarCarrito());
			opcionesActivas.add(new quitarProducto());
			opcionesActivas.add(new agregarRese�a());
			opcionesActivas.add(new salir());
			}else {
				System.out.println("El correo ya se encuentra registrado");
			}
		}

	}

	public String toString() {
		return "Registrar";
	}
}
