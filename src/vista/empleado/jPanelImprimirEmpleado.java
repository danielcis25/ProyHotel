package vista.empleado;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import vista.cliente.jDialogCliente;

import modelo.Cliente;
import modelo.Empleado;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
public class jPanelImprimirEmpleado extends JPanel {
	private JTable table;
	private JTextField txt_NombreEe;
	private ArrayList<Empleado> aux2lstEmpleado;
	/**
	 * Create the panel.
	 */
	public jPanelImprimirEmpleado(ArrayList<Empleado> lstEmpleado) {
		this.aux2lstEmpleado= lstEmpleado;
		lanzar_componentes();
	}
	public void lanzar_componentes(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCargarDatos.setBackground(new Color(51, 204, 255));
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			mostrar_empleado();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
						.addComponent(btnCargarDatos))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 286, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnCargarDatos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
					.addContainerGap())
		);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Direccion", "Telefono",  "Identificacion", "Cargo"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

	}

	public void mostrar_empleado()
	{
		
	
		Object matriz [][] = new Object[this.aux2lstEmpleado.size()][5];
		
		for(int i=0; i<this.aux2lstEmpleado.size() ;i++ ){
			matriz[i][0] = this.aux2lstEmpleado.get(i).getNombre();
			matriz[i][1] = this.aux2lstEmpleado.get(i).getDireccion();
			matriz[i][2] = this.aux2lstEmpleado.get(i).getTelefono();
			matriz[i][3] = this.aux2lstEmpleado.get(i).getIdentificcion();
			matriz[i][4] = this.aux2lstEmpleado.get(i).getCargo();
		
		}
		table.setModel(new DefaultTableModel(
				matriz,
				new String[] {
					"Nombre", "Direccion", "Telefono", "identificacion", "Cargo"
				}
			));
		
}}
