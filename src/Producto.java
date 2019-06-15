
import java.util.HashMap;

public class Producto {
    //private HashMap <Integer, Rese�a> Rese�a = new HashMap <> ();  -----> pendiente por implementar la clase rese�a
    private Vendedor vendedor;
    private String nombreProducto, categoria;
    private double precio = 0;
    private int cantidad;
    
    public int getCantidad(){return cantidad;}
    
    public Vendedor getVendedor(){return vendedor;}
    
    public double getPrecio(){return precio;}
    
    public void setPrecio(double precio){this.precio = precio;}
    
    public void setCantidad(int cantidad){this.cantidad = cantidad;}
}