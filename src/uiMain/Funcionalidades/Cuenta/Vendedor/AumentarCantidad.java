package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class AumentarCantidad extends OpcionDeMenu{

	public void ejecutar() throws IOException {
		String nombre;
		long comprobNom;
		long cantidad;
		System.out.println("Ingrese el nombre del producto: ");
		nombre = br.readLine();
		comprobNom=  MenuDeConsola.esNumeroEntero(nombre); // ver si es un numero el nombre	
		//control de ingreso nombre
		while(comprobNom !=-1) {
			//ver si es un 0 para devolverse	
			if (comprobNom==0){  	
				return; //								
			}	
			else {
				System.out.println("Ingresar un nombre valido");
				nombre = br.readLine().trim();
				comprobNom = MenuDeConsola.esNumeroEntero(nombre);
			}
		}		
		System.out.println("Ingrese la cantidad a agregar: ");		
		cantidad = MenuDeConsola.esNumeroEntero(br.readLine().trim());
		while(cantidad ==-1) {							
			System.out.println("Ingresar una cantidad valida: ");
			cantidad = MenuDeConsola.esNumeroEntero(br.readLine().trim());
		}
		//ver si es un 0 para devolverse
		if (cantidad==0){ 					
			return; //								
		}	
		
		String str = Vendedor.aumentarCantidad(nombre, (int)cantidad);
		System.out.println(str);
	}

	public String toString() {
		return "Aumentar cantidad de producto";
	}
}