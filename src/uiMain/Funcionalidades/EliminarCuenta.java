package uiMain.Funcionalidades;

import java.io.IOException;

import gestorAplicación.InicializacionAplicacion;
import gestorAplicación.Usuarios.Comprador;
import gestorAplicación.Usuarios.CuentaUsuarios;
import uiMain.OpcionDeMenu;

class EliminarCuenta extends OpcionDeMenu {
boolean z = false;
CuentaUsuarios c;
int llave = -1;
	@Override
	public void ejecutar() throws IOException {
		System.out.println("Diga el id de la cuenta a eliminar");	
		int id = Integer.parseInt(br.readLine().trim());
		
		(InicializacionAplicacion.getBDCompradores()).forEach((k,v)-> {
			if((v.getId()==id)) {
				z=true;
				llave = k;
				c = v;
			}
		});
		(InicializacionAplicacion.getBDVendedores()).forEach((k,v)-> {
			if(v.getId()==id) {
				z=true;
				llave = k;
				c = v;
				
			}
		});	
		if (z) {
			if(c instanceof Comprador) {
				(InicializacionAplicacion.getBDCompradores()).remove(llave);
			}else {
				(InicializacionAplicacion.getBDVendedores()).remove(llave);
			}
		}else {
			System.out.println("El id no es válido");
		}
	}

	@Override
	public String toString() {
		return "Eliminar cuenta";
	}

}
