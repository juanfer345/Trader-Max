/*
	Clase CarritoDeCompras (pública)    
	
	Propósito: Guardar productos del usuario Comprador, manipulación de productos.
	
	Estructuras de datos relevantes: 
	- HashMap<Integer, Integer> productos: estructura para almacenamiento de productos
*/

package gestorAplicacion.Materiales;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.OpcionDeMenu;

public class CarritoDeCompras {

	private static Comprador titular;
	private static HashMap<Integer, Integer> productos;
	private static double precioTotal;
	private static int totalProductos;

	public CarritoDeCompras(Comprador comp) {
	/*
		Propósito: Constructor para carritos nuevos
		           
		Variables de entrada:
		- Comprador comp: Recibe un comprador el cual se le asigna como titular.
    */
		titular = comp;
		productos = new HashMap<>();
	}

	// Devuelve el HashMap con los productos del carrito
	public static HashMap<Integer, Integer> getProductos() {
		return productos;
	}
	
    // Permite cambiar la cantidad de un producto del carrito
	public void setProductos(int codigo, int cantidad) {productos.put(codigo, cantidad);}
	
   // Cambia los datos del carrito
	public void setProductos(Deque<Integer> idCantidadProd) {
		productos = new HashMap<>();
		while (!idCantidadProd.isEmpty()) {
			productos.put(idCantidadProd.poll(), idCantidadProd.poll());
		}
	}

	// Devuelve el total de productos que tiene el carrito
	public static int getTotalproductos() {return totalProductos;}
	
    // Devuelve el costo total actual del carrito
	public static double getPrecioTotal() {return precioTotal;}
	
	//Devuelve el actual titular del carrito de compras
	public static Comprador getTitular() {return titular;}
	
	//Muestra todos los productos del carrito
	public static String mostrarCarrito() {

		StringBuilder sb = new StringBuilder();
		sb.append("\nEl carrito posee un total de ").append(totalProductos).append(" productos con total acumulado de ").
		append(precioTotal).append(" pesos:\n");
		
		for (Map.Entry<Integer, Integer> entry : CarritoDeCompras.getProductos().entrySet()) {
			Producto prod = Cuenta.getCatalogo().get(entry.getKey()); 	// se obtiene el producto correspondiente al codigo
			sb.append(prod.toString()).append(", Cantidad en el carrito: ").append(entry.getValue()).
			append(", Precio total: ").append(prod.getPrecio() * entry.getValue()).append("]\n");
		}
		return sb.toString();
	}
	
	public static String agregarACarrito(int codigo, int cantidad) {
		/*
			  Propósito: Agregar al carrito cierta cantidad de un producto específico
			  
			  Variables de entrada: 
			  - int codigo: Código del producto que se desea agregar
			  - int cantidad: Cantidad de elementos que desea agregar del respectivo producto
			  
			  Variables de salida: 
			  - String con mensaje dependiendo si el proceso fue o no exitoso. 
			    Se mostrará el fallo que tiene el usuario en el ingreso de los datos
		 */

		//Verificación de que el catálogo contiene al producto
		if (Cuenta.getCatalogo().containsKey(codigo)) {

			//Verificación de que el usuario no agrega productos que el haya subido
			if (!InicializacionAplicacion.getBDVendedores().containsKey(titular.getId())) {
			
			Producto prod = Cuenta.getCatalogo().get(codigo);	//Obtención del apuntador al producto
			
			// Verificación de que se tiene la cantidad solicitada de producto en el catálogo
			if (prod.getCantidad() >= cantidad) {

				productos.put(codigo, cantidad);			//Añadiendo el producto al carrito
				totalProductos += cantidad;					//Actualizando el total de productos del carrito
				precioTotal += cantidad * prod.getPrecio();	//Actualizando el precio total de los productos del carrito

				//Resta temporal de la cantidad de producto en el catálogo (mientras la sesión está activa o antes confirmar la compra)
				prod.setCantidad(prod.getCantidad() - cantidad);
				OpcionDeMenu.controlError = true;

				if (cantidad == 1) {
					return "Se ha agregado una unidad del producto \"" + prod.getNombreProducto() + "\" al carrito.\n";
				} else {
					return "Se han agregado " + cantidad + " unidades del producto \"" + prod.getNombreProducto() + "\" al carrito.\n";
				}
			} else {
				return "La cantidad ingresada es mayor a la disponilble (" + prod.getCantidad() + "), intentalo de nuevo.";
			}
			}
			else {
				return "No se permite comprar productos que tu mismo hayas subido.\n";
			}
		} else {
			return "Este producto no existe, intentalo de nuevo.";
		}
	}

