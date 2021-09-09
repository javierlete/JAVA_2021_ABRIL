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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

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
	private JButton btnInsertar;
	private JPanel panel_1;
	private JButton btnModificar;
	private JButton btnBorrar;
	private DefaultTableModel modelo;

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

		Object[] columnas = { "Id", "Nombre", "Largo", "Ancho", "Alto" };

		modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numFila = table.getSelectedRow();
				System.out.println(numFila);

				Long id = (Long) modelo.getValueAt(numFila, 0);

				System.out.println(id);

				Mueble mueble = dao.obtenerPorId(id);

				System.out.println(mueble);

				tfNombre.setText(mueble.getNombre());
				tfLargo.setText(mueble.getLargo() != null ? mueble.getLargo().toString() : "");
				tfAncho.setText(mueble.getAncho() != null ? mueble.getAncho().toString() : "");
				tfAlto.setText(mueble.getAlto() != null ? mueble.getAlto().toString() : "");

				
			}
		});

		ArrayList<Mueble> datos = (ArrayList<Mueble>) dao.obtenerTodos();

		for (Mueble m : datos) {
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));

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
				
				panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1, "4, 10, fill, fill");
				
						btnInsertar = new JButton("A\u00F1adir");
						panel_1.add(btnInsertar);
						
						btnModificar = new JButton("Modificar");
						btnModificar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int fila = table.getSelectedRow();
								Long id = (Long)table.getValueAt(fila, 0);
								
								String nombre = tfNombre.getText();
								Double largo = Double.parseDouble(tfLargo.getText());
								Double ancho = Double.parseDouble(tfAncho.getText());
								Double alto = Double.parseDouble(tfAlto.getText());
								
								Mueble mueble = new Mueble(id, nombre, largo, ancho, alto);
								
								dao.modificar(mueble);
								
								table.setValueAt(nombre, fila, 1);
								table.setValueAt(largo, fila, 2);
								table.setValueAt(ancho, fila, 3);
								table.setValueAt(alto, fila, 4);
							}
						});
						panel_1.add(btnModificar);
						
						btnBorrar = new JButton("Borrar");
						btnBorrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int fila = table.getSelectedRow();
								Long id = (Long)table.getValueAt(fila, 0);
								
								dao.borrar(id);
								
								modelo.removeRow(fila);
							}
						});
						panel_1.add(btnBorrar);
				btnInsertar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Mueble mueble = new Mueble(null, tfNombre.getText(), Double.parseDouble(tfLargo.getText()),
								Double.parseDouble(tfAncho.getText()), Double.parseDouble(tfAlto.getText()));
						dao.insertar(mueble);

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.addRow(new Object[] { mueble.getId(), mueble.getNombre(), mueble.getLargo(), mueble.getAncho(),
								mueble.getAlto() });
					}
				});
	}

}
