package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class ModificarCantidad extends OpcionDeMenu{

	public void ejecutar() throws IOException {
		String nombre;
		long comprobNom;
		int cantidad;
		int cantidadDeproductos=0;
		String operacion;
		//imprimir la lista de sus productos
		System.out.println("Sus productos en el catalogo: ");
		System.out.println();
		for (Map.Entry<Integer, Producto> entry : Vendedor.catalogo.entrySet()) {
			Producto iteradorCatalogo = entry.getValue();
			if (iteradorCatalogo.getVendedor().getId() == InicializacionAplicacion.usuarioActivo.getId()) {
				System.out.println("-"+iteradorCatalogo.getNombreProducto()+ " cantidad: "+iteradorCatalogo.getCantidad());
				cantidadDeproductos++;
			}

		}
		//comprobar que si tenga productos propios en el catalogo
		if (cantidadDeproductos ==0) {
			System.out.println("Usted no tiene producos en el catalogo");
			System.out.println();
			return;
		}
		System.out.println();
		System.out.println("Ingrese el nombre del producto: ");
		nombre = br.readLine().trim();
		comprobNom = MenuDeConsola.esInt(nombre); // ver si es un numero el nombre	
		//control de ingreso nombre
		while(comprobNom !=-1) {
			//ver si es un 0 para devolverse	
			if (comprobNom==0){ 
				System.out.println();
				return; //								
			}	
			else {
				System.out.println("Ingresar un nombre valido");
				nombre = br.readLine().trim();
				comprobNom = MenuDeConsola.esLong(nombre);
			}
		}		
		System.out.println("Ingrese la cantidad a modificar: ");		
		cantidad = MenuDeConsola.esInt(br.readLine().trim());
		while(cantidad ==-1) {							
			System.out.println("Ingresar una cantidad valida: ");
			cantidad = MenuDeConsola.esInt(br.readLine().trim());
		}
		//ver si es un 0 para devolverse
		if (cantidad==0){ 		
			System.out.println();
			return; //								
		}	
		System.out.println("Ingrese + si desea amuentar o - si desea restar esta cantidad: ");
		operacion = br.readLine().trim();
		while (operacion.equals("0")||operacion.equals("+")||operacion.equals("-")){
			System.out.println("Ingrese un operador valido o el numero 0 para cancelar: ");
			operacion = br.readLine().trim();
		}
		if (operacion.equals("0")){
			System.out.println();
			return;
		}

		String str = Vendedor.modificarCantidad(nombre, cantidad,operacion);
		System.out.println(str);
	}

	public String toString() {
		return "Aumentar cantidad de producto";
	}
}