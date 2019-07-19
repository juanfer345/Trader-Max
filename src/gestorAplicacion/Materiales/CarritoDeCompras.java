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
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Vendedor;

public class CarritoDeCompras {

	private int id;
	private int totalProductos;
	private double precioTotal;
	private Comprador titular;
	private HashMap<Integer, Integer> productos;
	private static int contador;

	public CarritoDeCompras(int id, int totalProductos, double precioTotal) {
	/*
		Propósito: Constructor para carritos existentes 		
		           
		Variables de entrada:
		- int id: Identificación del carrito
		- int totalProductos: Número que se asigna para el total de productos
		- double precioTotal: Precio asignado al costo total del carrito
    */
		this.id = id;
		this.totalProductos = totalProductos;
		this.precioTotal = precioTotal;
	}

	public CarritoDeCompras(Comprador comp) {
	/*
		Propósito: Constructor para carritos nuevos
		           
		Variables de entrada:
		- Comprador comp: Recibe un comprador el cual se le asigna como titular.
    */
		id = contador++;
		titular = comp;
		productos = new HashMap<>();
	}

	// Devuelve el HashMap con los productos del carrito
	public HashMap<Integer, Integer> getProductos() {
		return productos;
	}
	
    // Permite cambiar la cantidad de un producto del carrito
	public void setProductos(int codigo, int cantidad) {
		productos.put(codigo, cantidad);
	}
	
   // Cambia los datos del carrito
	public void setProductos(Deque<Integer> idCantidadProd) {
		productos = new HashMap<>();
		while (!idCantidadProd.isEmpty()) {
			productos.put(idCantidadProd.poll(), idCantidadProd.poll());
		}
	}
	
   // Cambia el titular del carrito
	public void setComprador(Comprador titular) {
		this.titular = titular;
	}

	// Devuelve el total de productos que tiene el carrito
	public int getTotalproductos() {
		return totalProductos;
	}
	
    // Devuelve el costo total actual del carrito
	public double getPrecioTotal() {
		return precioTotal;
	}

	// Cambia el contador del carrito
	public static void setMaxID(int contador) {
		CarritoDeCompras.contador = contador + 1;
	}

	public String comprarProductos() {
	/*
		Propósito: Realizar la compra de los productos disponibles en el carrito 
		           haciendo la respectiva transacción de dinero de la cuenta del
		           comprador al vendedor   		
		           
		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
    */
	
		double total = 0;
		//Búsqueda de productos en el catálogo, obtención de precio total
		for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {
			int codigo = entry.getKey();
			int cantidad = entry.getValue();
			Producto p = Vendedor.catalogo.get(codigo);
			setPrecioTotal(getPrecioTotal() + (p.getPrecio() * cantidad));
		}
		total = getPrecioTotal();

		if (titular.getCuentaBancaria().getSaldo() >= total) {
			// Transacción y compra del producto 
			for (Map.Entry<Integer, Integer> entry : productos.entrySet()) {
				int codigo = entry.getKey();
				int cantidad = entry.getValue();
				Producto p = Vendedor.catalogo.get(codigo);
				double precio = p.getPrecio() * cantidad;
				CuentaBancaria c = titular.getCuentaBancaria();
				CuentaBancaria v = p.getVendedor().getCuentaBancaria();
				//Llamado al método en clase CuentaBancaria para hacer la transacción del costo
				c.Transaccion(c, v, precio);
				p.setCantidad(p.getCantidad() - cantidad); //Cambio del atributo de cantidad del respectivo producto
				titular.getHistorial().put(codigo, p); //Agrega al historial del comprador el producto que adquirió
			}
			productos.clear();
			totalProductos = 0;
			setPrecioTotal(0);

			return "Se han comprado los productos. Saldo restante: " + titular.getCuentaBancaria().getSaldo();

		} else {
			// En caso de que no tenga el dinero suficiente para la adquisión de productos
			return "Saldo insuficiente, no se pueden comprar los productos";
		}
	}

	public String vaciarCarrito() {
	/*
		Propósito: libera el carrito de compras respectivo 		
		
		Variables de salida:
		- String con mensaje confirmando el proceso.
    */
		productos.clear();
		totalProductos = 0;
		setPrecioTotal(0);
		return "Su carrito ya está vacío";
	}


	public String quitarProducto(int codigo, int cantidad) {
	/*
		Propósito: Quitar un producto del carrito de compras haciendo las verificaciones
		           necesarias para el proceso
		
		Variables de entrada:
		- int codigo: Código del producto que se desea retirar
		- int cantidad: Cantidad de elementos que desea quitar del respectivo producto	
		
		Variables de salida:
		- String con mensaje dependiendo si el proceso fue o no exitoso.
    */
		
		if (cantidad > 0 && codigo > 0) { 
			if (productos.containsKey(codigo)) { // Verifica que si este en el carrito
				if (productos.get(codigo) >= cantidad) { 
					// Mira si hay la cantidad de elementos que el usuario desea quitar
					productos.put(codigo, productos.get(codigo) - cantidad);
					if (cantidad == 1) {
						return "Se ha quitado el producto " + Vendedor.catalogo.get(codigo).getNombreProducto()
								+ " del carrito";
					} else {
						return "Se han quitado " + cantidad + " " + Vendedor.catalogo.get(codigo).getNombreProducto()
								+ " del carrito";
					}
				} else {
					return "La cantidad ingresada excede la existente";
				}
			} else {
				return "El producto no está en el carrito";
			}
		} else {
			return "Tanto la cantidad como el codigo ingresado deben ser mayor a cero";
		}
	}
    // Retorno del id del carrito
	public int getId() {
		return id;
	}

	// Cambio del id del carrito
	public void setId(int id) {
		this.id = id;
	}
	
	// Cambia el total de productos 
	public void setTotalproductos(int totalproductos) {
		this.totalProductos = totalproductos;
	}
    
	// Cambia el precio total
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "CarritoDeCompras [totalProductos=" + totalProductos + ", precioTotal=" + precioTotal + "]";
	}
}