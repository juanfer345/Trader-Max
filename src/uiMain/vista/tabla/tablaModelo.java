package uiMain.vista.tabla;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class tablaModelo extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final String[] columnNames;
    private Object[][] data;
    
    public tablaModelo(String[] columnNames, Object[][] data){
    	this.columnNames = columnNames;
    	this.data = data;
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	return  data[rowIndex][columnIndex];
    }   
}