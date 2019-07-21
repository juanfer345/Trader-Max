/* 
   Clase Visitante (p�blica, hereda de Cuenta) 
   
   Prop�sito: Tipo de usuario en el programa, el m�s b�sico de todos, 
              solo podr� acceder a alg�nas opciones.
   
 */
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
import uiMain.MenuConsola.MostrarResenas;
import uiMain.MenuConsola.Visitante.IniciarSesion;
import uiMain.MenuConsola.Visitante.Registrar;

public class Visitante extends Cuenta {
	
	public Visitante() { }
	
	// Crea un nuevo men� por defecto
	public ArrayList <OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {
				   new IniciarSesion(), new Registrar(), new BuscarProducto(), new MostrarCatalogo(), 
				   new MostrarPorCategoria(), new MostrarResenas(), new Salir()}));
	}

	// Retorna el cat�logo
	public HashMap<Integer, Producto> verProductos() {
		return Vendedor.catalogo;
	}

	// M�todo para registrar usuarios
	public String registrarse(byte tipoDeCuenta, String nombreDado, String correoIngresado, int cedulaIngresada,
			String contrasenaIngresada) {
		/* 
		   Prop�sito: Para registrarse como un nuevo tipo de usuario
		   
		   Par�metros de entrada:
		   -byte tipoDeCuenta, String nombreDado, String correoIngresado: Datos b�sicos de la cuenta
		   - int cedulaIngresada, String contrasenaIngresada: Datos b�sicos de la cuenta
		   
		   Par�metros de salida:
		   String: Mensaje que indica lo sucedido
		 */

		Cuenta usuarioActivo = null;
		HashMap<Integer, ? extends Cuenta> baseDeDatos = null;
		boolean correoRegistrado = false;

		switch (tipoDeCuenta) {
		case 1:
			// Caso A: Registro de un usuario comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Registro de un usuario vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Registro de un usuario Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		// B�squeda de correo en la base de datos seleccionada
		correoRegistrado = busquedaCorreo(baseDeDatos, correoIngresado);

		if (!correoRegistrado) {
			// Caso A: El correo no se encuentra repetido

			switch (tipoDeCuenta) {
			case 1:
				// Caso A: Registro de un usuario comprador
				usuarioActivo = new Comprador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
				InicializacionAplicacion.getBDCompradores().put(usuarioActivo.getId(), (Comprador) usuarioActivo);
				break;
			case 2:
				// Caso B: Registro de un usuario vendedor
				usuarioActivo = new Vendedor(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
				InicializacionAplicacion.getBDVendedores().put(usuarioActivo.getId(), (Vendedor) usuarioActivo);
				break;
			case 3:
				// Caso C: Registro de un usuario Administrador
				usuarioActivo = new Administrador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
				InicializacionAplicacion.getBDAdministradores().put(usuarioActivo.getId(),
						(Administrador) usuarioActivo);
				break;
			}
			InicializacionAplicacion.setUsuarioActivo(usuarioActivo);
			OpcionDeMenu.controlError = true;
			return "\nRegistro exitoso, bienvenido a TRADER-MAX " + usuarioActivo.getNombre() + ".\n";
		} else {
			// Caso B: El correo se encuentra repetido
			return "Este correo ya se encuentra registrado.\n";
		}
	}


	private static boolean busquedaCorreo(HashMap<Integer, ? extends Cuenta> HM, String correoIngresado) {
		/* 
		   Prop�sito: Para buscar un correo y saber si se encuentra registrado
		              (Ahorra espacio en m�todo registrarse)
		   
		   Par�metros de entrada:
		   -HashMap<Integer, ? extends Cuenta> HM: Tabla donde se encuentran los usuarios ya registrados
		   -String correoIngresado: Correo para analizar
		   
		   Par�metros de salida:
		   boolean: Retorna true en caso de que se encuentre o false en caso contrario
		 */

		for (Map.Entry<Integer, ? extends Cuenta> entry : HM.entrySet()) {
			if ((entry.getValue().getCorreo().equals(correoIngresado))) {
				return true;
			}
		}
		return false;
	}

	public String iniciarSesion(byte tipoDeCuenta, String correoIngresado, String contrasenaIngresada) {
		/* 
		   Prop�sito: Loguearse como un usuario diferente a Invitado 
		   
		   Par�metros de entrada:
		   -byte tipoDeCuenta: Tipo de cuenta a la cual quiere ingresar
		   -String correoIngresado, String contrasenaIngresada: Datos a comparar con los que ya estan registrados
		   
		   Par�metros de salida:
		   String: Mensaje que indica que sucedio con la operaci�n
		 */

		HashMap<Integer, ? extends Cuenta> baseDeDatos = null;
		int idcorreoRegistrado;

		switch (tipoDeCuenta) {
		case 1:
			// Caso A: Registro de un usuario vendedor
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;
		case 2:
			// Caso B: Registro de un usuario Comprador
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;
		case 3:
			// Caso C: Registro de un usuario Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		// Busqueda de correo en la base de datos seleccionada
		idcorreoRegistrado = idCorreo(baseDeDatos, correoIngresado);

		if (idcorreoRegistrado != -1) {
			// Caso A: Se ha encontrado el correo
			if (baseDeDatos.get(idcorreoRegistrado).getPassword().equals(contrasenaIngresada)) {
				// Se loguea como el usuario que ingreso

				InicializacionAplicacion.setUsuarioActivo(baseDeDatos.get(idcorreoRegistrado));
				
				if (baseDeDatos.get(idcorreoRegistrado) instanceof Comprador) {
					((Comprador) baseDeDatos.get(idcorreoRegistrado)).setCarrito();
				}
				
				OpcionDeMenu.controlError = true;
				return "Sesi�n iniciada correctamente, bienvenido a TRADER-MAX "
						+ InicializacionAplicacion.usuarioActivo.getNombre() + ".\n";
			} else {
				return "Contrase�a incorrecta.\n";
			}
		} else {
			// Caso B: No se ha encontrado el correo
			return "El correo no se encuentra registrado, por favor intentelo de nuevo.\n";
		}
	}


	private static int idCorreo(HashMap<Integer, ? extends Cuenta> HM, String correoIngresado) {
		/* 
		   Prop�sito: buscar correo en las bases de datos de las cuentas
		              (ahorra espacio en el m�todo registrar)
		              
		   Par�metros de entrada:
		   -HashMap<Integer, ? extends Cuenta> HM: Tabla donde se encuentran los usuarios ya registrados
		   -String correoIngresado: Correo para analizar
		   
		   Par�metros de salida:
		   int: Retorna el id en caso de encontrarlo, si no, retorna -1
		 */

		for (Map.Entry<Integer, ? extends Cuenta> entry : HM.entrySet()) {
			if ((entry.getValue().getCorreo().equals(correoIngresado))) {
				return entry.getKey();
			}
		}
		return -1;
	}
}