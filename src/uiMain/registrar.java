package uiMain;

import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Vendedor;

class registrar extends OpcionDeMenu { // opcion 0

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
			boolean x= false;
			final Integer key;
			(InicializacionAplicacion.getBDCompradores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					x=true;
					key = k;
				}
			});
			//preguntar con que clave está meiendo eso en las hash, por ahora se deja ir
			usuario = new Vendedor(n, c, p, cc);
			(InicializacionAplicacion.getBDVendedores()).put(vendedores, (Vendedor) usuario);
			activo.clear();
			activo.add(new subirProducto());
			activo.add(new eliminarProducto());
			activo.add(new salir());
		} else {
			usuario = new Comprador(n, c, p, cc);
			InicializacionAplicacion.getBDCompradores().put(compradores, (Comprador) usuario);
			activo.clear();
			activo.add(new buscarProducto());
			activo.add(new buscarCategoria());
			activo.add(new agregarACarrito());
			activo.add(new borrarHistorial());
			activo.add(new mostrarHistorial());
			activo.add(new comprarProductos());
			activo.add(new vaciarCarrito());
			activo.add(new quitarProducto());
			activo.add(new agregarReseña());
			activo.add(new salir());
		}

	}

	public String toString() {
		return "Registrar";
	}
}
