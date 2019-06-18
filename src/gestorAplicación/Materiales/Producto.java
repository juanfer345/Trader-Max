package gestorAplicación.Materiales;

import gestorAplicación.Usuarios.Vendedor;
import java.util.HashMap;

public class Producto {
    //private HashMap <Integer, Reseña> Reseña = new HashMap <> ();  -----> pendiente por implementar la clase reseña
    private Vendedor vendedor;
    private String nombreProducto, categoria;
    private double precio;
    private int cantidad;
    
    public int getCantidad(){return cantidad;}
    
    public Vendedor getVendedor(){return vendedor;}
    
    public double getPrecio(){return precio;}
    
    public void setPrecio(double precio){this.precio = precio;}
    
    public void setCantidad(int cantidad){this.cantidad = cantidad;}
}