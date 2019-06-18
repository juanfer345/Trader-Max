package gestorAplicaci�n.Materiales;

import gestorAplicaci�n.Usuarios.Vendedor;
import java.util.HashMap;

public class Producto {
	
    private HashMap <Integer, Rese�a> Rese�as = new HashMap <> ();
    
    private Vendedor vendedor;
    private String nombreProducto;
    private String categoria;
    private double precio;
    int cantidad;
    
    public int getCantidad(){return cantidad;}
    
    public Vendedor getVendedor(){return vendedor;}
    
    public double getPrecio(){return precio;}
    
    public void setPrecio(double precio){this.precio = precio;}
    
    public void setCantidad(int cantidad){this.cantidad = cantidad;}
    
    public void a�adirRese�a(Rese�a x) {
    	int indice = Rese�as.size(); 
    	Rese�as.put(indice, x);
    }

}