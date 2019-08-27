package uiMain.vista.Cuenta.Vendedor;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaBotonRenderizador;
import uiMain.vista.tabla.tablaModelo;

public class PanelVerProductos extends JPanel {
	Vendedor usuario = (Vendedor) InicializacionAplicacion.usuarioActivo;
	JTable table;
	public PanelVerProductos(){
		HashMap<Integer, Producto> productos = usuario.verProductos();
		String nombreBoton = "Ordenar";
		String [] nombreColumnas = {"Codigo", "Nombre","Categoría", "Precio", "N°Reseñas",nombreBoton};
		Object [][] datos = new Object [productos.size()][nombreColumnas.length];
		int contador = 0;
		for(Map.Entry<Integer, Producto> producto : productos.entrySet()) {
			Producto item = producto.getValue();
			String ac =String.valueOf(item.getId());
			//botones
			/*
			JButton boton = new JButton(nombreBoton);
			boton.setActionCommand(ac);
			boton.addActionListener(new ControlVerProductos());
			*/
			datos[contador][0]= item.getId();//codigo
			datos[contador][1]= item.getNombreProducto();//nombre
			datos[contador][2]= item.getCategoria();//categoria
			datos[contador][3]= item.getPrecio();
			datos[contador][4]= item.getResenas().size();
			//aca van los botones
			//datos[contador][3]= boton;
			contador++;
		}
		table = new JTable(new tablaModelo(nombreColumnas,datos)); 
		table.setFillsViewportHeight(true);
		TableCellRenderer buttonRenderer = new tablaBotonRenderizador();
	    table.getColumn(nombreBoton).setCellRenderer(buttonRenderer);
	    table.addMouseListener(new tablaBotonOidorMouse(table));
	    
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

	}
}
