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

import control.ControlBuscarProducto;
import control.ControlMostrarCatalogo;
import control.ControlMostrarPorCategoria;
import control.OpcionDeMenu;
import control.Visitante.ControlRegistrar;
import gestorAplicacion.Materiales.Producto;
import uiMain.InicializacionAplicacion;

public class Visitante extends Cuenta {

	public Visitante() { }

	// Crea un nuevo men� por defecto
	public ArrayList <OpcionDeMenu> getMenuPredeterminado() {
		return new ArrayList <OpcionDeMenu> (Arrays.asList(new OpcionDeMenu[] {
				new ControlRegistrar(), new ControlBuscarProducto(), new ControlMostrarCatalogo(), 
				new ControlMostrarPorCategoria()}));
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
		CuentaConBanco usuarioRepetido = null;
		HashMap<Integer, ? extends Cuenta> baseDeDatos = null;
		String mensaje = null;
		int correoRegistrado = 0;

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
		correoRegistrado = idCorreo(baseDeDatos, correoIngresado);

		if (correoRegistrado == -1) {
			// Caso A: El correo no se encuentra repetido

			switch (tipoDeCuenta) {
			case 1:
				// Caso A: Registro de un usuario comprador

				//Condicional para cuentas con el mismo correo
				baseDeDatos = InicializacionAplicacion.getBDVendedores();
				if ((correoRegistrado = idCorreo(baseDeDatos, correoIngresado)) == -1) {

					//Caso A.a: El correo no se encuentra registrado como Vendedor
					usuarioActivo = new Comprador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.setBDCompradores(usuarioActivo.getId(), (Comprador) usuarioActivo);
					InicializacionAplicacion.setUsuarioActivo(usuarioActivo);
					OpcionDeMenu.controlError = true;
					mensaje = "Registro exitoso. Bienvenido a TRADER-MAX " + usuarioActivo.getNombre() + ".";
				}
				else {
					//Caso A.b: El correo se encuentra registrado como Vendedor
					usuarioActivo = new Comprador();
					usuarioActivo.setNombre(nombreDado);
					usuarioActivo.setCorreo(correoIngresado);
					usuarioActivo.setPassword(contrasenaIngresada);
					usuarioActivo.setCedula(cedulaIngresada);

					usuarioRepetido = (Vendedor) baseDeDatos.get(correoRegistrado);

					//Verificaci�n de que ambas cuentas posean los mismos elementos
					if (usuarioRepetido.compareTo(usuarioActivo) == 0) {
						//Las cuentas coinciden
						usuarioActivo = new Comprador(usuarioRepetido.getId(), nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada, usuarioRepetido.getCuentaBancaria().getId());
						InicializacionAplicacion.setBDCompradores(usuarioActivo.getId(), (Comprador) usuarioActivo);
						InicializacionAplicacion.setUsuarioActivo(usuarioActivo);
						OpcionDeMenu.controlError = true;
						mensaje = "Registro exitoso. Bienvenido a TRADER-MAX " + usuarioActivo.getNombre() + ".\n" + "El correo ingresado ya se encuentra registrado como "
								+ "Vendedor, por ello esta nueva cuenta comparte la cuenta bancaria con tu cuenta registrada como Vendedor.\n";
					}
					else {
						mensaje = "Este correo ingresado ya se encuentra registrado ya se encuentra registrado como Vendedor, "
								+ "por ello los atributos de ambas cuentas deben coincidir, por favor intentelo de nuevo.";
					}
				}
				break;
			case 2:
				// Caso B: Registro de un usuario vendedor

				//Condicional para cuentas con el mismo correo
				baseDeDatos = InicializacionAplicacion.getBDCompradores();
				if ((correoRegistrado = idCorreo(baseDeDatos, correoIngresado)) == -1) {

					//Caso A.a: El correo no se encuentra registrado como Comprador
					usuarioActivo = new Vendedor(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
					InicializacionAplicacion.getBDVendedores().put(usuarioActivo.getId(), (Vendedor) usuarioActivo);
					InicializacionAplicacion.setUsuarioActivo(usuarioActivo);
					OpcionDeMenu.controlError = true;
					mensaje = "Registro exitoso. Bienvenido a TRADER-MAX " + usuarioActivo.getNombre() + ".";
				}
				else {
					//Caso A.b: El correo se encuentra registrado como Comprador
					usuarioActivo = new Vendedor();
					usuarioActivo.setNombre(nombreDado);
					usuarioActivo.setCorreo(correoIngresado);
					usuarioActivo.setPassword(contrasenaIngresada);
					usuarioActivo.setCedula(cedulaIngresada);

					usuarioRepetido = (Comprador) baseDeDatos.get(correoRegistrado);

					//Verificaci�n de que ambas cuentas posean los mismos elementos
					if (usuarioRepetido.compareTo(usuarioActivo) == 0) {
						//Las cuentas coinciden
						usuarioActivo = new Vendedor(usuarioRepetido.getId(), nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada, usuarioRepetido.getCuentaBancaria().getId());
						InicializacionAplicacion.getBDVendedores().put(usuarioActivo.getId(), (Vendedor) usuarioActivo);
						InicializacionAplicacion.setUsuarioActivo(usuarioActivo);
						OpcionDeMenu.controlError = true;
						mensaje = "Registro exitoso. Bienvenido a TRADER-MAX " + usuarioActivo.getNombre() + ".\n" + "El correo ingresado ya se encuentra registrado como "
								+ "Comprador, por ello comparte la cuenta bancaria con su cuenta registrada como Comprador.";
					}
					else {
						mensaje = "Este correo ya se encuentra registrado ya se encuentra registrado como Comprador, "
								+ "por ello los atributos de ambas deben coincidir, por favor intentelo de nuevo.";
					}
				}
				break;
			case 3:
				// Caso C: Registro de un usuario Administrador
				usuarioActivo = new Administrador(nombreDado, correoIngresado, contrasenaIngresada, cedulaIngresada);
				InicializacionAplicacion.getBDAdministradores().put(usuarioActivo.getId(), (Administrador) usuarioActivo);
				InicializacionAplicacion.setUsuarioActivo(usuarioActivo);
				OpcionDeMenu.controlError = true;
				mensaje = "Registro exitoso. Bienvenido a TRADER-MAX " + usuarioActivo.getNombre() + ".\n";
				break;
			}
			return mensaje;
		} else {
			// Caso B: El correo se encuentra repetido
			return "Este correo ya se encuentra registrado, por favor ingresa otro correo.";
		}
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

		HashMap<Integer, ? extends CuentaUsuario> baseDeDatos = null;
		int idcorreoRegistrado = -1;

		switch (tipoDeCuenta) {
		case 1:
			// Caso A: Registro de un usuario Comprador
			baseDeDatos = InicializacionAplicacion.getBDCompradores();
			break;

		case 2:
			// Caso B: Registro de un usuario Vendedor
			baseDeDatos = InicializacionAplicacion.getBDVendedores();
			break;

		case 3:
			// Caso C: Registro de un usuario Administrador
			baseDeDatos = InicializacionAplicacion.getBDAdministradores();
			break;
		}

		idcorreoRegistrado = idCorreo(baseDeDatos, correoIngresado);

		// Vericaci�n de que el usuario existe
		if (idcorreoRegistrado != -1) {
			// Caso A: Se ha encontrado el correo
			if (baseDeDatos.get(idcorreoRegistrado).getPassword().equals(contrasenaIngresada)) {

				//Checkeo de usuario no bloqueado
				if (baseDeDatos.get(idcorreoRegistrado).isCuentaActiva()) {

					// Se loguea como el usuario que ingreso
					InicializacionAplicacion.setUsuarioActivo(baseDeDatos.get(idcorreoRegistrado));

					if (baseDeDatos.get(idcorreoRegistrado) instanceof Comprador) {
						((Comprador) baseDeDatos.get(idcorreoRegistrado)).setCarrito();
					}

					OpcionDeMenu.controlError = true;
					return "Sesi�n iniciada correctamente, bienvenido a TRADER-MAX " + 
					InicializacionAplicacion.usuarioActivo.getNombre() + ".\n";
				}
				else {
					return "Su usuario se encuentra bloqueado, no puede iniciar sesi�n.\n";
				}
			} else {
				return "La contrase�a ingresada es incorrecta.\n";
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