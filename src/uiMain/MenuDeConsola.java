package uiMain;

import java.util.*;
import gestorAplicación.*;
import gestorAplicación.Usuarios.Administrador;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Cuenta;
import gestorAplicación.Usuarios.Vendedor;
import gestorAplicación.Usuarios.Visitante;
import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Materiales.CarritoDeCompras;
import gestorAplicación.Materiales.Producto;
import gestorAplicación.Materiales.Reseña;

public class MenuDeConsola {

	ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();// lista de metodos para el admin
	ArrayList<OpcionDeMenu> activo = new ArrayList<OpcionDeMenu>();
	Cuenta usuario = new Visitante();
	public static boolean SalirApp = false;
	public static Scanner e = new Scanner(System.in);
	public static int compradores = 0;
	public static int vendedores = 0;
	public static int administradores = 0;
	activo.add(new salir());

	public void LanzarMenu() { // default del invitado
		/*
		 * for(byte i=0;i<opciones.size();i++){ System.out.println(opciones.get(i)
		 * +"  "+i); } //System.out.println(salir)?
		 */
		// activo.add(registrar.ejecutar());

		System.out.println("Ingrese la opción");
		int recibido = MenuDeConsola.e.nextInt();
		OpcionDeMenu op = opciones.get(recibido);
		op.ejecutar();
	}

}

abstract class OpcionDeMenu extends MenuDeConsola {
	abstract public void ejecutar();

	abstract public String toString();
}

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
			//se busca de manera magica en la base de datos a ver si el correo ya no está
			//preguntar con que clave está meiendo eso en las hash
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

class iniciarSesion extends OpcionDeMenu { // opcion 1

	@Override
	public void ejecutar() {
		System.out.println("Diga su tipo de cuenta: \n1.Comprador\n2.Vendedor");
		Short t = e.nextShort();
		System.out.println("Correo: ");
		String c = e.next();
		System.out.println("Contraseña: ");
		String p = e.next();
		if (t == 1) {
			boolean x = false;
			Integer key;
			if (x == true) {
				(InicializacionAplicacion.getBDCompradores()).forEach((k,v)-> {
					if((v.getCorreo().equals(c))) {
						x=true;
						key = k;
					}
				});
				if(!(InicializacionAplicacion.getBDCompradores()).get(key).getPassword().equals(p)) {
					int intentar = 1;					
					while (intentar!=0)				    
					System.out.println("La contraseña no coincide");
					System.out.println("Para cancelar ingrese 0 para reintentar ingrese 1: ");
					intentar = e.nextInt();	
					p = e.next();
					if ((InicializacionAplicacion.getBDCompradores()).get(key).getPassword().equals(p)) {
						usuario = (InicializacionAplicacion.getBDCompradores()).get(key);
						break;
					}
				}
				else {
					usuario = (InicializacionAplicacion.getBDCompradores()).get(key);
				}
			} else {
				System.out.println("El correo no se encuentra registrado ");
			}
		}else if (t==2) {
			boolean xx=false;
			Integer kkey;
			(InicializacionAplicacion.getBDVendedores()).forEach((k,v)-> {
				if((v.getCorreo().equals(c))) {
					xx=true;
					kkey = k;
				}
			});
			if(!(InicializacionAplicacion.getBDVendedores()).get(kkey).getPassword().equals(p)) {
				int intentar = 1;					
				while (intentar!=0)				    
				System.out.println("La contraseña no coincide");
				System.out.println("Para cancelar ingrese 0 para reintentar ingrese 1: ");
				intentar = e.nextInt();	
				p = e.next();
				if ((InicializacionAplicacion.getBDVendedores()).get(kkey).getPassword().equals(p)) {
					usuario = (InicializacionAplicacion.getBDVendedores()).get(kkey);
					break;
				}
			}
			else {
				usuario = (InicializacionAplicacion.getBDVendedores()).get(kkey);
			}

		} else {
			System.out.println("El correo no se encuentra registrado ");
		}

	}

	public String toString() { // cosa inutil

		return "Iniciar Sesión";
	}

}

class buscarProducto extends OpcionDeMenu { // opcion 2
	Producto prod;

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el código del producto: ");
		int codigo = e.nextInt();
		//prod = Comprador.buscar(codigo); // aiuda juanfer
		System.out.println("Nombre: " + prod.getNombreProducto() + "Código: " + prod.getCodigoProducto());

	}

	public String toString() {
		return "Buscar Producto";
	}

}

