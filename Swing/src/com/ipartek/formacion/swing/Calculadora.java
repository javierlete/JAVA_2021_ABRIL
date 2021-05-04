package com.ipartek.formacion.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora {

	private static final Font TIPO_LETRA = new Font("Tahoma", Font.BOLD, 20);
	private JFrame frame;
	private JTextField tfPantalla;
	private JPanel pNumeros;
	
	protected double op1;
	protected char op;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			JOptionPane.showMessageDialog(frame, "No se ha encontrado el aspecto");
			e1.printStackTrace();
		}

		initialize();

		String[] etiquetas = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "CE", "0", "." };

		JButton boton;

		for (String etiqueta : etiquetas) {
			boton = new JButton(etiqueta);
			boton.setFont(TIPO_LETRA);
			pNumeros.add(boton);

			boton.addActionListener((e) -> {
				JButton botonPulsado = (JButton) e.getSource();
				// JOptionPane.showMessageDialog(frame, botonPulsado.getText());

				String texto = botonPulsado.getText();

				if ("CE".equals(texto)) {
					tfPantalla.setText("");
				} else {
					tfPantalla.setText(tfPantalla.getText() + texto);
				}
			});
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tfPantalla = new JTextField();

		tfPantalla.setFont(TIPO_LETRA);

		tfPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(tfPantalla, BorderLayout.NORTH);
		tfPantalla.setColumns(10);

		JPanel pOperaciones = new JPanel();
		frame.getContentPane().add(pOperaciones, BorderLayout.EAST);
		pOperaciones.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnEntre = new JButton("/");
		btnEntre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Double.parseDouble(tfPantalla.getText());
				op = '/';
				tfPantalla.setText("");
			}
		});
		btnEntre.setFont(TIPO_LETRA);
		pOperaciones.add(btnEntre);

		JButton btnPor = new JButton("x");
		btnPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Double.parseDouble(tfPantalla.getText());
				op = 'x';
				tfPantalla.setText("");
			}
		});
		btnPor.setFont(TIPO_LETRA);
		pOperaciones.add(btnPor);

		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Double.parseDouble(tfPantalla.getText());
				op = '-';
				tfPantalla.setText("");
			}
		});
		btnMenos.setFont(TIPO_LETRA);
		pOperaciones.add(btnMenos);

		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = Double.parseDouble(tfPantalla.getText());
				op = '+';
				tfPantalla.setText("");
			}
		});
		btnMas.setFont(TIPO_LETRA);
		pOperaciones.add(btnMas);

		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double resultado = 0.0, op2 = Double.parseDouble(tfPantalla.getText());
				
				switch(op) {
				case '+': resultado = op1 + op2; break;
				case '-': resultado = op1 - op2; break;
				case 'x': resultado = op1 * op2; break;
				case '/': resultado = op1 / op2; break;
				}
				
				tfPantalla.setText(String.valueOf(resultado));
			}
		});
		btnIgual.setFont(TIPO_LETRA);
		pOperaciones.add(btnIgual);

		pNumeros = new JPanel();
		frame.getContentPane().add(pNumeros, BorderLayout.CENTER);
		pNumeros.setLayout(new GridLayout(4, 3, 0, 0));
	}

}
