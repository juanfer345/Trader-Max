package uiMain;

import gestorAplicaci�n.Usuarios.Comprador;

class borrarHistorial extends OpcionDeMenu { // opcion 5

	@Override
	public void ejecutar() {
		usuario.borrarHistorial();
	}

	@Override
	public String toString() {
		return "Borrar Historial";
	}

}