
import java.util.HashMap;

public class Cuenta {
    private CuentaBancaria cuentaUsuario;
    private String nombre, correo;
    private int id, cedula;
    
    public String getNombre(){return nombre;}
    
    public int getCedula(){return cedula;}
    
    public CuentaBancaria getCuenta(){return cuentaUsuario;}
    
    public void setNombre(String nombre){this.nombre = nombre;}
    
    public void setCedula(int cedula){this.cedula = cedula;}
    
    public void setCuenta(CuentaBancaria cuentaUsuario){this.cuentaUsuario = cuentaUsuario;}
}

class Comprador extends Cuenta {
    private HashMap <Integer, Producto> historial = new HashMap <> ();
    
    public void agregarACarrito(Producto producto){
        // pendiente
    }
    
    public void buscarProducto(int codigoProducto){
        
        Producto resultado;
        
        resultado = Vendedor.catalogo.get(codigoProducto);
        
        //rutina de impresión del resultado encontrado
    }
    
    public void buscarCategoria(String categoria){
        //pendiente
    }
    
    public void borrarHistorial(){
        historial.clear();
    }
    
    public void mostrarHistorial(){
        //rutina de impresión
    }
}

class Vendedor extends Cuenta{
    
    public static HashMap <Integer, Producto> catalogo = new HashMap <> ();
}