//de aqui para abajo falta que definan los metodos en las clases de vendendor o comprador.
class buscarCategoria extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() {
		System.out.println("Ingrese la categoria:");
		String cat = e.next();
		Deque<Producto> categoria;
		//categoria = Comprador.buscar(cat);// la misma vaina de arriba

	}

	@Override
	public String toString() {
		return "Buscar Categoria";
	}

}

class agregarACarrito extends OpcionDeMenu { // opcion 4

	@Override
	public void ejecutar() {
		for (int i = 0; i < Vendedor.catalogo.size(); i++) {

		}
		System.out.println("Ingrese el código del producto a agregar");

	}

	@Override
	public String toString() {
		return "Agregar a Carrito";
	}

}

class borrarHistorial extends OpcionDeMenu { // opcion 5

	@Override
	public void ejecutar() {
		//usuario.Comprador.borrarHistorial();

	}

	@Override
	public String toString() {
		return "Borrar Historial";
	}

}

class mostrarHistorial extends OpcionDeMenu { // opcion 6

	@Override
	public void ejecutar() {
	}

	@Override
	public String toString() {
		return "Mostrar historial";
	}

}

class comprarProductos extends OpcionDeMenu { // opcion 7

	@Override
	public void ejecutar() {
		//usuario.CarritoDeCompras.comprarProductos();

	}

	@Override
	public String toString() {
		return "Comprar productos en el carrito";
	}

}

class vaciarCarrito extends OpcionDeMenu { // opcion 8

	@Override
	public void ejecutar() {
		//usuario.CarritoDeCompras.vaciarCarrito();
	}

	@Override
	public String toString() {
		return "Vaciar carrito";
	}
}

class quitarProducto extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() {
		System.out.println("Ingresa el código del producto: ");
		int cod = e.nextInt();
		//usuario.CarritoDeCompras.quitarProducto(cod);
	}
	@Override
	public String toString() {
		return "Quitar Producto del carrito";
	}
}
class agregarReseña extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() {
		//mostrar el catalogo y numerar las posiciones(empezar en 1)
		System.out.println("Ingrese numero del producto en el catálogo ");
		int codigo = e.nextInt();
		Producto p = Vendedor.catalogo.get(codigo-1);
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = MenuDeConsola.e.nextInt();
		System.out.println("Ingrese comentario: ");
		String comentario = MenuDeConsola.e.next();
		Reseña rese = new Reseña(comentario, estrellas);
		p.añadirReseña(rese);
	}
	@Override
	public String toString() {
		return "Agregar reseña ";
	}
}
class subirProducto extends OpcionDeMenu { // opcion 11

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el nombre del producto");
		String nombre = e.next();
		System.out.println("Ingrese la cantidad ");
		int cant = e.nextInt();
		System.out.println("Ingrese el precio ");
		double precio = e.nextDouble();
		//hay que esperar a que sara y juan manuel resuelvan las categorias

	}

	@Override
	public String toString() {
		return "Subir producto";
	}

}
class eliminarOpcion extends OpcionDeMenu { // opci gestorAplicación.Usuarios.Vendedoron 12
	@Override
	public void ejecutar() {
		for (int i = 0; i < opciones.size(); i++) {
			System.out.println(opciones.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int Aeliminar = e.nextInt();
		activo.remove(Aeliminar);
	}

	@Override
	public String toString() {
		return "Eliminar opción";
	}

}
class agregarOpcion extends OpcionDeMenu { // opcion 13

	@Override
	public void ejecutar() {
		for (int i = 0; i < opciones.size(); i++) {
			System.out.println(opciones.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int agregar = e.nextInt();
		activo.add(opciones.get(agregar));

	}
	@Override
	public String toString() {
		return "Agregar opción";
	}

}

class cuentas extends OpcionDeMenu { // opcion 15

	@Override
	public void ejecutar() {
		//int a = Administrador.getNumeroCuentas();
		//System.out.println("Numero de cuentas: "+a);

	}

	@Override
	public String toString() {
		return "Numero de cuentas ";
	}

}

class eliminarProducto extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el código del producto a eliminar ");
		int cod = e.nextInt();

	}

	@Override
	public String toString() {
		return "Eliminar producto";
	}

}

class salir extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		//full juan fernando 
	}

	@Override
	public String toString() {
		return "Salir";
	}

}
