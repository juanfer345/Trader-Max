package uiMain;

import java.util.ArrayList;

public class MenuDeConsola {
	
	ArrayList <OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();
	public static boolean SalirApp = false;
}

abstract class OpcionDeMenu {
	abstract public void ejecutar();

	abstract public String toString();

}

class registrar extends OpcionDeMenu { // opcion 0

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

class iniciarSesion extends OpcionDeMenu { // opcion 1

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

class buscarProducto extends OpcionDeMenu { // opcion 2

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
