package uiMain;

import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Vendedor;

class registrar extends OpcionDeMenu { // opcion 0
	boolean x= false;
	Integer key;
	public void ejecutar() {
		System.out.println("Tipo de cuenta: \n1.Vendedor\n2.Comprador");
		short t = e.nextShort();
		System.out.println("Nombre: ");
		String n = e.next();
		System.out.println("Correo: ");
		String c = e.next();
		System.out.println("Cedula :");
		String cc = e.next();
		System.out.println("Contraseña: ");
		String p = e.next();

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
			activo.add(new subirProducto());
			activo.add(new eliminarProducto());
			activo.add(new salir());
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
			activo.add(new buscarProducto());
			activo.add(new buscarNombre());
			activo.add(new agregarACarrito());
			activo.add(new borrarHistorial());
			activo.add(new mostrarHistorial());
			activo.add(new comprarProductos());
			activo.add(new vaciarCarrito());
			activo.add(new quitarProducto());
			activo.add(new agregarReseña());
			activo.add(new salir());
			}else {
				System.out.println("El correo ya se encuentra registrado");
			}
		}

	}

	public String toString() {
		return "Registrar";
	}
}
