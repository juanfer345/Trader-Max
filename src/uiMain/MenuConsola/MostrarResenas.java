package uiMain.Funcionalidades;
import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.OpcionDeMenu;

class MostrarResenas extends OpcionDeMenu {
	public void ejecutar() throws IOException{
		controlError = false;
		String codigo;
		int cuentaCod,opcion;
		Cuenta cuenta = InicializacionAplicacion.usuarioActivo;
		if (!cuenta.getCatalogo().isEmpty()) {
			sb.append("\nNOTA: se puede cancelar la operaci�n ingresando en cualquiera de los dos datos el n�mero '0'");
			while (!controlError) {
				System.out.println(sb);
				System.out.println("Ingrese el codigo del producto al cual le quiere ver las rese�as => ");
				codigo = br.readLine().trim();
				cuentaCod = esInt(codigo);
				while (cuentaCod == -1) {
					System.out.println("\nEl dato que ingreso como codigo es invalido, vuelva a intentarlo.");
					System.out.print("Ingrese el codigo del producto al cual le quiere ver las rese�as => ");
					codigo = br.readLine().trim();
					cuentaCod = esInt(codigo);
				}
				if (cuentaCod == 0) {
					controlError = true;
					System.out.println(" ");
				} else {
					if (!cuenta.getCatalogo().containsKey(cuentaCod)) {
						System.out.println("C�digo invalido");
					}else {
						Producto prod = cuenta.getCatalogo().get(cuentaCod);
					String str = prod.mostrarResenas();
					if (str.equals("Este producto no tiene rese�as. ")) {
						System.out.println(str);
						System.out.println("Ingrese 0 para salir o cualquier otro caracter para repetir el proceso.");
						String op = br.readLine().trim();
						opcion = esInt(op);
						if(opcion == 0) {
							controlError = true;
						}
						
					} else {
						controlError = true;
					}
				}
				}
			}
		} else {
			System.out.println("El cat�logo est� vacio");
			controlError = true;
		}
	}
	public String toString() {
		return "Mostrar rese�as de un producto";
	}
}
