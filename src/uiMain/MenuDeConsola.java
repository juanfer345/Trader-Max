package uiMain;

import gestorAplicaci�n.Materiales.Producto;
import gestorAplicaci�n.Usuarios.Comprador;
import gestorAplicaci�n.Usuarios.Cuenta;
import gestorAplicaci�n.Usuarios.Vendedor;


public class MenuDeConsola {

	ArrayList <OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();
	public static boolean SalirApp = false;
	public static Scanner e = new Scanner(System.in);
}

abstract class OpcionDeMenu extends MenuDeConsola {
	abstract public void ejecutar();
	abstract public String toString();
}

class registrar extends OpcionDeMenu { // opcion 0

	@Override
	public void ejecutar() {
		System.out.println("Tipo de cuenta: \n1.Vendedor\n2.Comprador");
		short t = e.nextShort();
		System.out.println("Nombre: ");
		String n = e.next();
		System.out.println("Correo: ");
		String c = e.next();
		System.out.println("Cedula :");
		String cc = e.next();
		System.out.println("Contrase�a: ");
		String p = e.next();

		if(t==1) {
			Cuenta ven = new Vendedor(n,c,p,cc);
		}else {
			Cuenta comp = new Comprador(n,c,p,cc);
		}
		//de aca ya se mete en la base de datos...
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}

class iniciarSesion extends OpcionDeMenu { // opcion 1

	@Override
	public void ejecutar() {
		System.out.println("Correo: ");
		String c = e.next();
		System.out.println("Contrase�a: ");
		String p = e.next();
		//despues se ve lo de las tablas de la base de datos
	}

	public String toString() {

		return null;
	}

}

class buscarProducto extends OpcionDeMenu { // opcion 2

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el c�digo del producto: ");
		int codigo = e.nextInt();
		//Producto p = Comprador.buscarProducto(codigo);

	}
	public String toString() {
		//se pone segun el producto y aja
		return null;
	}

}
//de aqui para abajo falta que definan los metodos en las clases de vendendor o comprador.
class buscarCategoria extends OpcionDeMenu { // opcion 3

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}

class agregarACarrito extends OpcionDeMenu { // opcion 4

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}

class borrarHistorial extends OpcionDeMenu { // opcion 5

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}

class mostrarHistorial extends OpcionDeMenu { // opcion 6

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}

class comprarProductos extends OpcionDeMenu { // opcion 7

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
