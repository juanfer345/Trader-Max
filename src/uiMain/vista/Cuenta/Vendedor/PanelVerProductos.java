package uiMain.vista.Cuenta.Vendedor;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import control.Cuenta.Vendedor.ControlCambiarPrecio;
import control.Cuenta.Vendedor.ControlEliminarProdCatalogo;
import control.Cuenta.Vendedor.ControlModificarCantidad;
import control.Cuenta.Vendedor.ControlVerProductos;
import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaBotonRenderizador;
import uiMain.vista.tabla.tablaModelo;

public class PanelVerProductos extends JFrame {
	Vendedor usuario = (Vendedor) InicializacionAplicacion.usuarioActivo;
	JTable table;
	public PanelVerProductos(){
		HashMap<Integer, Producto> productos = usuario.verProductos();
		String nombreBoton1 = "Cambiar precio";
		String nombreBoton2 = "Cambiar cantidad";
		String nombreBoton3 = "Eliminar";
		String [] nombreColumnas = {"Codigo", "Nombre","Categoría", "Precio", "N°Reseñas",nombreBoton1,nombreBoton2,nombreBoton3};
		Object [][] datos = new Object [productos.size()][nombreColumnas.length];
		int contador = 0;
		for(Map.Entry<Integer, Producto> producto : productos.entrySet()) {
			Producto item = producto.getValue();
			String ac =String.valueOf(item.getId());
			
			//botones cambiar precio, eliminar
			JButton boton1 = new JButton(nombreBoton1);
			boton1.setActionCommand(ac);
			boton1.addActionListener(new ControlCambiarPrecio());
			JButton boton2 = new JButton(nombreBoton2);
			boton2.setActionCommand(ac);
			boton2.addActionListener(new ControlModificarCantidad());
			JButton boton3 = new JButton(nombreBoton3);
			boton3.setActionCommand(ac);
			boton3.addActionListener(new ControlEliminarProdCatalogo());
			
			datos[contador][0]= item.getId();//codigo
			datos[contador][1]= item.getNombreProducto();//nombre
			datos[contador][2]= item.getCategoria();//categoria
			datos[contador][3]= item.getPrecio();
			datos[contador][4]= item.getResenas().size();
			datos[contador][5]= boton1;
			datos[contador][6]= boton2;
			datos[contador][7]= boton3;
			//aca van los botones
			//
			contador++;
		}
		table = new JTable(new tablaModelo(nombreColumnas,datos)); 
		table.setFillsViewportHeight(true);
		TableCellRenderer buttonRenderer = new tablaBotonRenderizador();
	    table.getColumn(nombreBoton1).setCellRenderer(buttonRenderer);
	    table.getColumn(nombreBoton2).setCellRenderer(buttonRenderer);
	    table.getColumn(nombreBoton3).setCellRenderer(buttonRenderer);
	    table.addMouseListener(new tablaBotonOidorMouse(table));
	    
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		this.setMinimumSize(new Dimension(1000, 300)); 

	}
	public void lanzar() {
		this.setTitle("Catálogo productos vendedor no.2");
		getDefaultCloseOperation();
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true); 
	}
}
