package uiMain.Funcionalidades.Visitante;
import java.io.IOException;
import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
public class Registrar extends OpcionDeMenu { // opcion 0
	public void ejecutar() throws IOException{
		long tipoDeCuenta;
		String nombreDado;
		long comprobNom;
		String correoDado;
		Long comprobCor;
		long cedulaDada;
		String contrasenaDada;
		long comprobCont;	
		System.out.println("Ingresa 0 para volver\nTipo de cuenta: \n1.Vendedor\n2.Comprador");
		tipoDeCuenta = MenuDeConsola.esNumeroEntero(br.readLine().trim()); 
		//control de ingreso tipo de usuario
		while(tipoDeCuenta!=1&&tipoDeCuenta!= 2&&tipoDeCuenta!=0) {
			System.out.println("Ingresar un tipo usuario valido: ");
			tipoDeCuenta = Short.parseShort(br.readLine().trim());
		}
		if (tipoDeCuenta==0) {    			 	
			return;   //acaba el metodo
		}	   
		System.out.println("Nombre: ");		
		nombreDado = br.readLine().trim();
		comprobNom = MenuDeConsola.esNumeroEntero(nombreDado); // ver si es un numero el nombre	
		//control de ingreso nombre
		while(comprobNom !=-1) {
			//ver si es un 0 para devolverse	
			if (comprobNom==0){  	
				return; //								
			}	
			else {
				System.out.println("Ingresar un nombre valido");
				nombreDado = br.readLine().trim();
				comprobNom = MenuDeConsola.esNumeroEntero(nombreDado);
			}
		}
		System.out.println("Correo: ");
		correoDado = br.readLine().trim();
		comprobCor = MenuDeConsola.esNumeroEntero(correoDado); // ver si es un numero el correo
		//control de ingreso correo
		while(comprobCor !=-1) {
			//ver si es un 0 para devolverse
			if (comprobCor==0){  					
				return; //								
			}	
			else {
				System.out.println("Ingresar un correo valido");
				correoDado = br.readLine().trim();
				comprobCor = MenuDeConsola.esNumeroEntero(nombreDado);
			}
		}
		System.out.println("Cedula: ");
		cedulaDada = MenuDeConsola.esNumeroEntero(br.readLine().trim());
		//control de ingreso de cedula
		while(cedulaDada ==-1) {							
			System.out.println("Ingresar una cedula valida");
			cedulaDada = MenuDeConsola.esNumeroEntero(br.readLine().trim());
		}
		//ver si es un 0 para devolverse
		if (cedulaDada==0){ 					
			return; //								
		}	
		System.out.println("Contraseña: ");
		contrasenaDada = br.readLine().trim();
		comprobCont = MenuDeConsola.esNumeroEntero(contrasenaDada); // ver si es un numero la contraseña
		//ver si es un 0 para devolverse
		if (comprobCont==0){				          
			OpcionDeMenu.controlError = true; 	
			return; //
		}

		
		Visitante x = (Visitante) InicializacionAplicacion.usuarioActivo;
		String str = x.Registrarse((short)tipoDeCuenta,nombreDado,correoDado,(int)cedulaDada,contrasenaDada);
		//para que no se salga del metodo
		while (str =="El correo ya se encuentra registrado"){   
			System.out.println("El correo ya se encuentra regustrado, ingresar uno nuevo: ");
			correoDado = br.readLine().trim();
			comprobCor = MenuDeConsola.esNumeroEntero(correoDado); // ver si es un numero el correo
			//control de ingreso de correo
			while(comprobCor !=-1) {
				//ver si es un 0 para devolverse
				if (comprobCor==0){  					
					return; //								
				}	
				else {
					System.out.println("Ingresar un correo valido");
					correoDado = br.readLine().trim();
					comprobCor = MenuDeConsola.esNumeroEntero(nombreDado);
				}
			}
			str=x.Registrarse((short)tipoDeCuenta,nombreDado,correoDado,(int)cedulaDada,contrasenaDada);
		}
		System.out.println(str);
	}

	public String toString() {
		return "Registrarse";
	}
}
