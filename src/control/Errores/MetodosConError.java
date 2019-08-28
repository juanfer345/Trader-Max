package control.Errores;

public class MetodosConError {
	
	//Control de n�mero real
	public static double controlNumero (String entrada, double limInferior, double limSuperior, String nombreCampo, String Error) throws ErrorTipodeDato {

		/*
		   Prop�sito: Se encarga de controlar el nombreCampo de un n�mero entero (int) que deba ingresar el usuario
		 */

		try {
			double numeroReal = Double.parseDouble(entrada);

			if(numeroReal >= limInferior && numeroReal <= limSuperior) {
				return numeroReal;
			}
			else {
				throw new ErrorTipodeDato("Por favor ingrese un n�mero real en el rango [" + limInferior + "," + limSuperior + "]"
						+ " en el campo " + nombreCampo + ".");
			}
		}
		catch (NumberFormatException e) {
			throw new ErrorTipodeDato(Error);
		}

	}
	
	//Control de n�mero de entero
	public static int controlNumero (String entrada, int limInferior, int limSuperior, String nombreCampo, String Error) throws ErrorTipodeDato {
		
		/*
		   Prop�sito: Se encarga de controlar el nombreCampo de un n�mero entero (int) que deba ingresar el usuario
		 */

		try {
			int numeroEntero = Integer.parseInt(entrada);

			if(numeroEntero >= limInferior && numeroEntero <= limSuperior) {
				return numeroEntero;
			}
			else {
				throw new ErrorTipodeDato("Por favor ingrese un n�mero entero en el rango [" + limInferior + "," + limSuperior + "]"
						+ " en el campo " + nombreCampo + ".");
			}
		}
		catch (NumberFormatException e) {
			throw new ErrorTipodeDato(Error);
		}
	}
	
	//Control de n�mero entero peque�o
	public static byte controlNumero (String entrada, byte limInferior, byte limSuperior, String nombreCampo, String Error) throws ErrorTipodeDato {
		
		/*
		   Prop�sito: Se encarga de controlar el nombreCampo de un n�mero entero (byte) que deba ingresar el usuario
		 */

		try {
			byte numeroByte = Byte.parseByte(entrada);
			
			if(numeroByte >= limInferior && numeroByte <= limSuperior) {
				return numeroByte;
			}
			else {
				throw new ErrorTipodeDato("Por favor ingrese un n�mero entero en el rango [" + limInferior + "," + limSuperior + "]"
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
		   Prop�sito: Se encarga de controlar una cadena de texto que haya ingresado el usuario
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
				throw new ErrorTipodeDato("Ha ingresado una cadena vac�a en el campo " + nombreCampo);
			}
		}
	}
	
	// Control de correo del Usuario
	public static String controlCorreo (String entrada) throws ErrorGenerico {

		/*
		   Prop�sito: Se encarga de controlar que el correo ingresado por el Usuario
		              sea v�lido
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
			throw new ErrorGenerico ("Se est� ingresando un n�mero en lugar de un correo.");
		}
		
		// Resultado seg�n nombreCampo
		if (nombreCampoCorrecto) {
			return entrada;
		} else {
			throw new ErrorGenerico ("Por favor ingresar un correo v�lido de la forma: \"ejemplo@direcci�n.com\".");
		}
	}

	// Control de contrase�a del Usuario
	public static String controlCampoVacio (String entrada, String nombreCampo) throws ErrorGenerico {
		
		/*
		   Prop�sito: Se encarga de controlar que la contrase�a ingresada por el Usuario
		              sea v�lida
		 */

		// Atributos
//		String contrasenaComprobada;
//		long comprobacion;

		// Control de error
		if (!entrada.isEmpty()) {
			return entrada;
		}
		else {
			throw new ErrorGenerico ("Ha ingresado una cadena vac�a en el campo " + nombreCampo);
		}
		
//		while (true) {
//			// Impresi�n de mensaje y recepci�n de datos
//			System.out.print("Confirmar contrase�a => ");
//			contrasenaComprobada = OpcionDeMenu.br.readLine().trim();
//			comprobacion = esLong(contrasenaComprobada);
//
//			// Control de error
//			if (comprobacion != 0) {
//				if (contrasenaComprobada.equals(contrasenaIngresada)) {
//					return true;
//				} else {
//					System.out.println("\nLas contrase�as no coinciden.");
//				}
//				if (!!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
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