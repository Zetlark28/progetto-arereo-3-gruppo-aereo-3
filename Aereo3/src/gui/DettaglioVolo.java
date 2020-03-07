package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dataManagment.GestioneVoloDatabase;
import dominio.Volo;

public class DettaglioVolo {
	
	static JPanel esegui(JPanel contentPane, JPanel homePanel, int value, String partenza, String arrivo, Date data, boolean modifica) {
		
		//TODO: Metodo controller per prendere i voli
//		String destinazione=Controller.parserCodiceAereoporto(volo.getDestinazione());
//		String partenza=Controller.parserCodiceAereoporto(volo.getPartenza());

		//List <Volo> listaVoli = GestioneVoloDatabase.getListaVoliAndataORitorno(volo.getDataPartenza(), partenza, destinazione);
		List <Volo> listaVoli = Controller.getListaVoliAndata(data, partenza, arrivo);
		
		Object rows [][] = new Object [listaVoli.size()][5];
		
		String [] columns = {"ID", "Partenza", "Arrivo", "Data Partenza", "Data Arrivo"};
		
		int i = 0;
		
		for(Volo v : listaVoli) {
			rows[i][0] = v.getIdVolo();
			rows[i][1] = v.getPartenza();
			rows[i][2] = v.getDestinazione();
			rows[i][3] = v.getDataPartenza();
			rows[i][4] = v.getDataArrivo();
			i++;
		}
		
		TableModel model = new DefaultTableModel(rows, columns)
		  {
		    public boolean isCellEditable(int row, int columns)
		    {
		      return false;
		    }
		  };
		JTable table = new JTable(model);
		table.setPreferredSize(new Dimension(800, 500));
		
		JPanel panel6 = new JPanel();
		panel6.setBounds(100, 100, 894, 717);
		panel6.setBackground(Color.BLUE);
		contentPane.add(panel6);
		panel6.setLayout(new BorderLayout(0, 0));
	
		
		JPanel panel8 = new JPanel();
		panel8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel8.setBackground(Color.BLUE);
		panel6.add(panel8, BorderLayout.SOUTH);
		panel8.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(homePanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel8.add(btnBack, BorderLayout.WEST);
		
		JComboBox comboBox = new JComboBox();
		for(Volo v : listaVoli) {
			StringBuilder stringa = new StringBuilder();
			stringa.append(v.getIdVolo());
			stringa.append(", Partenza " + v.getDataPartenza());
			stringa.append(", Arrivo " + v.getDataArrivo());
			comboBox.addItem(stringa.toString());
			System.out.println(stringa.toString());
		}
		panel8.add(comboBox, BorderLayout.CENTER);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String v = (String) comboBox.getSelectedItem();
					String[] params = v.split(", ");
					int idVolo = Integer.parseInt(params[0]);
					contentPane.removeAll();
					contentPane.add(ElencoPasseggeri.esegui(contentPane, value, panel6, idVolo, modifica));
					contentPane.repaint();
					contentPane.revalidate();
			}
		});
		btnContinua.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel8.add(btnContinua, BorderLayout.EAST);
		
		JPanel panel9 = new JPanel();
		panel9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel9.setBackground(Color.BLUE);
		panel6.add(panel9, BorderLayout.CENTER);
		panel9.setLayout(new BorderLayout(0, 0));
		
		panel9.add(new JScrollPane(table));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLUE);
		panel9.add(panel, BorderLayout.SOUTH);
		
		JLabel lblSelezionaVolo = new JLabel("Seleziona Volo di Andata:");
		lblSelezionaVolo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSelezionaVolo.setForeground(Color.WHITE);
		panel.add(lblSelezionaVolo);

	return panel6;
	}
}
