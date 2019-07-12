package uiMain.Funcionalidades.Invitado;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Visitante;
public class Registrar extends OpcionDeMenu { // opcion 0
	boolean x = false;
	Integer key;
	public void ejecutar() throws IOException{
		System.out.println("Ingresa 0 para volver\nTipo de cuenta: \n1.Vendedor\n2.Comprador");
		short t = Short.parseShort(MenuDeConsola.br.readLine().trim()); 
		if (t==0) {    
			OpcionDeMenu.controlError = true; 	
			return;   //acaba el metodo
		}
		System.out.println("Ingresa 0 para volver\nNombre: ");		
		String n = MenuDeConsola.br.readLine().trim();
		 boolean ComprobNom = MenuDeConsola.EsByte(n); // ver si es un byte el nombre
		 if (ComprobNom){
				if (Byte.parseByte(n)==0) {            //ver si es un 0 para devolverse
					OpcionDeMenu.controlError = true; 	
				    return; //
				}				
			}
		System.out.println("Ingresa 0 para volver\nCorreo: ");
		String c = MenuDeConsola.br.readLine().trim();
		 boolean ComprobCor = MenuDeConsola.EsByte(c); // ver si es un byte el correo
		 if (ComprobCor){
				if (Byte.parseByte(c)==0) {            //ver si es un 0 para devolverse
					OpcionDeMenu.controlError = true; 	
				    return; //
				}				
			}
		System.out.println("Ingresa 0 para volver\nCedula: ");
		int cc = Integer.parseInt(MenuDeConsola.br.readLine().trim());
		if (cc==0 ) {
			OpcionDeMenu.controlError = true; 	
			return; //
		} 
		System.out.println("Ingresa 0 para volver\nContraseña: ");
		String p = MenuDeConsola.br.readLine().trim();
		 boolean ComprobCont = MenuDeConsola.EsByte(p); // ver si es un byte la contraseña
			if (ComprobCont){
				if (Byte.parseByte(p)==0) {            //ver si es un 0 para devolverse
					OpcionDeMenu.controlError = true; 	
				    return; //
				}				
			}
		
		Visitante x = (Visitante) InicializacionAplicacion.usuarioActivo;
		String str = x.Registrarse(t,n,c,cc,p);
        System.out.println(str);

		

	}

	public String toString() {
		return "Registrar";
	}
}
