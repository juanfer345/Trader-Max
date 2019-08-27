package control.tabla;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;

public class tablaBotonOidorMouse extends MouseAdapter {
    private final JTable tabla;

    public tablaBotonOidorMouse(JTable tabla) {
        this.tabla = tabla;
    }

    public void mouseClicked(MouseEvent e) {
        int columna = tabla.getColumnModel().getColumnIndexAtX(e.getX());
        int fila    = e.getY()/tabla.getRowHeight();

        /*Checking the row or column is valid or not*/
        if (fila < tabla.getRowCount() && fila >= 0 && columna < tabla.getColumnCount() && columna >= 0) {
            Object valor = tabla.getValueAt(fila, columna);
            if (valor instanceof JButton) {
                ((JButton)valor).doClick();
            }
        }
    }
}
