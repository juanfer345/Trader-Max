package uiMain.vista.Visitante;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.vista.tabla.tablaModelo;

public class PanelCatalogo extends JFrame {
	Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
	JTable table;
	public PanelCatalogo(){
		HashMap<Integer, Producto> Catalogo = usuario.getCatalogo();
		String [] nombreColumnas = {"Codigo", "Nombre","Categoría", "Precio", "N°Reseñas","Vendedor"};
		Object [][] datos = new Object [Catalogo.size()][nombreColumnas.length];
		int contador = 0;
		for(Map.Entry<Integer, Producto> producto : Catalogo.entrySet()) {
			Producto item = producto.getValue();
			datos[contador][0]= item.getId();//codigo
			datos[contador][1]= item.getNombreProducto();//nombre
			datos[contador][2]= item.getCategoria();//categoria
			datos[contador][3]= item.getPrecio();
			datos[contador][4]= item.getResenas().size();
			datos[contador][5]= item.getVendedor().getNombre();
			contador++;
		}
		table = new JTable(new tablaModelo(nombreColumnas,datos)); 
		table.setFillsViewportHeight(true);
	    table.addMouseListener(new tablaBotonOidorMouse(table));
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		this.setMinimumSize(new Dimension(1000, 300)); 

	}
	public void lanzar() {
		this.setTitle("Catálogo");
		getDefaultCloseOperation();
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true); 
	}
}
