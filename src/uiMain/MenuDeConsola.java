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

	ArrayList <OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();//lista de metodos para el admin
	ArrayList <OpcionDeMenu> activo = new ArrayList<OpcionDeMenu>();
	Cuenta usuario = new Visitante();
	public static boolean SalirApp = false;
	public static Scanner e = new Scanner(System.in);
	public static int compradores = 0; 
	public static int vendedores =0;
	public static int administradores =0;
											
	
	public void LanzarMenu(){ //default del invitado
		/*for(byte i=0;i<opciones.size();i++){
		System.out.println(opciones.get(i) +"  "+i);
		 }
		//System.out.println(salir)?*/
		//activo.add(registrar.ejecutar());
		
		System.out.println("Ingrese la opción");
		int recibido = MenuDeConsola.e.nextInt();
		OpcionDeMenu op =  opciones.get(recibido);
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

		if(t==1) {
			usuario = new Vendedor(n,c,p,cc);
			(InicializacionAplicacion.getBDVendedores()).put(vendedores,(Vendedor)usuario);
			
		}else {
			usuario = new Comprador(n,c,p,cc);
			InicializacionAplicacion.getBDCompradores().put(compradores,(Comprador)usuario);
		}
		
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
			 //eso del for de juan fernando que dijo que estaba en las bases de datos, 
			//que necesito buscar en la tabla el usuario y aja
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
		Producto p = Comprador.buscar(codigo); //se tiene que arreglar el metodo en comprador...
		

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
class vaciarCarrito extends OpcionDeMenu { // opcion 8

	@Override
	public void ejecutar() {
		CarritoDeCompras car = new CarritoDeCompras();
		 car.vaciarCarrito();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}

class quitarProducto extends OpcionDeMenu { // opcion 9
    
	@Override
	public void ejecutar() {
		System.out.println("Ingresa el codigo del producto");
		int cod = MenuDeConsola.e.nextInt();
		//definir el default en carritodecompras
		CarritoDeCompras car = new CarritoDeCompras();
		car.quitarProducto(cod);
				   
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}

//como poner esta opcion en solo cuando se hable de un producto??

class agregarReseña extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() {
		Producto pro = new Producto();
        System.out.println("Ingrese numero de estrellas: ");
        int estrellas = MenuDeConsola.e.nextInt();
        System.out.println("Ingrese comentario: ");
        String comentario  = MenuDeConsola.e.next();
        Reseña rese = new Reseña(comentario, estrellas);
        pro.añadirReseña(rese);
       
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}

//definir este metodo para vendedor

class subirProducto extends OpcionDeMenu { // opcion 11
     
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
//asegurar de comofunciona la menu de consola
class eliminarOpcion extends OpcionDeMenu { // opci gestorAplicación.Usuarios.Vendedoron 12
	@Override
	public void ejecutar() {
		for (int i = 0;i<opciones.size();i++) {
			System.out.println(opciones.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int Aeliminar = MenuDeConsola.e.nextInt();
		opciones.remove(Aeliminar);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
//como va a conocer el administrador las opcionesDeMenu a agregar *--mal codigo,queda pendiente---*
class agregarOpcion extends OpcionDeMenu { // opcion 13

	@Override
	public void ejecutar() {
		for (int i = 0;i<opciones.size();i++) {
			System.out.println(opciones.get(i));
		}
		System.out.println("Ingrese el indice de la opcion que quiera eliminar: ");
		int Aeliminar = MenuDeConsola.e.nextInt();
		opciones.remove(Aeliminar);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
//administrador borrando cuenta, se puede ingresar el nombre de un objeto y destruirlo?

class eliminarCuenta extends OpcionDeMenu { // opcion 14

	@Override
	public void ejecutar() {
		System.out.println("¿Que cuenta eliminar?: ");
	 String Aborrar = MenuDeConsola.e.next();
	 Cuenta Aborrar = new Cuenta();
	    
	    
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
class SeguimientoDeCuentas extends OpcionDeMenu { // opcion 15

	@Override
	public void ejecutar() {
		Administrador admi = new Administrador();
		Administrador.getNumeroDeCuentas();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
