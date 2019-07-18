package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import  gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class SubirProducto extends OpcionDeMenu { 

	@Override
	public void ejecutar() throws IOException {
		
		StringBuilder sb = new StringBuilder();
		String nombre, categoria;
		int cant;
		double precio;
		Vendedor vend;
		byte cat;
		
		sb.append("\n Esta opción es para registrar un produto");
		sb.append("\n Para devolverse al menú anterior, ingrese el número '0'");
		
		while (!controlError) {

			System.out.println(sb);
		
			System.out.println("\n Ingrese el nombre del producto o el número 0: ");
			nombre = br.readLine().trim();
			
			if (nombre.equals("0")) {
				controlError = true;
			} else { 
				//Si el usuario no quiere salir, continua el proceso
				try {
					System.out.println("\n Ingrese la cantidad: ");
					cant = Integer.parseInt(br.readLine().trim());
					System.out.println("\n Ingrese el precio: ");
					precio = Double.parseDouble(br.readLine().trim());
					//El for para las categorias, aquí comienza
					for (int i=0; i<11; i++) {
						System.out.println((i+1) + ": " + Producto.categorias[i]);
					}
					System.out.println("\n Ingrese el número de alguna de las anteriores categorias: ");
					cat = Byte.parseByte(br.readLine().trim());
					//El while es por si el usuario ingresa una categoria inexistente
					while(cat<0 || cat>10) {
						System.out.println("\n Ingrese el número de alguna de las anteriores categorias: ");
						cat = Byte.parseByte(br.readLine().trim());
					}
					categoria = Producto.categorias[cat];
					//Hasta aquí llega lo de las categorias
					vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
					Vendedor.subirProducto(vend, nombre, categoria, precio, cant);
					System.out.println("\n Se ha subido el producto exitosamente");
					controlError = true;
					
				} catch (NumberFormatException nfe) {
					controlError = false;
					System.out.println("/n Por favor asegurese de ingresar un número");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Subir producto";
	}
}