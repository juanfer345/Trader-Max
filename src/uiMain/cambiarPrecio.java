package uiMain;

import gestorAplicación.Usuarios.Vendedor;

class cambiarPrecio extends OpcionDeMenu {

	public void ejecutar() {
		System.out.println("Ingrese el nombre del producto");
		String nom = scn.next();
		System.out.println("Ingrese el nuevo precio");
		double pre = scn.nextDouble();
		Vendedor.cambiarPrecio(nom, pre);
		
	}

	public String toString() {
		return "Cambiarle el precio a un producto";
	}

}
