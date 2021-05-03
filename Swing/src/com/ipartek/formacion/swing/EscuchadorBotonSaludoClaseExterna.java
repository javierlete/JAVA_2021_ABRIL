package com.ipartek.formacion.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EscuchadorBotonSaludoClaseExterna implements ActionListener {

	private JLabel lSaludo;
	private JTextField tfNombre;
	
	public EscuchadorBotonSaludoClaseExterna(JLabel lSaludo, JTextField tfNombre) {
		super();
		this.lSaludo = lSaludo;
		this.tfNombre = tfNombre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lSaludo.setText("Hola, " + tfNombre.getText());
	}

}
