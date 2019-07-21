/* 
   Clase ControlErrorDatosUsuario (abstracta, hereda de OpcionDeMenu)
   
   Propósito:
   Opción de menú del usuario, controla errores que pueden surgir 
   en los datos de un Usuario
   
   Estructuras de datos relevantes:
 */

package uiMain.MenuConsola.Visitante;

import java.io.IOException;

import uiMain.OpcionDeMenu;

abstract class ControlErrorDatosUsuario extends OpcionDeMenu {

	@Override
	public abstract void ejecutar() throws IOException;

	@Override
	public abstract String toString();

	// Contro de tipo de cuenta del Usuario
	byte controlTipoDeCuenta() throws IOException {
		
		/*
		   Propósito: Se encarga de controlar el tipo de cuenta, 
		              al cual se quiere registrar o iniciar el Usuario
		 */

		//Atributos
		byte tipoDeCuenta;

		// Guardado de mensaje
		sb.append("\nPor favor elija su tipo de usuario:\n");
		sb.append("1: Comprador.\n");
		sb.append("2: Vendedor.\n");
		sb.append("3: Administrador.\n");
		sb.append("=> ");

		while (true) {
			// Impresión de mensaje y recepción de datos
			System.out.print(sb);
			tipoDeCuenta = esByte(br.readLine().trim());

			// Control de error
			if (tipoDeCuenta != 0) {
				if (tipoDeCuenta >= 1 && tipoDeCuenta <= 3) {
					return tipoDeCuenta;
				} else {
					System.out.println("Por favor ingrese un número entero en el rango [1,3].");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			} else {
				controlError = true;
				return -1;
			}
		}
	}

	// Control del nombre de Usuario
	String controlNombre() throws IOException {
		
		/*
		   Propósito: Se encarga de controlar el nombre que haya ingresado el usuario
		 */

		// Atributos
		String nombreIngresado;
		byte comprobacion;

		while (true) {
			// Impresión de mensaje y recepción de datos
			System.out.print("Nombre: ");
			nombreIngresado = br.readLine().trim();
			comprobacion = esByte(nombreIngresado);

			// Control de error
			if (comprobacion != 0) {
				if (comprobacion == -1) {
					return nombreIngresado;
				} else {
					System.out.println("\nSe está ingresando un número en lugar de un nombre.");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			} else {
				controlError = true;
				return "";
			}
		}
	}

	// Control de correo del Usuario
	String controlCorreo() throws IOException {
		
		/*
		   Propósito: Se encarga de controlar que el correo ingresado por el Usuario
		              sea válido
		 */

		// Atributos
		String[] correoDividido;
		String correoIngresado;
		byte comprobacion;
		boolean ingresoCorrecto = false;

		while (true) {
			// Impresión de mensaje y recepción de datos
			System.out.print("Correo: ");
			correoIngresado = br.readLine().trim();
			comprobacion = esByte(correoIngresado);

			// Condicional de cancelación
			if (comprobacion != 0) {
				// Condicional de que se ha ingresado una cadena
				if (comprobacion == -1) {
					// Condicional de que el correo contiene una @ y un .
					if (correoIngresado.contains("@") && correoIngresado.contains(".")) {
						correoDividido = correoIngresado.split("@");
						// Condicional de que se tiene algo antes del @
						if (correoDividido.length > 1) {
							correoDividido = correoDividido[1].split("\\.");
							// Condicional de que hay algo antes y despues del .
							if (correoDividido.length > 1) {
								ingresoCorrecto = true;
							}
						}
					}

					// Resultado según ingreso
					if (ingresoCorrecto) {
						return correoIngresado;
					} else {
						System.out.println("Ingresar un correo válido de la forma: 'ejemplo@dirección.com'.");
					}
				} else {
					System.out.println("\nSe está ingresando un número en lugar de un correo.");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			} else {
				controlError = true;
				return "";
			}
		}
	}

	// Control de cedúla del Usuario
	int controlCedula() throws IOException {
		
		/*
		   Propósito: Se encarga de controlar que el número de cedúla ingresada
		              por el Usuario sea válida
		 */

		// Atributos
		Integer cedulaIngresada;

		while (true) {
			// Impresión de mensaje y recepción de datos
			System.out.print("Cedula: ");
			cedulaIngresada = esInt(br.readLine().trim());

			// Control de error
			if (cedulaIngresada != 0) {
				if (cedulaIngresada != -1) {
					return cedulaIngresada;
				} else {
					System.out.println("Por favor ingrese una cédula válida.");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			} else {
				controlError = true;
				return -1;
			}
		}
	}

	// Control de contraseña del Usuario
	boolean controlContrasena(String contrasenaIngresada) throws IOException {
		
		/*
		   Propósito: Se encarga de controlar que la contraseña ingresada por el Usuario
		              sea válida
		 */

		// Atributos
		String contrasenaComprobada;
		byte comprobacion;

		while (true) {
			// Impresión de mensaje y recepción de datos
			System.out.print("Confirmar contraseña: ");
			contrasenaComprobada = br.readLine().trim();
			comprobacion = esByte(contrasenaComprobada);

			// Control de error
			if (comprobacion != 0) {
				if (contrasenaComprobada.equals(contrasenaIngresada)) {
					return true;
				} else {
					System.out.println("\nLas contraseñas no coinciden.");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			} else {
				return false;
			}
		}
	}
}