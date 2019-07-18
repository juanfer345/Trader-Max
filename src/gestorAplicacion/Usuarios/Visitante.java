package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.MenuConsola.BuscarProducto;
import uiMain.MenuConsola.MostrarCatalogo;
import uiMain.MenuConsola.MostrarPorCategoria;
import uiMain.MenuConsola.Salir;
import uiMain.MenuConsola.Visitante.IniciarSesion;
import uiMain.MenuConsola.Visitante.Registrar;

public class Visitante extends Cuenta {
	
	public Visitante() { }
	
	public ArrayList <OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {
				   new IniciarSesion(), new Registrar(), new BuscarProducto(), 
				   new MostrarCatalogo(), new MostrarPorCategoria(), new Salir()}));
	}
	
	public HashMap <Integer,Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
	//Método para registrar usuarios
	public String registrarse(byte tipoDeCuenta, String nombreDado, String correoIngresado, int cedulaIngresada, String contrasenaIngresada) {
		
		Cuenta usuarioActivo = null;
		HashMap <Integer, ? extends Cuenta> baseDeDatos = null;
		boolean correoRegistrado = false;

		switch (tipoDeCuenta) {
		case 1:
			//Caso A: Registro de un usuario comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			//Caso B: Registro de un usuario vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			//Caso C: Registro de un usuario Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}
		
		//Busqueda de correo en la base de datos seleccionada
		correoRegistrado = busquedaCorreo(baseDeDatos, correoIngresado);
		
		if (!correoRegistrado) {
			//Caso A: El correo no se encuentra repetido
			
			switch (tipoDeCuenta) {
				case 1:
					//Caso A: Registro de un usuario comprador
					usuarioActivo = new Comprador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.getBDCompradores().put(usuarioActivo.getId(), (Comprador) usuarioActivo);
					break;
				case 2:
					//Caso B: Registro de un usuario vendedor
					usuarioActivo = new Vendedor(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.getBDVendedores().put(usuarioActivo.getId(), (Vendedor) usuarioActivo);
					break;
				case 3:
					//Caso C: Registro de un usuario Administrador
					usuarioActivo = new Administrador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.getBDAdministradores().put(usuarioActivo.getId(), (Administrador) usuarioActivo);
					break;
			}
			InicializacionAplicacion.setUsuarioActivo(usuarioActivo);
    		OpcionDeMenu.controlError = true;
			return "Registro exitoso, bienvenido a TRADER-MAX " + usuarioActivo.getNombre() + ".\n";
		}
		else {
			//Caso B: El correo se encuentra repetido
			return "El correo ya se encuentra registrado.\n";
		}
	}
	
	//Método para buscar correo en las bases de datos de las cuentas, para ahorrar espácio en el método registrarse
	private static boolean busquedaCorreo(HashMap <Integer, ? extends Cuenta> HM, String correoIngresado) {
		
		for (Map.Entry <Integer, ? extends Cuenta> entry : HM.entrySet()) {
			if((entry.getValue().getCorreo().equals(correoIngresado))) {
				return true;
			}
		}
		return false;
	}
	
	//Método para iniciar sesión
	public String iniciarSesion(byte tipoDeCuenta, String correoIngresado, String contrasenaIngresada) {
		
		HashMap <Integer, ? extends Cuenta> baseDeDatos = null;
		int idcorreoRegistrado;
		
		switch (tipoDeCuenta) {
			case 1:
				//Caso A: Registro de un usuario vendedor
				baseDeDatos = InicializacionAplicacion.getBDCompradores();
				break;
			case 2:
				//Caso B: Registro de un usuario Comprador
				baseDeDatos = InicializacionAplicacion.getBDVendedores();
				break;
			case 3:
				//Caso C: Registro de un usuario Administrador
				baseDeDatos = InicializacionAplicacion.getBDAdministradores();
				break;
		}
		
		//Busqueda de correo en la base de datos seleccionada
		idcorreoRegistrado = idCorreo(baseDeDatos, correoIngresado);
		
		if (idcorreoRegistrado != -1) {
			//Caso A: Se ha encontrado el correo
			if (baseDeDatos.get(idcorreoRegistrado).getPassword().equals(contrasenaIngresada)) {

				InicializacionAplicacion.setUsuarioActivo(baseDeDatos.get(idcorreoRegistrado));
	    		OpcionDeMenu.controlError = true;
				return "Sesión iniciada correctamente, bienvenido a TRADER-MAX " + InicializacionAplicacion.usuarioActivo.getNombre() + ".\n";
			}
			else {
				return "Contraseña incorrecta.\n";
			}
		}
		else {
			//Caso B: No se ha encontrado el correo
			return "El correo no se encuentra registrado, por favor intentelo de nuevo.\n";
		}
	}
	
	//Método para buscar correo en las bases de datos de las cuentas, para ahorrar espácio en el método iniciar sesión
	private static int idCorreo(HashMap <Integer, ? extends Cuenta> HM, String correoIngresado) {
		
		for (Map.Entry <Integer, ? extends Cuenta> entry : HM.entrySet()) {
			if((entry.getValue().getCorreo().equals(correoIngresado))) {
				return entry.getKey();
			}
		}
		return -1;
	}
}