package gestorAplicaci�n.Usuarios;

/*PROPUESTA por juanfer: ya que administrador deber�a heredar algunos atributos de cuenta (pero no todos), 
						 que les parece si se quita cuenta y en su remplazo creamos dos interfaces, de tal manera que una interfaz tenga todo lo de cuenta, pero sin 
						 ciertos atributos y otra interfaz tenga todo lo que le falte (adem�s de esta manera vamos llenando los requisitos del trabajo)
*/

public class Administrador extends Cuenta {
	
	public int getNumeroCuentas(){
		return totalCuentas;
		
	}

}