package com.ipartek.formacion.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBasicaWindowBuilder {

	private JFrame frame;
	private JTextField tfNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBasicaWindowBuilder window = new VentanaBasicaWindowBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaBasicaWindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 114);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNombre = new JLabel("Nombre");
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(20);
		
		JLabel lblResultado = new JLabel("Introduce tu nombre y pulsa en el botón saludar para que te salude");	
		
		JButton btnSaludar = new JButton("Saludar");
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("Hola, " + tfNombre.getText());
			}
		});
		frame.getContentPane().add(btnSaludar);
		
		frame.getContentPane().add(lblResultado);
	}

}
