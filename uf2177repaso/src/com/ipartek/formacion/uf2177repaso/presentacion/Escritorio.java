package com.ipartek.formacion.uf2177repaso.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.uf2177repaso.accesodatos.Dao;
import com.ipartek.formacion.uf2177repaso.accesodatos.DaoMueble;
import com.ipartek.formacion.uf2177repaso.entidades.Mueble;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class Escritorio {

	private static Dao<Mueble> dao = new DaoMueble();
	
	private JFrame frame;
	private JTable table;
	private JSplitPane splitPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfNombre;
	private JTextField tfLargo;
	private JTextField tfAncho;
	private JTextField tfAlto;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escritorio window = new Escritorio();
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
	public Escritorio() {
		initialize();
		
		Object[] columnas = {"Id",
                "Nombre",
                "Largo",
                "Ancho",
                "Alto"};
		
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		
		ArrayList<Mueble> datos = (ArrayList<Mueble>)dao.obtenerTodos();
		
		for(Mueble m: datos) {
			modelo.addRow(new Object[] { m.getId(), m.getNombre(), m.getLargo(), m.getAncho(), m.getAlto() });
		}
		
		splitPane.setLeftComponent(new JScrollPane(table));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		lblNewLabel = new JLabel("Nombre");
		panel.add(lblNewLabel, "2, 2, right, default");
		
		tfNombre = new JTextField();
		panel.add(tfNombre, "4, 2, fill, default");
		tfNombre.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Largo");
		panel.add(lblNewLabel_1, "2, 4, right, default");
		
		tfLargo = new JTextField();
		panel.add(tfLargo, "4, 4, fill, default");
		tfLargo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Ancho");
		panel.add(lblNewLabel_2, "2, 6, right, default");
		
		tfAncho = new JTextField();
		panel.add(tfAncho, "4, 6, fill, default");
		tfAncho.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Alto");
		panel.add(lblNewLabel_3, "2, 8, right, default");
		
		tfAlto = new JTextField();
		panel.add(tfAlto, "4, 8, fill, default");
		tfAlto.setColumns(10);
		
		btnAceptar = new JButton("A\u00F1adir");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mueble mueble = new Mueble(null, tfNombre.getText(), Double.parseDouble(tfLargo.getText()), Double.parseDouble(tfAncho.getText()), Double.parseDouble(tfAlto.getText()));
				dao.insertar(mueble);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { mueble.getId(), mueble.getNombre(), mueble.getLargo(), mueble.getAncho(), mueble.getAlto()});
			}
		});
		panel.add(btnAceptar, "4, 10");
	}

}