	public static String comprarProductos() {
		/*
			Propósito: Realizar la compra de los productos disponibles en el carrito 
			           haciendo la respectiva transacción de dinero de la cuenta del
			           comprador al vendedor   		

			Variables de salida:
			- String con mensaje dependiendo si el proceso fue o no exitoso.
		 */
		
		//Verificación del saldo del comprador
		if (titular.getCuentaBancaria().getSaldo() >= precioTotal) {
			
			//Transacción y compra del producto
			for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {
				
				//Obtención del producto por comprar
				Producto prod = Cuenta.getCatalogo().get(entry.getKey());
				 
				//Llamado al método en clase CuentaBancaria para hacer la transacción del costo
				titular.getCuentaBancaria().Transaccion(prod.getVendedor(), prod.getPrecio() * entry.getValue());
				
				//Agrega al historial del comprador el producto que fue adquirido
				if (!titular.getHistorial().containsKey(entry.getKey())) {
					titular.setHistorial(entry.getKey(), entry.getValue()); 
				}
				else {
					titular.setHistorial(entry.getKey(), titular.getHistorial().get(entry.getKey()) + entry.getValue()); 
				}
			}
			productos.clear();
			totalProductos = 0;
			precioTotal = 0;

			return "Se han comprado los productos. Saldo restante: " + titular.getCuentaBancaria().getSaldo() + ".\n";
		} 
		else {
			// En caso de que no tenga el dinero suficiente para la adquisión de productos
			return "Saldo insuficiente, no se pueden comprar los productos.\n";
		}
	}

	public static String vaciarCarrito() {
	/*
		Propósito: libera el carrito de compras respectivo 		
		
		Variables de salida:
		- String con mensaje confirmando el proceso.
	 */

		for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {

			int cant = entry.getValue(); // Extracción de la cantidad en la hash
			int cod = entry.getKey(); // el codigo del producto
			Producto prod = Cuenta.getCatalogo().get(cod);  //se obtiene el producto correspondiente al codigo 
			prod.setCantidad(prod.getCantidad() + cant); //se asigna la cantidad que estaba al principio
		}
		productos.clear();
		totalProductos = 0;
		precioTotal = 0;
		return "\nEl carrito se vació correctamente.\n";
	}

	public static String quitarProducto(int codigo, int cantidad) {
	/*
		Propósito: Quitar un producto del carrito de compras haciendo las verificaciones
		           necesarias para el proceso
		
		Variables de entrada:
		- int codigo: Código del producto que se desea retirar
		- int cantidad: Cantidad de elementos que desea quitar del respectivo producto	
		
		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
	 */
		
		// Verificación de que el producto se encuentre en el carrito
		if (productos.containsKey(codigo)) {
			// Verificación de que la cantidad de elementos que el usuario desea quitar	corresponda

			if (productos.get(codigo) == cantidad) {
				//Caso A: Se desea eliminar todo el producto

				Cuenta.getCatalogo().get(codigo).setCantidad(Cuenta.getCatalogo().get(codigo).getCantidad() + cantidad); 	//se asigna la cantidad que estaba al principio
				productos.remove(codigo);
				OpcionDeMenu.controlError = true;
				return "El producto ha sido eliminado del carrito\n";
			}
			else if (productos.get(codigo) > cantidad) {
				//Caso B: Se desean eliminar algunas unidades del producto
				productos.put(codigo, productos.get(codigo) - cantidad);
				Cuenta.getCatalogo().get(codigo).setCantidad(Cuenta.getCatalogo().get(codigo).getCantidad() + cantidad);
				totalProductos -= cantidad;
				precioTotal -= Cuenta.getCatalogo().get(codigo).getPrecio() * cantidad;
				OpcionDeMenu.controlError = true;
				if (cantidad == 1) {
					return "Se ha quitado una unidad del producto \"" + Cuenta.getCatalogo().get(codigo).getNombreProducto()
							+ "\" del carrito.\n";
				} else {
					return "Se han quitado " + cantidad + " unidades del producto \"" + Cuenta.getCatalogo().get(codigo).getNombreProducto()
							+ "\" del carrito.\n";
				}
			} 
			else {
				//Caso C: Se ha excedido la cantidad del producto
				return "La cantidad ingresada excede la existente en el carrito.\n";}
		} 
		else {
			return "Este producto no se ha agregado al carrito.\n";
		}
	}
	
	// Cambia el total de productos 
	public static void setTotalproductos(int totalproductos) {
		CarritoDeCompras.totalProductos = totalproductos;
	}
    
	// Cambia el precio total
	public static void setPrecioTotal(double precioTotal) {
		CarritoDeCompras.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "CarritoDeCompras [totalProductos=" + totalProductos + ", precioTotal=" + precioTotal + "]";
	}
}