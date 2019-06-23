package uiMain;

class salir extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		SalirApp = true; 
	}

	@Override
	public String toString() {
		return "Salir";
	}

}
