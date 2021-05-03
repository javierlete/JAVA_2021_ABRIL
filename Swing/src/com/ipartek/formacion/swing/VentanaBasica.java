package com.ipartek.formacion.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaBasica {
	private static JLabel lSaludo;
	private static JTextField tfNombre;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Ventana básica");
		frame.setBounds(2000, 0, 500, 200);

		Container contenedor = frame.getContentPane();

		contenedor.setLayout(new FlowLayout());

		JLabel label = new JLabel("Nombre");
		contenedor.add(label);

		tfNombre = new JTextField(20);
		contenedor.add(tfNombre);

		JButton btnSaludar = new JButton("Saludar");
		contenedor.add(btnSaludar);

		lSaludo = new JLabel("Introduce tu nombre y pulsa el botón saludar para que te salude");
		contenedor.add(lSaludo);

//		Java 1.0
//		ActionListener al = new EscuchadorBotonSaludoClaseExterna(lSaludo, tfNombre);

//		Java 1.1
//		ActionListener al = new EscuchadorBotonSaludoClaseInterna();
//		btnSaludar.addActionListener(al);

//		Java 1.1
//		btnSaludar.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				lSaludo.setText("Hola, " + tfNombre.getText());
//			}
//		});

//		Java 8
		btnSaludar.addActionListener((e) -> {
			lSaludo.setText("Hola, " + tfNombre.getText());
		});

		frame.setVisible(true);
	}

	static class EscuchadorBotonSaludoClaseInterna implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			lSaludo.setText("Hola, " + tfNombre.getText());
		}

	}

}
