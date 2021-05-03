package com.ipartek.formacion.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebasWindowBuilder {

	private JFrame frame;
	private final ButtonGroup color = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebasWindowBuilder window = new PruebasWindowBuilder();
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
	public PruebasWindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 479, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(comboBox, comboBox.getSelectedItem());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Uno", "Dos", "Tres", "Cuatro"}));
		comboBox.setBounds(30, 29, 120, 22);
		frame.getContentPane().add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(157, 29, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(157, 55, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(61, 101, 304, 114);
		frame.getContentPane().add(textArea);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Uno", "Dos", "Tres", "Cuatro"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(61, 237, 114, 104);
		frame.getContentPane().add(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(208, 237, 202, 188);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnRojo = new JRadioButton("rojo");
		color.add(rdbtnRojo);
		rdbtnRojo.setBounds(40, 26, 109, 23);
		panel.add(rdbtnRojo);
		
		JRadioButton rdbtnVerde = new JRadioButton("verde");
		color.add(rdbtnVerde);
		rdbtnVerde.setBounds(40, 73, 109, 23);
		panel.add(rdbtnVerde);
	}
}
