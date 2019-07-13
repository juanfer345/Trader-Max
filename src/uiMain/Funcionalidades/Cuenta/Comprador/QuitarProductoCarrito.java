package uiMain.Funcionalidades.Cuenta.Comprador;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class QuitarProductoCarrito extends OpcionDeMenu { // opcion 9

	@Override
	public void ejecutar() throws NumberFormatException, IOException {
		
		int cod, cantidad;
		
		sb.append("\n Para devolverse al menú, ingrese el numero '0'");
		sb.append("\n Si alguno de los 2 datos ingresados es '0', se saldrá de esta opcion");
		
		controlError = false;
		
		while (!controlError) {

			System.out.println(sb);

			try {
				System.out.println("Ingrese el codigo del producto que desea eliminar: ");
				cod = Integer.parseInt(br.readLine().trim()); 
				System.out.println("Ingrese la cantidad de elementos que desea quitar: ");
				cantidad = Integer.parseInt(br.readLine().trim());
				
				if (cod == 0 || cantidad == 0) { 
					controlError = true;	
				}else {
					//Si el usuario no quiere salir, continua el proceso
					Comprador comp = (Comprador) InicializacionAplicacion.usuarioActivo;
					String str = comp.getCarrito().quitarProducto(cod, cantidad);

					if (str.equals("La cantidad ingresada excede la existente") || 
						str.equals("El producto no está en el carrito")|| 
						str.equals("La cantidad ingresada debe ser mayor a cero"))
					{
						System.out.println(str);
						System.out.println("Repita el proceso con datos correctos");	
					} else {
						System.out.println(str);
						controlError = true;
					}
				}
				
			} catch (NumberFormatException nfe) {
				//Por si se ingresa un tipo de dato diferente
				System.out.println("\n El codigo o la cantidad que ingreso es invalido");
			}

		}

	}
		
	@Override
	public String toString() {
		return "Quitar producto del carrito";
	}
}