package uiMain.Funcionalidades.Cuenta.Vendedor;

import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.OpcionDeMenu;

public class EliminarProductoCatalogo extends OpcionDeMenu {

	public void ejecutar() throws NumberFormatException, IOException {

		StringBuilder sb = new StringBuilder();
		int cod;

		sb.append("\n Esta opción es para eliminar un producto de tu catalogo");
		sb.append("\n Recuerde que el producto a eliminar debe ser de su propiedad");
		sb.append("\n Para devolverse al menú anterior, ingrese el número '0'");
		sb.append("\n Ingrese el código del producto a eliminar o el número '0': ");

		while (!controlError) {

			System.out.println(sb);

			try {
				cod = Integer.parseInt(br.readLine().trim()); //Puede que se genere un error (depende del dato)
				
				//Apartir de aquí no se generan errores
				if (cod == 0) { //Por si se quiere salir el usuario
					controlError = true;
				} else { //Si el usuario no quiere salir, continua el proceso
					//Analiza el codigo introducido para eliminar producto
					Vendedor comp = (Vendedor) InicializacionAplicacion.usuarioActivo;
					String str = comp.eliminarProductoCatalogo(cod);

					if (str.equals("No existe el producto") || str.equals("No es un producto propio, no puede ser eliminado")) {
						System.out.println(str);
					} else {
						System.out.println(str);
						controlError = true;
					}
					
				}
				
			} catch (NumberFormatException nfe) {
				System.out.println("\n El codigo que ingreso es invalido");
			}
		}
	}

	public String toString() {
		return "Eliminar producto";
	}
}