package gestorAplicación.Usuarios;

import gestorAplicación.Materiales.CuentaBancaria;

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


