package uiMain.vista.tabla;

import javax.swing.table.AbstractTableModel;

public class tablaModelo extends AbstractTableModel {
	
	/*
	 * Propósito: Modelo básico de la tabla usada
	 */
	
    private static final long serialVersionUID = 1L;
    private final String[] nombreColumnas;
    private Object[][] datos;
    
    public tablaModelo(String[] columnNames, Object[][] data){
    	this.nombreColumnas = columnNames;
    	this.datos = data;
    }
    
    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public String getColumnName(int indiceColumna) {
        return nombreColumnas[indiceColumna];
    }
    
    @Override
    public Object getValueAt(int indiceFila, int indiceColumna) {
    	return  datos[indiceFila][indiceColumna];
    }   
}