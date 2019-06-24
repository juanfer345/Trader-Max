package uiMain.Funcionalidades;
import java.io.IOException;
import gestorAplicaci�n.Materiales.Rese�a;
import gestorAplicaci�n.Usuarios.Comprador;
import uiMain.OpcionDeMenu;

public class AgregarRese�a extends OpcionDeMenu { // opcion 10

	@Override
	public void ejecutar() throws IOException {
		Comprador comp = (Comprador)usuario;
		comp.getHistorial().forEach((k, v) -> {
			System.out.println(v);
		});
		System.out.println("Ingrese el codigo del producto: ");
		int codigoP = scn.nextInt();
		System.out.println("Ingrese numero de estrellas: ");
		int estrellas = scn.nextInt();
		System.out.println("Ingrese comentario: ");
		String comentario = br.readLine();
		Rese�a rese = new Rese�a(comentario, estrellas);
		String str =comp.a�adirRese�a(codigoP,rese);
		System.out.println(str);
	}
	@Override
	public String toString() {
		return "Agregar rese�a ";
	}
}