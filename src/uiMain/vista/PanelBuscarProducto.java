 package uiMain.vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.ControlBuscarProducto;


public class PanelBuscarProducto extends JFrame {
	public JRadioButton codigo,nombre;
	public String opcion;
	public ButtonGroup opciones;
	public JButton BotonBuscar,BotonCancelar;
	public JTextField texto;
	
	public PanelBuscarProducto() {
		JPanel PanelGeneral = new JPanel();
		JPanel PanelBotones = new JPanel();
        setLayout(new GridLayout());
        PanelGeneral.setLayout(new GridLayout());
        PanelBotones.setLayout(new FlowLayout());
        add(PanelGeneral);
        add(PanelBotones);
        opciones=new ButtonGroup();
        codigo=new JRadioButton("Buscar por código");
        codigo.setBounds(10,20,100,30);
        PanelGeneral.add(codigo);
        opciones.add(codigo);
        nombre=new JRadioButton("Buscar por nombre");
        nombre.setBounds(10,70,100,30);     
        PanelGeneral.add(nombre);
        opciones.add(nombre);
        texto = new JTextField();
        PanelGeneral.add(texto);
        texto.setBounds(120,10,150,20);
        BotonBuscar = new JButton("Buscar");
        PanelBotones.add(BotonBuscar);
        BotonBuscar.addActionListener((ActionListener) this);
    }
	
	public void asignarOyente() {
		ControlBuscarProducto oidor = new ControlBuscarProducto();
		codigo.addChangeListener((ChangeListener) oidor);
	    nombre.addChangeListener((ChangeListener) oidor);
	    BotonBuscar.addActionListener((ActionListener) oidor);}
	

}
