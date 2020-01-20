package PanelesYVentanas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import GmailYBd.BaseDeDatos;

/** Clase de tabla de puntuaciones (No funciona)
 * @author iCarr
 *
 */
public class FramePuntuaciones extends JFrame{

	private JScrollPane js;
	private ArrayList<String> nicks;
	private ArrayList<Double> puntuaciones;
	
	/**
	 * Constructor principal
	 */
	public FramePuntuaciones() {
		
		
		int posMax = 0;
		double aux = 0.0;
		
		String CabecerasTabla[] = {"Posicion:", "Nick", "Puntuacion"};
		
		this.setSize(Constantes.FRAME_ANCHO/5, Constantes.FRAME_ALTO/2);
		this.setResizable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setName("Tabla de Puntuaciones");
		
		nicks = BaseDeDatos.getNicks();
		puntuaciones = BaseDeDatos.getPuntuaciones();
		
		DefaultTableModel jt = new DefaultTableModel();
		
		jt.addRow(CabecerasTabla);
		
		
		for (int i = 0; i< puntuaciones.size(); i++) {
			Object[] fila = new Object[3];
			fila[0] = new Integer(i);
			fila[1] = nicks.get(i);
			fila[2] = puntuaciones.get(i);
			jt.addRow(fila);
		}
		JTable table = new JTable(jt);
		
		TableRowSorter<TableModel> ordena = new TableRowSorter<>(jt);
		table.setRowSorter(ordena);
		
		js = new JScrollPane(table);
		this.add(js);
		this.setVisible(true);
	}
	
}
