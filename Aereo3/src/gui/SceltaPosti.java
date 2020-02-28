package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SceltaPosti {
	
	static JPanel esegui(JPanel contentPane, int value, JPanel panel_8) {
		JPanel posti = new JPanel();
		posti.setBounds(100, 100, 894, 717);
		posti.setBackground(Color.BLUE);
		contentPane.add(posti, "name_1170960813504800");
		posti.setLayout(new BorderLayout(0, 0));
		
		JPanel sceltaPostiPanel = new JPanel();
		sceltaPostiPanel.setBackground(Color.BLUE);
		posti.add(sceltaPostiPanel, BorderLayout.WEST);
		GridBagLayout gbl_sceltaPostiPanel = new GridBagLayout();
		gbl_sceltaPostiPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_sceltaPostiPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_sceltaPostiPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_sceltaPostiPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		sceltaPostiPanel.setLayout(gbl_sceltaPostiPanel);
		
		JLabel lblScegliereIPosti = new JLabel("Scegliere i posti:");
		lblScegliereIPosti.setForeground(Color.WHITE);
		lblScegliereIPosti.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblScegliereIPosti = new GridBagConstraints();
		gbc_lblScegliereIPosti.insets = new Insets(0, 0, 5, 0);
		gbc_lblScegliereIPosti.gridx = 0;
		gbc_lblScegliereIPosti.gridy = 0;
		sceltaPostiPanel.add(lblScegliereIPosti, gbc_lblScegliereIPosti);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_6.gridx = 0;
		gbc_verticalStrut_6.gridy = 1;
		sceltaPostiPanel.add(verticalStrut_6, gbc_verticalStrut_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		posti.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(panel_8);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Prenota");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel.add(btnNewButton_1, BorderLayout.EAST);
		
		JLabel [] etichette = new JLabel[value*3];
		JComboBox [] box = new JComboBox[value*2];
		GridBagConstraints [] format = new GridBagConstraints[15];
		
		int u = 0;
		int y = 2;
		int z = 0;
		int k = 0;
		int h = 0;
		
		for(int i = 0; i<value;i++) {
			etichette[u] = new JLabel("Passeggero " + (i+1));
			etichette[u].setForeground(Color.WHITE);
			etichette[u].setFont(new Font("Tahoma", Font.PLAIN, 30));
			format[z] = new GridBagConstraints();
			format[z].anchor = GridBagConstraints.WEST;
			format[z].insets = new Insets(0, 0, 5, 5);
			format[z].gridx = k;
			format[z].gridy = y;
			sceltaPostiPanel.add(etichette[u], format[z]);
			y++;
			u++;
			z++;
			
			etichette[u] = new JLabel("Posto");
			etichette[u].setForeground(Color.WHITE);
			etichette[u].setFont(new Font("Tahoma", Font.PLAIN, 20));
			format[z] = new GridBagConstraints();
			format[z].anchor = GridBagConstraints.WEST;
			format[z].insets = new Insets(0, 0, 5, 5);
			format[z].gridx = k;
			format[z].gridy = y;
			sceltaPostiPanel.add(etichette[u], format[z]);
			y++;
			u++;
			z++;
			
			box[h] = new JComboBox();
			format[z] = new GridBagConstraints();
			format[z].fill = GridBagConstraints.HORIZONTAL;
			format[z].gridx = k;
			format[z].gridy = y;
			sceltaPostiPanel.add(box[h], format[z]);
			y++;
			h++;
			z++;
			
			etichette[u] = new JLabel("Fila");
			etichette[u].setForeground(Color.WHITE);
			etichette[u].setFont(new Font("Tahoma", Font.PLAIN, 20));
			format[z] = new GridBagConstraints();
			format[z].anchor = GridBagConstraints.WEST;
			format[z].insets = new Insets(0, 0, 5, 5);
			format[z].gridx = k;
			format[z].gridy = y;
			sceltaPostiPanel.add(etichette[u], format[z]);
			y++;
			u++;
			z++;
			
			box[h] = new JComboBox();
			format[z] = new GridBagConstraints();
			format[z].fill = GridBagConstraints.HORIZONTAL;
			format[z].gridx = k;
			format[z].gridy = y;
			sceltaPostiPanel.add(box[h], format[z]);
			h++;
			y++;
			z++;
		}
	return posti;
}
}
