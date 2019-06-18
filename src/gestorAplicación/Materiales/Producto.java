package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.Vendedor;
import java.util.HashMap;

public class Producto {
	
    private HashMap <Integer, Reseña> Reseñas = new HashMap <> ();
    
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
    
    public void añadirReseña(Reseña x) {
    	int indice = Reseñas.size(); 
    	Reseñas.put(indice, x);
    }

}