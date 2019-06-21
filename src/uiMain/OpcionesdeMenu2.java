package uiMain;
import java.util.*;
import gestorAplicación.Usuarios.*;
import gestorAplicación.Materiales.*;
//car:variable de tipo carritoDeCompras para hacer sus metodos

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
