package uiMain.Funcionalidades;

import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Usuarios.Cuenta;
import uiMain.OpcionDeMenu;

public class iniciarSesion extends OpcionDeMenu { // opcion 1
	Integer key =-1;
	Cuenta us;
	byte intentar = 1;
	public void ejecutar() {
		
		System.out.println("Correo: ");
		String c = br.readLine().trim();
		System.out.println("Contraseña: ");
		String p = br.readLine().trim();
		
		(InicializacionAplicacion.getBDCompradores()).forEach((k, v) -> {
			if ((v.getCorreo().equals(c))) {
				key = k;
			}
		});
		if(key!=-1 &&(InicializacionAplicacion.getBDCompradores()).get(key).getPassword().equals(p)) {
			us = (InicializacionAplicacion.getBDCompradores()).get(key);
		}
		else if (key == -1){	
			(InicializacionAplicacion.getBDVendedores()).forEach((k,v)->
			{
				if ((v.getCorreo().equals(c))) {
					key = k;
				}
			});
			if(key!=-1 && (InicializacionAplicacion.getBDVendedores()).get(key).getPassword().equals(p)){
				us = (InicializacionAplicacion.getBDVendedores()).get(key);
			}
		}else{	
			(InicializacionAplicacion.getBDAdministradores()).forEach((k,v)->
			{
				if ((v.getCorreo().equals(c))) {
					key = k;
				}
			});
			if(key!=-1 && (InicializacionAplicacion.getBDAdministradores()).get(key).getPassword().equals(p)){
				us = (InicializacionAplicacion.getBDAdministradores()).get(key);
			}
		}
		if(key==-1) {
			System.out.println("El correo no se encuentra registrado");
		}else {
				do {
					if (us.getPassword().equals(p)) {
						usuario = us;
						break;
					}else {
						System.out.println("Contraseña incorrecta. \n1.Volver a intentar\n2.Cancelar");
						intentar = scn.nextByte();
						if(intentar==1) {
							System.out.println("Ingrese la contraseña: ");
							p = scn.next();
						}
					}
				}while(intentar!=1);
				 if (intentar == 2) {
					 //se devuelve al inicializador de aplicacion
				 }
		}
	}
	
	public String toString() {
		return "Iniciar Sesión";
	}

}
