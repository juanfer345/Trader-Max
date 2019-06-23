package uiMain;

import gestorAplicación.Usuarios.Vendedor;

class aumentarCantidad extends OpcionDeMenu{

	public void ejecutar() {
		System.out.println("Ingrese el nombre del producto");
		String nom = e.next();
		System.out.println("Ingrese la cantidad a agregar ");
		int cant = e.nextInt();
		Vendedor.aumentarCantidad(nom, cant);
	}

	public String toString() {
		return "Aumentar cantidad de producto";
	}

}
