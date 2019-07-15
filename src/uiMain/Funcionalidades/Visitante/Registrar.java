package uiMain.Funcionalidades.Visitante;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.MenuDeConsola;

public class Registrar extends ControlErrorDatosUsuario {
	
	public void ejecutar() throws IOException {
		Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
		String nombreIngresado, correoIngresado, contrasenaIngresada;
		int cedulaIngresada;
		byte tipoDeCuenta;
		
		//Control de ingreso tipo de usuario
		tipoDeCuenta = controlTipoDeCuenta();
		if (controlError) {System.out.println(); return;}
		
		//Control de ingreso de nombre
		nombreIngresado = controlNombre();
		if (controlError) {System.out.println(); return;}
		
		//Control de ingreso de correo
		correoIngresado = controlCorreo();
		if (controlError) {System.out.println(); return;}
		
		//Control de ingreso de cedula
		cedulaIngresada = controlCedula();
		if (controlError) {System.out.println(); return;}
		
		//Control de ingreso de contrase�a
		System.out.print("Contrase�a: ");
		if (MenuDeConsola.esNumeroEntero(contrasenaIngresada = br.readLine().trim()) == 0) {
			System.out.println(); 
			return;
		}
		if (!controlContrasena(contrasenaIngresada)) {System.out.println(); return;}
		
		//Ejecuci�n del m�todo de registro con control de error
		while (!controlError) {
			
			//Ejecuci�n e impresi�n del m�todo
			System.out.println(usuario.Registrarse((byte) tipoDeCuenta, nombreIngresado, 
					           correoIngresado, (int) cedulaIngresada, contrasenaIngresada));
			
			if(!controlError) {
				correoIngresado = controlCorreo();
				if (controlError) {System.out.println(); return;}
			}
		}
	}
	
	@Override
	public String toString() {return "Registrarse";}
}