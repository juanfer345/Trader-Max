package uiMain.vista.tabla;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class tablaBotonRenderizador implements TableCellRenderer { 
	
	/*
	 * Propósito: Se encarga de la parte de los botones de las tablas
	 */
	
    @Override 
    public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected, boolean hasFocus, int fila, int columna) {
        JButton boton = (JButton)valor;
        return boton;  
    }
}