package uiMain.vista.Cuenta.Comprador;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import control.Cuenta.Comprador.ControlAgregarResena;
import control.Cuenta.Comprador.ControlMostrarCarrito;
import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Comprador;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaBotonRenderizador;
import uiMain.vista.tabla.tablaModelo;

public class tablaHistorial extends JPanel {
	
	JTable table;
	public tablaHistorial(){
		Comprador auxComp = (Comprador)InicializacionAplicacion.usuarioActivo;
		HashMap<Integer, Integer> historial = auxComp.getHistorial();	
	String nombreBoton = "Agregar reseña";
	String [] nombreColumnas = {"Nombre", "Precio","Cantidad","Subtotal", nombreBoton};
	Object [][] datos = new Object [historial.size()][nombreColumnas.length];
	int contador = 0;
	for(Map.Entry<Integer, Integer> entry : historial.entrySet()) {
		Producto prod= Cuenta.getCatalogo().get(entry.getKey()); 
		int cantidad = entry.getValue();
		
		JButton boton = new JButton(nombreBoton);
		boton.setActionCommand(String.valueOf(entry.getKey()));
		boton.addActionListener(new ControlAgregarResena());
		
		datos[contador][0]= prod.getNombreProducto();
		datos[contador][1]= prod.getPrecio();
		datos[contador][2]= cantidad;
		datos[contador][3]= cantidad*prod.getPrecio();
		datos[contador][4]= boton;
		contador++;
	}
	
	table = new JTable(new tablaModelo(nombreColumnas,datos)); 
	table.setFillsViewportHeight(true);
	TableCellRenderer buttonRenderer = new tablaBotonRenderizador();
    table.getColumn(nombreBoton).setCellRenderer(buttonRenderer);
    table.addMouseListener(new tablaBotonOidorMouse(table));
    this.setPreferredSize(new Dimension(500, 300));
	JScrollPane scrollPane = new JScrollPane(table);
	add(scrollPane);
	}
	
}
