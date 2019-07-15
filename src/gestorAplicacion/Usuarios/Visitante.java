package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import uiMain.OpcionDeMenu;
import uiMain.Funcionalidades.BuscarProducto;
import uiMain.Funcionalidades.MostrarCatalogo;
import uiMain.Funcionalidades.MostrarPorCategoria;
import uiMain.Funcionalidades.Salir;
import uiMain.Funcionalidades.Visitante.IniciarSesion;
import uiMain.Funcionalidades.Visitante.Registrar;

public class Visitante extends Cuenta {

	public Visitante() {
		super();
		this.totalDeOpcionesDefault = 5;
		setOpcionesDeMenuPredeterminadas();
	}
	
	public void setOpcionesDeMenuPredeterminadas() {
		Cuenta.menu.setOpcionesActivas(new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new IniciarSesion(), new Registrar(), 
										  new BuscarProducto(), new MostrarPorCategoria(), new MostrarCatalogo(), new Salir()})));
	}
	
	public ArrayList <OpcionDeMenu> getOpcionesDeMenuPredeterminadas() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {new IniciarSesion(), new Registrar(), 
				  new BuscarProducto(), new MostrarPorCategoria(), new MostrarCatalogo(), new Salir()}));
	}
	
	public ArrayList <OpcionDeMenu> getOpcionesDeMenu() {
		return menu.getOpcionesActivas();
	}
	
	public HashMap <Integer,Producto> verProductos() {
		return Vendedor.catalogo;
	}
	
	//Método para registrar usuarios
	public String Registrarse(byte tipoDeCuenta, String nombreDado, String correoIngresado, int cedulaIngresada, String contrasenaIngresada) {
		
		HashMap <Integer, ? extends Cuenta> baseDeDatos = null;
		boolean correoRegistrado = false;

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
		correoRegistrado = busquedaCorreo(baseDeDatos, correoIngresado);
		
		if (!correoRegistrado) {
			//Caso A: El correo no se encuentra repetido
			
			switch (tipoDeCuenta) {
				case 1:
					//Caso A: Registro de un usuario vendedor
					InicializacionAplicacion.usuarioActivo = new Comprador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.getBDCompradores().put(InicializacionAplicacion.usuarioActivo.getId(), (Comprador) InicializacionAplicacion.usuarioActivo);
					break;
				case 2:
					//Caso B: Registro de un usuario Comprador
					InicializacionAplicacion.usuarioActivo = new Vendedor(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.getBDVendedores().put(InicializacionAplicacion.usuarioActivo.getId(), (Vendedor) InicializacionAplicacion.usuarioActivo);
					break;
				case 3:
					//Caso C: Registro de un usuario Administrador
					InicializacionAplicacion.usuarioActivo = new Administrador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.getBDAdministradores().put(InicializacionAplicacion.usuarioActivo.getId(), (Administrador) InicializacionAplicacion.usuarioActivo);
					break;
			}
    		OpcionDeMenu.controlError = true;
			return "Registro exitoso, bienvenido a TRADER-MAX " + InicializacionAplicacion.usuarioActivo.getNombre() + ".\n";
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
				
				InicializacionAplicacion.usuarioActivo = baseDeDatos.get(idcorreoRegistrado);
	    		OpcionDeMenu.controlError = true;
				return "Sesión iniciada correctamente, bienvenido a TRADER-MAX " + InicializacionAplicacion.usuarioActivo.getNombre() + ".\n";
			}
			else {
				return "Contraseña incorrecta.\n";
			}
		}
		else {
			//Caso B: No se ha encontrado el correo
			return "El correo no se encuentra registrado.\n";
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