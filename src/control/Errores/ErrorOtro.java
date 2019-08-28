package control.Errores;

public class ErrorOtro extends ErrorAplicacion {
	
	public ErrorOtro(String mensaje) {
		super(mensaje);
	}
}

class ErrorSinCuentas extends ErrorAplicacion{
	
	ErrorSinCuentas(String mensaje){
		super(mensaje);
	}
}

class ErrorSinProductos extends ErrorAplicacion{
	
	ErrorSinProductos(){
		super("El catálogo se encuentra vacío");
	}
}

class ErrorGenerico extends ErrorAplicacion{
	
	ErrorGenerico(String mensaje){
		super(mensaje);
	}
}
