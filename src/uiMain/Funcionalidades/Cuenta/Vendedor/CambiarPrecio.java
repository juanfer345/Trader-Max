package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class CambiarPrecio extends OpcionDeMenu {

	public void ejecutar() throws IOException {
		String nom;
		long comprobNom;
		long pre;
		System.out.println("Ingrese 0 para volver\nIngrese el nombre del producto");
		nom = br.readLine();
		comprobNom=  MenuDeConsola.esNumeroEntero(nom); // ver si es un numero el nombre	
		//control de ingreso nombre
		while(comprobNom !=-1) {
			//ver si es un 0 para devolverse	
			if (comprobNom==0){  	
				return; //								
			}	
			else {
				System.out.println("Ingresar un nombre valido");
				nom = br.readLine().trim();
				comprobNom = MenuDeConsola.esNumeroEntero(nom);
			}
		}		
		System.out.println("Ingrese el nuevo precio");
		pre =  MenuDeConsola.esNumeroEntero(br.readLine().trim());
		while(pre ==-1) {							
			System.out.println("Ingresar un precio valido: ");
			pre = MenuDeConsola.esNumeroEntero(br.readLine().trim());
		}
		//ver si es un 0 para devolverse
		if (pre==0){ 					
			return; //								
		}	
		String str = Vendedor.cambiarPrecio(nom,(double) pre);
		System.out.println(str);
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}
}