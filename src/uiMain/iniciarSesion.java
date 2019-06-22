package uiMain;

import gestorAplicación.InicializacionAplicacion;

class iniciarSesion extends OpcionDeMenu { // opcion 1

	@Override
	public void ejecutar() {
		
		System.out.println("Diga su tipo de cuenta: \n1.Comprador\n2.Vendedor");
		Short t = e.nextShort();
		System.out.println("Correo: ");
		String c = e.next();
		System.out.println("Contraseña: ");
		String p = e.next();

		Integer key;

		(InicializacionAplicacion.getBDCompradores()).forEach((k, v) -> {
			if ((v.getCorreo().equals(c))) {

				key = k;
			}
		});
		if ((InicializacionAplicacion.getBDCompradores()).get(key).getPassword().equals(p)) {
			usuario = (InicializacionAplicacion.getBDCompradores()).get(key);

		}
		else{
			
	}
       
	

	boolean xx = false;
	Integer kkey;(InicializacionAplicacion.getBDVendedores()).forEach((k,v)->
	{
		if ((v.getCorreo().equals(c))) {
			xx = true;
			kkey = k;
		}
	});if(!(InicializacionAplicacion.getBDVendedores()).get(kkey).getPassword().equals(p))
	{
		int intentar = 1;
		while (intentar != 0)
			System.out.println("La contraseña no coincide");
		System.out.println("Para cancelar ingrese 0 para reintentar ingrese 1: ");
		intentar = e.nextInt();
		p = e.next();
		if ((InicializacionAplicacion.getBDVendedores()).get(kkey).getPassword().equals(p)) {
			usuario = (InicializacionAplicacion.getBDVendedores()).get(kkey);
			break;
		}
	}else
	{
		usuario = (InicializacionAplicacion.getBDVendedores()).get(kkey);
	}

	else
	{
		System.out.println("El correo no se encuentra registrado ");
	}

	}

	public String toString() { // cosa inutil

		return "Iniciar Sesión";
	}

}
