package uiMain;
import java.util.*;
import gestorAplicación.*;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.Cuenta;
import gestorAplicación.Usuarios.Vendedor;
import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Materiales.Producto;

public class MenuDeConsola {

	ArrayList <OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();
	public static boolean SalirApp = false;
	public static Scanner e = new Scanner(System.in);
	public static long compradores = 0; //para generar las claves para meterlos en la tabla hash
	public static long vendedores =0;// si tienen una mejor idea de como hacer eso, porfa me dicen
	public static long administradores =0; // no lo hice con el de el id por que despues es un enredo 
											//para buscar en esas tablas
	
	
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
		System.out.println("Contraseña: ");
		String p = e.next();

		if(t==1) {
			Cuenta ven = new Vendedor(n,c,p,cc);
			//InicializaccionAplicacion.BDVendedores.put(vendedores,ven);
			
		}else {
			Cuenta comp = new Comprador(n,c,p,cc);
			//gestorAplicacón.InicializaccionAplicacion.BDCompradores.put(compradores,comp);
		}
		//de aca ya se mete en la base de datos...
	}
	public String toString() {
		return null;
	}
}

class iniciarSesion extends OpcionDeMenu { // opcion 1

	@Override
	public void ejecutar(){
		System.out.println("Diga su tipo de cuenta: \n1.Comprador\n2.Vendedor");
		Short t = e.nextShort();
		System.out.println("Correo: ");
		String c = e.next();
		System.out.println("Contraseña: ");
		String p = e.next();
		if (t==1) {
			boolean x;
			 //busqueda en la tabla... lo hago una vez sepa como acceder a ellas
			if(x==true) {
				//se comprueba que la contraseña concuerde
			}else {
				System.out.println("El correo no se encuentra registrado ");
			}
		}
		
	}

	public String toString() { //cosa inutil

		return null;
	}

}

class buscarProducto extends OpcionDeMenu { // opcion 2

	@Override
	public void ejecutar() {
		System.out.println("Ingrese el código del producto: ");
		int codigo = e.nextInt();
		Producto p = Comprador.buscarProducto(codigo); //se tiene que arreglar el metodo en comprador...
		

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
