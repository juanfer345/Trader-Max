/*
	Clase InicializacionAplicacion (p�blica)
	
	Prop�sito: Contiene la rutina principal del programa.
*/
package uiMain;

import java.io.IOException;
import java.util.HashMap;

import baseDatos.EscrituraBD;
import baseDatos.LecturaBD;
import gestorAplicacion.Materiales.CuentaBancaria;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Materiales.Resena;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Vendedor;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.MenuConsola.MenuDeConsola;
import uiMain.vista.VentanaAplicacion;

public class InicializacionAplicacion {

    private static HashMap <Integer, Comprador> BDCompradores = new HashMap <> ();
    private static HashMap <Integer, Vendedor> BDVendedores = new HashMap <> ();
    private static HashMap <Integer, Administrador> BDAdministradores = new HashMap <> ();
    private static HashMap <Integer, CuentaBancaria> BDCuentasBancarias = new HashMap <> ();
    private static HashMap <Integer, Producto> BDProductos = new HashMap <> ();
    private static HashMap <Integer, Resena> BDResenas = new HashMap <> ();
	public static Cuenta usuarioActivo;
    
	public static void main(String[] args) throws IOException {
		
		//Creaci�n de objetos de lectura y escritura
		LecturaBD Lector = new LecturaBD();
		VentanaAplicacion interfaz = new VentanaAplicacion();
		
		//Ejecuci�n de la lectura de la base de datos
		Lector.PrincipalLecturaBD("Compradores", "Vendedores", "Administradores", "Cuentas Bancarias", "Cat�logo", "Productos", "Rese�as");
		
		//Creaci�n de un usuario visitante
		setUsuarioActivo (new Visitante());

//		public lanzarInterfaz() {
//			/*
//			  Prop�sito: Mostrar al usuario las opciones de men� disponibles para que este
//			             decida qu� desea hacer (posterior llamada a metodo ejecutar(). El metodo
//			             permite que el usuario tenga constantes acciones en el programa hasta que
//			             desee salir.
//			 */
	//
//			byte opcionSeleccionada = 0;
	//
//			while (!SalirApp) {
	//
//				OpcionDeMenu.sb.append("Elija una opci�n:\n");
//				
//				// Ciclo para listar por pantalla las opciones de men�
//				OpcionDeMenu.sb.append(prepararMenuImpresion(menuActivo));
	//
//				while (true) {
//					System.out.print(OpcionDeMenu.sb.toString() + "=> ");
//					opcionSeleccionada = OpcionDeMenu.esByte(OpcionDeMenu.br.readLine().trim());
//					
//					// Se realiza la eleccion de la opci�n
//					if (opcionSeleccionada > 0 && opcionSeleccionada <= menuActivo.size()) {
//						break;
//					} else {
//						System.out.println("Por favor ingrese un n�mero entero en el rango [1," + menuActivo.size() + "]\n");
//					}
//				}
//				OpcionDeMenu.controlError = false;
//				OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
//				menuActivo.get(opcionSeleccionada - 1).ejecutar();
//				// Llamado al metodo ejecutar de la opci�n de men� elegida
//				OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
	//
//				// El ciclo sigue hasta que el usuario ingrese la opci�n Salir
//		}
		
		//Ciclo de control para ejecutar el men� hasta que se desee salir de la aplicaci�n
		interfaz.lanzar();
		
	}

	public static HashMap <Integer, Comprador> getBDCompradores() {return BDCompradores;}
	public static void setBDCompradores(int idComprador, Comprador comp) {BDCompradores.put(idComprador, comp);}
	public static HashMap <Integer, Vendedor> getBDVendedores() {return BDVendedores;}
	public static HashMap <Integer, Administrador> getBDAdministradores() {return BDAdministradores;}
	public static HashMap <Integer, CuentaBancaria> getBDCuentasBancarias() {return BDCuentasBancarias;}
	public static HashMap <Integer, Producto> getBDProductos() {return BDProductos;}
	public static HashMap <Integer, Resena> getBDResenas() {return BDResenas;}

	public static void setUsuarioActivo(Cuenta usuario) {
		usuarioActivo = usuario;
		MenuDeConsola.menuActivo = usuario.getMenu();
	}
}