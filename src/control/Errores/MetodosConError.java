package control.Errores;

public class MetodosConError {
	
	//Control de número real
	public static double controlNumero (String entrada, double limInferior, double limSuperior, String nombreCampo, String Error) throws ErrorTipodeDato {

		/*
		   Propósito: Se encarga de controlar el nombreCampo de un número entero (int) que deba ingresar el usuario
		 */

		try {
			double numeroReal = Double.parseDouble(entrada);

			if(numeroReal >= limInferior && numeroReal <= limSuperior) {
				return numeroReal;
			}
			else {
				throw new ErrorTipodeDato("Por favor ingrese un número real en el rango [" + limInferior + "," + limSuperior + "]"
						+ " en el campo " + nombreCampo + ".");
			}
		}
		catch (NumberFormatException e) {
			throw new ErrorTipodeDato(Error);
		}

	}
	
	//Control de número de entero
	public static int controlNumero (String entrada, int limInferior, int limSuperior, String nombreCampo, String Error) throws ErrorTipodeDato {
		
		/*
		   Propósito: Se encarga de controlar el nombreCampo de un número entero (int) que deba ingresar el usuario
		 */

		try {
			int numeroEntero = Integer.parseInt(entrada);

			if(numeroEntero >= limInferior && numeroEntero <= limSuperior) {
				return numeroEntero;
			}
			else {
				throw new ErrorTipodeDato("Por favor ingrese un número entero en el rango [" + limInferior + "," + limSuperior + "]"
						+ " en el campo " + nombreCampo + ".");
			}
		}
		catch (NumberFormatException e) {
			throw new ErrorTipodeDato(Error);
		}
	}
	
	//Control de número entero pequeño
	public static byte controlNumero (String entrada, byte limInferior, byte limSuperior, String nombreCampo, String Error) throws ErrorTipodeDato {
		
		/*
		   Propósito: Se encarga de controlar el nombreCampo de un número entero (byte) que deba ingresar el usuario
		 */

		try {
			byte numeroByte = Byte.parseByte(entrada);
			
			if(numeroByte >= limInferior && numeroByte <= limSuperior) {
				return numeroByte;
			}
			else {
				throw new ErrorTipodeDato("Por favor ingrese un número entero en el rango [" + limInferior + "," + limSuperior + "]"
						+ " en el campo " + nombreCampo + ".");
			}
		}
		catch (NumberFormatException e) {
			throw new ErrorTipodeDato(Error);
		}
	}
	
	// Control de cadenas de texto
	public static String controlString (String entrada, String nombreCampo, String error) throws ErrorTipodeDato {
		
		/*
		   Propósito: Se encarga de controlar una cadena de texto que haya ingresado el usuario
		 */

		try {
			Long.parseLong(entrada); Double.parseDouble(entrada);
			throw new ErrorTipodeDato(error);
		}
		catch (NumberFormatException e) {

			// Control de error
			if (!entrada.isEmpty()) {
				return entrada;
			}
			else {
				throw new ErrorTipodeDato("Ha ingresado una cadena vacía en el campo " + nombreCampo);
			}
		}
	}
	
	// Control de correo del Usuario
	public static String controlCorreo (String entrada) throws ErrorGenerico {

		/*
		   Propósito: Se encarga de controlar que el correo ingresado por el Usuario
		              sea válido
		 */

		// Atributos
		String[] correoDividido;
		boolean nombreCampoCorrecto = false;

		try {
			Long.parseLong(entrada);

			// Condicional de que el correo contiene una @ y un .
			if (entrada.contains("@") && entrada.contains(".")) {
				correoDividido = entrada.split("@");
				// Condicional de que se tiene algo antes del @
				if (correoDividido.length > 1) {
					correoDividido = correoDividido[1].split("\\.");
					// Condicional de que hay algo antes y despues del .
					if (correoDividido.length > 1) {
						nombreCampoCorrecto = true;
					}
				}
			}
		}
		catch (NumberFormatException e) {
			throw new ErrorGenerico ("Se está ingresando un número en lugar de un correo.");
		}
		
		// Resultado según nombreCampo
		if (nombreCampoCorrecto) {
			return entrada;
		} else {
			throw new ErrorGenerico ("Por favor ingresar un correo válido de la forma: \"ejemplo@dirección.com\".");
		}
	}

	// Control de contraseña del Usuario
	public static String controlCampoVacio (String entrada, String nombreCampo) throws ErrorGenerico {
		
		/*
		   Propósito: Se encarga de controlar que la contraseña ingresada por el Usuario
		              sea válida
		 */

		// Atributos
//		String contrasenaComprobada;
//		long comprobacion;

		// Control de error
		if (!entrada.isEmpty()) {
			return entrada;
		}
		else {
			throw new ErrorGenerico ("Ha ingresado una cadena vacía en el campo " + nombreCampo);
		}
		
//		while (true) {
//			// Impresión de mensaje y recepción de datos
//			System.out.print("Confirmar contraseña => ");
//			contrasenaComprobada = OpcionDeMenu.br.readLine().trim();
//			comprobacion = esLong(contrasenaComprobada);
//
//			// Control de error
//			if (comprobacion != 0) {
//				if (contrasenaComprobada.equals(contrasenaIngresada)) {
//					return true;
//				} else {
//					System.out.println("\nLas contraseñas no coinciden.");
//				}
//				if (!!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//			} else {
//				return false;
//			}
//		}
	}

	public static void errorNegativo(int numero, int cantidadRestada, String error) throws ErrorGenerico{
		if (numero + cantidadRestada < 0) {
			throw new ErrorGenerico(error);
		}
	}

	public static void errorSinCuentas(int numero, String mensaje) throws ErrorSinCuentas {
		if (numero == 1) {
			throw new ErrorSinCuentas(mensaje);
		}
	}
	
	public static void errorSinProductos(int numero) throws ErrorSinProductos {
		if (numero == 0) {
			throw new ErrorSinProductos();
		}
	}
}