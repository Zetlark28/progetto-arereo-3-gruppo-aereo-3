package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.Controller;
import dataManagement.GestioneClienteDatabase;
import dataManagement.GestioneVoloDatabase;
import dominio.Cliente;
import dominio.ClienteFedele;
import dominio.Prenotazione;
import dominio.Volo;

public class AreaUtente {
	static JPanel esegui(JPanel contentPane, JPanel homePanel, ClienteFedele c) {
		JPanel areaUtente = new JPanel ();
		areaUtente.setBackground(Color.BLUE);
		contentPane.add(areaUtente, "name_864878817126900");
		areaUtente.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(Color.BLUE);
		areaUtente.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.BLUE);
		areaUtente.add(menu, BorderLayout.WEST);
		GridBagLayout gblMenu = new GridBagLayout();
		gblMenu.columnWidths = new int[]{0, 0};
		gblMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblMenu.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gblMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		menu.setLayout(gblMenu);
		
		Component verticalStrut7 = Box.createVerticalStrut(20);
		GridBagConstraints gbcVerticalStrut7 = new GridBagConstraints();
		gbcVerticalStrut7.insets = new Insets(0, 0, 5, 0);
		gbcVerticalStrut7.gridx = 0;
		gbcVerticalStrut7.gridy = 1;
		menu.add(verticalStrut7, gbcVerticalStrut7);
		
		JButton btnDatiPersonali = new JButton("Dati Personali");
		btnDatiPersonali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				JPanel datiPersonali = new JPanel();
				datiPersonali.setBackground(Color.BLUE);
				panel.add(datiPersonali, "name_865661938656900");
				GridBagLayout gblDatiPersonali = new GridBagLayout();
				gblDatiPersonali.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gblDatiPersonali.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gblDatiPersonali.columnWeights = new double[]{0.0, 0.0, 0.0,0.0,0.0,0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gblDatiPersonali.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				datiPersonali.setLayout(gblDatiPersonali);
				
				Component verticalStrut10 = Box.createVerticalStrut(20);
				GridBagConstraints gbcVerticalStrut10 = new GridBagConstraints();
				gbcVerticalStrut10.insets = new Insets(0, 0, 5, 0);
				gbcVerticalStrut10.gridx = 1;
				gbcVerticalStrut10.gridy = 0;
				datiPersonali.add(verticalStrut10, gbcVerticalStrut10);
				
				Component horizontalStrut = Box.createHorizontalStrut(20);
				GridBagConstraints gbcHorizontalStrut = new GridBagConstraints();
				gbcHorizontalStrut.insets = new Insets(0, 0, 5, 5);
				gbcHorizontalStrut.gridx = 0;
				gbcHorizontalStrut.gridy = 1;
				datiPersonali.add(horizontalStrut, gbcHorizontalStrut);
				
				JLabel lblNome = new JLabel("Nome:");
				lblNome.setForeground(Color.WHITE);
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblNome = new GridBagConstraints();
				gbcLblNome.insets = new Insets(0, 0, 5, 0);
				gbcLblNome.anchor = GridBagConstraints.NORTHWEST;
				gbcLblNome.gridx = 1;
				gbcLblNome.gridy = 1;
				datiPersonali.add(lblNome, gbcLblNome);
				
				JLabel lblNomeCliente = new JLabel(c.getNome());
				lblNomeCliente.setForeground(Color.WHITE);
				lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblNomeCliente = new GridBagConstraints();
				gbcLblNomeCliente.insets = new Insets(0, 0, 5, 0);
				gbcLblNomeCliente.anchor = GridBagConstraints.NORTHWEST;
				gbcLblNomeCliente.gridx = 3;
				gbcLblNomeCliente.gridy = 1;
				datiPersonali.add(lblNomeCliente, gbcLblNomeCliente);
				
				Component verticalStrut11 = Box.createVerticalStrut(20);
				GridBagConstraints gbcVerticalStrut11 = new GridBagConstraints();
				gbcVerticalStrut11.insets = new Insets(0, 0, 5, 0);
				gbcVerticalStrut11.gridx = 1;
				gbcVerticalStrut11.gridy = 2;
				datiPersonali.add(verticalStrut11, gbcVerticalStrut11);
				
				Component horizontalStrut1 = Box.createHorizontalStrut(20);
				GridBagConstraints gbcHorizontalStrut1 = new GridBagConstraints();
				gbcHorizontalStrut1.insets = new Insets(0, 0, 5, 5);
				gbcHorizontalStrut1.gridx = 0;
				gbcHorizontalStrut1.gridy = 3;
				datiPersonali.add(horizontalStrut1, gbcHorizontalStrut1);
				
				JLabel lblCognome = new JLabel("Cognome:");
				lblCognome.setForeground(Color.WHITE);
				lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblCognome = new GridBagConstraints();
				gbcLblCognome.insets = new Insets(0, 0, 5, 0);
				gbcLblCognome.anchor = GridBagConstraints.NORTHWEST;
				gbcLblCognome.gridx = 1;
				gbcLblCognome.gridy = 3;
				datiPersonali.add(lblCognome, gbcLblCognome);
				
				JLabel lblCognomeCliente = new JLabel(c.getCognome());
				lblCognomeCliente.setForeground(Color.WHITE);
				lblCognomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblCognomeCliente = new GridBagConstraints();
				gbcLblCognomeCliente.insets = new Insets(0, 0, 5, 0);
				gbcLblCognomeCliente.anchor = GridBagConstraints.NORTHWEST;
				gbcLblCognomeCliente.gridx = 3;
				gbcLblCognomeCliente.gridy = 3;
				datiPersonali.add(lblCognomeCliente, gbcLblCognomeCliente);
				
				Component verticalStrut12 = Box.createVerticalStrut(20);
				GridBagConstraints gbcVerticalStrut12 = new GridBagConstraints();
				gbcVerticalStrut12.insets = new Insets(0, 0, 5, 0);
				gbcVerticalStrut12.gridx = 1;
				gbcVerticalStrut12.gridy = 4;
				datiPersonali.add(verticalStrut12, gbcVerticalStrut12);
				
				Component horizontalStrut2 = Box.createHorizontalStrut(20);
				GridBagConstraints gbcHorizontalStrut2 = new GridBagConstraints();
				gbcHorizontalStrut2.insets = new Insets(0, 0, 5, 5);
				gbcHorizontalStrut2.gridx = 0;
				gbcHorizontalStrut2.gridy = 5;
				datiPersonali.add(horizontalStrut2, gbcHorizontalStrut2);
				
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setForeground(Color.WHITE);
				lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblEmail = new GridBagConstraints();
				gbcLblEmail.insets = new Insets(0, 0, 5, 0);
				gbcLblEmail.anchor = GridBagConstraints.NORTHWEST;
				gbcLblEmail.gridx = 1;
				gbcLblEmail.gridy = 5;
				datiPersonali.add(lblEmail, gbcLblEmail);
				
				JLabel lblEmailCliente = new JLabel(c.getEmail());
				lblEmailCliente.setForeground(Color.WHITE);
				lblEmailCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblEmailCliente = new GridBagConstraints();
				gbcLblEmailCliente.insets = new Insets(0, 0, 5, 0);
				gbcLblEmailCliente.anchor = GridBagConstraints.NORTHWEST;
				gbcLblEmailCliente.gridx = 3;
				gbcLblEmailCliente.gridy = 5;
				datiPersonali.add(lblEmailCliente, gbcLblEmailCliente);
				
				Component verticalStrut13 = Box.createVerticalStrut(20);
				GridBagConstraints gbcVerticalStrut13 = new GridBagConstraints();
				gbcVerticalStrut13.insets = new Insets(0, 0, 5, 0);
				gbcVerticalStrut13.gridx = 1;
				gbcVerticalStrut13.gridy = 6;
				datiPersonali.add(verticalStrut13, gbcVerticalStrut13);
				
				Component horizontalStrut3 = Box.createHorizontalStrut(20);
				GridBagConstraints gbcHorizontalStrut3 = new GridBagConstraints();
				gbcHorizontalStrut3.insets = new Insets(0, 0, 5, 5);
				gbcHorizontalStrut3.gridx = 0;
				gbcHorizontalStrut3.gridy = 7;
				datiPersonali.add(horizontalStrut3, gbcHorizontalStrut3);
				
				JLabel lblIndirizzo = new JLabel("Indirizzo:");
				lblIndirizzo.setForeground(Color.WHITE);
				lblIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblIndirizzo = new GridBagConstraints();
				gbcLblIndirizzo.insets = new Insets(0, 0, 5, 0);
				gbcLblIndirizzo.anchor = GridBagConstraints.NORTHWEST;
				gbcLblIndirizzo.gridx = 1;
				gbcLblIndirizzo.gridy = 7;
				datiPersonali.add(lblIndirizzo, gbcLblIndirizzo);
				
				JLabel lblIndirizzoCliente = new JLabel(c.getIndirizzo());
				lblIndirizzoCliente.setForeground(Color.WHITE);
				lblIndirizzoCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
				GridBagConstraints gbcLblIndirizzoCliente = new GridBagConstraints();
				gbcLblIndirizzoCliente.insets = new Insets(0, 0, 5, 0);
				gbcLblIndirizzoCliente.anchor = GridBagConstraints.NORTHWEST;
				gbcLblIndirizzoCliente.gridx = 3;
				gbcLblIndirizzoCliente.gridy = 7;
				datiPersonali.add(lblIndirizzoCliente, gbcLblIndirizzoCliente);
				
				Component verticalStrut14 = Box.createVerticalStrut(20);
				GridBagConstraints gbcVerticalStrut14 = new GridBagConstraints();
				gbcVerticalStrut14.insets = new Insets(0, 0, 5, 0);
				gbcVerticalStrut14.gridx = 1;
				gbcVerticalStrut14.gridy = 8;
				datiPersonali.add(verticalStrut14, gbcVerticalStrut14);
				
				Component horizontalStrut4 = Box.createHorizontalStrut(20);
				GridBagConstraints gbcHorizontalStrut4 = new GridBagConstraints();
				gbcHorizontalStrut4.insets = new Insets(0, 0, 0, 5);
				gbcHorizontalStrut4.gridx = 0;
				gbcHorizontalStrut4.gridy = 9;
				datiPersonali.add(horizontalStrut4, gbcHorizontalStrut4);
				
				JLabel lblPassword = new JLabel("Password:");
				lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 28));
				lblPassword.setForeground(Color.WHITE);
				GridBagConstraints gbcLblPassword = new GridBagConstraints();
				gbcLblPassword.anchor = GridBagConstraints.NORTHWEST;
				gbcLblPassword.gridx = 1;
				gbcLblPassword.gridy = 9;
				datiPersonali.add(lblPassword, gbcLblPassword);
				contentPane.repaint();
				contentPane.revalidate();
				
				JLabel lblPasswordCliente = new JLabel(c.getPassword());
				lblPasswordCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
				lblPasswordCliente.setForeground(Color.WHITE);
				GridBagConstraints gbcLblPasswordCliente = new GridBagConstraints();
				gbcLblPasswordCliente.anchor = GridBagConstraints.NORTHWEST;
				gbcLblPasswordCliente.gridx = 3;
				gbcLblPasswordCliente.gridy = 9;
				datiPersonali.add(lblPasswordCliente, gbcLblPasswordCliente);
				
				Component verticalStrut15 = Box.createVerticalStrut(20);
				GridBagConstraints gbcVerticalStrut15 = new GridBagConstraints();
				gbcVerticalStrut15.insets = new Insets(0, 0, 5, 0);
				gbcVerticalStrut15.gridx = 1;
				gbcVerticalStrut15.gridy = 10;
				datiPersonali.add(verticalStrut15, gbcVerticalStrut15);
				
				Component horizontalStrut5 = Box.createHorizontalStrut(20);
				GridBagConstraints gbcHorizontalStrut5 = new GridBagConstraints();
				gbcHorizontalStrut5.insets = new Insets(0, 0, 0, 5);
				gbcHorizontalStrut5.gridx = 0;
				gbcHorizontalStrut5.gridy = 11;
				datiPersonali.add(horizontalStrut5, gbcHorizontalStrut5);
				
				JLabel lblDataDiNascita= new JLabel("Data di nascita: ");
				lblDataDiNascita.setFont(new Font("Tahoma", Font.PLAIN, 28));
				lblDataDiNascita.setForeground(Color.WHITE);
				GridBagConstraints gbcLblData= new GridBagConstraints();
				gbcLblData.anchor = GridBagConstraints.NORTHWEST;
				gbcLblData.gridx = 1;
				gbcLblData.gridy = 11;
				datiPersonali.add(lblDataDiNascita, gbcLblData);
				contentPane.repaint();
				contentPane.revalidate();
				
				
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
				JLabel lblDataDiNascita1= new JLabel(dFormat.format(c.getDataDiNascita()));
				lblDataDiNascita1.setFont(new Font("Tahoma", Font.PLAIN, 28));
				lblDataDiNascita1.setForeground(Color.WHITE);
				GridBagConstraints gbcLblData1= new GridBagConstraints();
				gbcLblData1.anchor = GridBagConstraints.NORTHWEST;
				gbcLblData1.gridx = 3;
				gbcLblData1.gridy = 11;
				datiPersonali.add(lblDataDiNascita1, gbcLblData1);
				contentPane.repaint();
				contentPane.revalidate();
				
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnDatiPersonali.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbcBtnDatiPersonali = new GridBagConstraints();
		gbcBtnDatiPersonali.insets = new Insets(0, 0, 5, 0);
		gbcBtnDatiPersonali.anchor = GridBagConstraints.NORTHWEST;
		gbcBtnDatiPersonali.gridx = 0;
		gbcBtnDatiPersonali.gridy = 2;
		menu.add(btnDatiPersonali, gbcBtnDatiPersonali);
		
		Component verticalStrut6 = Box.createVerticalStrut(20);
		GridBagConstraints gbcVerticalStrut6 = new GridBagConstraints();
		gbcVerticalStrut6.insets = new Insets(0, 0, 5, 0);
		gbcVerticalStrut6.gridx = 0;
		gbcVerticalStrut6.gridy = 3;
		menu.add(verticalStrut6, gbcVerticalStrut6);
		
		JButton btnPrenotazioni = new JButton("Prenotazioni");
		btnPrenotazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				
				JPanel prenotazioni = new JPanel();
				prenotazioni.setBounds(100, 100, 894, 717);
				prenotazioni.setBackground(Color.BLUE);
				panel.add(prenotazioni);
				prenotazioni.setLayout(new BorderLayout(0, 0));
				
				JLabel lblLeTuePrenotazioni = new JLabel("Le tue Prenotazioni:");
				lblLeTuePrenotazioni.setFont(new Font("Tahoma", Font.PLAIN, 28));
				lblLeTuePrenotazioni.setForeground(Color.WHITE);
				prenotazioni.add(lblLeTuePrenotazioni, BorderLayout.NORTH);
				
				List <Prenotazione> listaPrenotazioni = Controller.getPrenotazionePerCliente(c.getCodCliente());
				
				Object rows [][] = new Object [listaPrenotazioni.size()][4];
				
				String [] columns = {"ID Prenotazione", "Prezzo Totale", "Prezzo Punti", "Pagata"};
				
				int i = 0;
				
				for(Prenotazione p : listaPrenotazioni) {
					rows[i][0] = p.getId();
					rows[i][1] = p.getPrezzoTotale();
					rows[i][2] = p.getPrezzoPuntiTotale();
					rows[i][3] = p.isPagato();
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
				
				prenotazioni.add(new JScrollPane(table), BorderLayout.CENTER);
				
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnPrenotazioni.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbcBtnPrenotazioni = new GridBagConstraints();
		gbcBtnPrenotazioni.insets = new Insets(0, 0, 5, 0);
		gbcBtnPrenotazioni.anchor = GridBagConstraints.NORTHWEST;
		gbcBtnPrenotazioni.gridx = 0;
		gbcBtnPrenotazioni.gridy = 4;
		menu.add(btnPrenotazioni, gbcBtnPrenotazioni);
		
		Component verticalStrut8 = Box.createVerticalStrut(20);
		GridBagConstraints gbcVerticalStrut8 = new GridBagConstraints();
		gbcVerticalStrut8.insets = new Insets(0, 0, 5, 0);
		gbcVerticalStrut8.gridx = 0;
		gbcVerticalStrut8.gridy = 5;
		menu.add(verticalStrut8, gbcVerticalStrut8);
		
		JButton btnSaldoPunti = new JButton("Saldo Punti");
		btnSaldoPunti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();

				JPanel saldoPunti = new JPanel();
				saldoPunti.setBounds(100, 100, 894, 717);
				saldoPunti.setBackground(Color.BLUE);
				panel.add(saldoPunti);
				saldoPunti.setLayout(new BorderLayout(0, 0));
				
				HashMap<Integer, Integer> puntiMap = Controller.getPuntiFedelta(c.getCodCliente());
				int tot=0;
				
				Object rows [][] = new Object[puntiMap.size()][4];
				String [] columns = {"Volo", "Partenza", "Destinazione", "Punti"};
				
				JTable table=new JTable(rows,columns);
		        int row=0;
			    for(Map.Entry<Integer,Integer> entry: puntiMap.entrySet()){
			         rows[row][0] = entry.getKey();
			         Volo v = Controller.getVolo(entry.getKey());
			         rows[row][1] = Controller.getDenominazioneAeroporto(v.getPartenza());
			         rows[row][2] = Controller.getDenominazioneAeroporto(v.getDestinazione());
			         rows[row][3] = entry.getValue();
			         tot += entry.getValue();
			         row++;
			    }
			    
			    TableModel model = new DefaultTableModel(rows, columns)
				  {
				    public boolean isCellEditable(int row, int columns)
				    {
				      return false;
				    }
				  };
				JTable table1 = new JTable(model);
				table.setPreferredSize(new Dimension(800, 500));
				
				saldoPunti.add(new JScrollPane(table), BorderLayout.CENTER);
				
				JLabel lblLeTuePrenotazioni = new JLabel("Il tuo saldo punti: "+tot);
				lblLeTuePrenotazioni.setFont(new Font("Tahoma", Font.PLAIN, 28));
				lblLeTuePrenotazioni.setForeground(Color.WHITE);
				saldoPunti.add(lblLeTuePrenotazioni, BorderLayout.NORTH);
				
				panel.add(saldoPunti);
				panel.repaint();
				panel.revalidate();
				}
		});
		btnSaldoPunti.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbcBtnSaldoPunti = new GridBagConstraints();
		gbcBtnSaldoPunti.insets = new Insets(0, 0, 5, 0);
		gbcBtnSaldoPunti.anchor = GridBagConstraints.NORTHWEST;
		gbcBtnSaldoPunti.gridx = 0;
		gbcBtnSaldoPunti.gridy = 6;
		menu.add(btnSaldoPunti, gbcBtnSaldoPunti);
		
		Component verticalStrut9 = Box.createVerticalStrut(20);
		GridBagConstraints gbcVerticalStrut9 = new GridBagConstraints();
		gbcVerticalStrut9.insets = new Insets(0, 0, 5, 0);
		gbcVerticalStrut9.gridx = 0;
		gbcVerticalStrut9.gridy = 7;
		menu.add(verticalStrut9, gbcVerticalStrut9);
	
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(homePanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbcBtnLogOut = new GridBagConstraints();
		gbcBtnLogOut.insets = new Insets(0, 0, 5, 0);
		gbcBtnLogOut.anchor = GridBagConstraints.NORTHWEST;
		gbcBtnLogOut.gridx = 0;
		gbcBtnLogOut.gridy = 10;
		menu.add(btnLogOut, gbcBtnLogOut);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbcVerticalStrut = new GridBagConstraints();
		gbcVerticalStrut.insets = new Insets(0, 0, 5, 0);
		gbcVerticalStrut.gridx = 0;
		gbcVerticalStrut.gridy = 9;
		menu.add(verticalStrut, gbcVerticalStrut);
		
		
		JLabel lblNewLabel = new JLabel("Sei loggato come: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setForeground(Color.WHITE);
		areaUtente.add(lblNewLabel, BorderLayout.NORTH);
		
		return areaUtente;
	}
}
