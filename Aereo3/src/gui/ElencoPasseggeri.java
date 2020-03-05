package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import dominio.Cliente;
import dominio.ClienteFedele;
import dominio.Volo;

public class ElencoPasseggeri {
	
	static JPanel esegui(JPanel contentPane, int value, JPanel panel_6, int idVolo, boolean modifica) {
		JPanel panel8 = new JPanel();
		panel8.setBackground(Color.BLUE);
		contentPane.add(panel8, "name_1158551504937600");
		panel8.setLayout(new BorderLayout(0, 0));
		
		Date now = new Date();
		
		JPanel panel9 = new JPanel();
		panel9.setBackground(Color.BLUE);
		panel8.add(panel9, BorderLayout.WEST);
		GridBagLayout gblPanel9 = new GridBagLayout();
		gblPanel9.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblPanel9.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0};
		gblPanel9.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gblPanel9.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel9.setLayout(gblPanel9);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel8.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(panel_6);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnBack, BorderLayout.WEST);
		
		JLabel [] etichette = new JLabel[value*3];
		JTextField [] campi = new JTextField [value*2];
		GridBagConstraints [] format = new GridBagConstraints[etichette.length*campi.length];
		
		int k = 0;
		int y = 0;
		int z = 0;
		int h = 0;
		int u = 0;
		
		for (int i = 0; i<value; i++) {
			etichette[u] = new JLabel("Passeggero " + (i+1));
			etichette[u].setForeground(Color.WHITE);
			etichette[u].setFont(new Font("Tahoma", Font.PLAIN, 30));
			format[z] = new GridBagConstraints();
			format[z].anchor = GridBagConstraints.WEST;
			format[z].insets = new Insets(0, 0, 5, 5);
			format[z].gridx = k;
			format[z].gridy = y;
			panel9.add(etichette[u], format[z]);
			u++;
			y++;
			z++;
			
			etichette[u] = new JLabel("Nome");
			etichette[u].setForeground(Color.WHITE);
			etichette[u].setFont(new Font("Tahoma", Font.PLAIN, 20));
			format[z] = new GridBagConstraints();
			format[z].anchor = GridBagConstraints.WEST;
			format[z].insets = new Insets(0, 0, 5, 5);
			format[z].gridx = k;
			format[z].gridy = y;
			panel9.add(etichette[u], format[z]);
			u++;
			y++;
			z++;
			
			campi[h] = new JTextField();
			format[z] = new GridBagConstraints();
			format[z].fill = GridBagConstraints.HORIZONTAL;
			format[z].insets = new Insets(0, 0, 5, 0);
			format[z].anchor = GridBagConstraints.NORTH;
			format[z].gridx = k;
			format[z].gridy = y;
			panel9.add(campi[h], format[z]);
			campi[h].setColumns(10);
			y++;
			h++;
			z++;
			
			etichette[u] = new JLabel("Cognome");
			etichette[u].setForeground(Color.WHITE);
			etichette[u].setFont(new Font("Tahoma", Font.PLAIN, 20));
			format[z] = new GridBagConstraints();
			format[z].anchor = GridBagConstraints.WEST;
			format[z].insets = new Insets(0, 0, 5, 5);
			format[z].gridx = k;
			format[z].gridy = y;
			panel9.add(etichette[u], format[z]);
			u++;
			y++;
			z++;
			
			campi[h] = new JTextField();
			format[z] = new GridBagConstraints();
			format[z].fill = GridBagConstraints.HORIZONTAL;
			format[z].insets = new Insets(0, 0, 5, 0);
			format[z].anchor = GridBagConstraints.NORTH;
			format[z].gridx = k;
			format[z].gridy = y;
			panel9.add(campi[h], format[z]);
			campi[h].setColumns(10);
			y++;
			z++;
			h++;
	}
		
		JLabel email = new JLabel("Email");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints glcEmail = new GridBagConstraints();
		glcEmail.anchor = GridBagConstraints.WEST;
		glcEmail.insets = new Insets(0, 0, 5, 5);
		glcEmail.gridx = k;
		glcEmail.gridy = y;
		panel9.add(email, glcEmail);
		y++;
		
		JTextField emailInsert = new JTextField();
		GridBagConstraints glcEmailText = new GridBagConstraints();
		glcEmailText.fill = GridBagConstraints.HORIZONTAL;
		glcEmailText.insets = new Insets(0, 0, 5, 0);
		glcEmailText.anchor = GridBagConstraints.NORTH;
		glcEmailText.gridx = k;
		glcEmailText.gridy = y;
		panel9.add(emailInsert, glcEmailText);
		emailInsert.setColumns(10);
		y++;
		
		JLabel dataNascita = new JLabel("Inserire data di nascita");
		dataNascita.setForeground(Color.WHITE);
		dataNascita.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints glcNascita = new GridBagConstraints();
		glcNascita.anchor = GridBagConstraints.WEST;
		glcNascita.insets = new Insets(0, 0, 5, 5);
		glcNascita.gridx = k;
		glcNascita.gridy = y;
		panel9.add(dataNascita, glcNascita);
		y++;
		
		JDateChooser dataDiNascita = new JDateChooser();
		dataDiNascita.setDate(now);
		GridBagConstraints gbcDateChooser = new GridBagConstraints();
		gbcDateChooser.insets = new Insets(0, 0, 5, 5);
		gbcDateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbcDateChooser.gridx = k;
		gbcDateChooser.gridy = y;
		panel9.add(dataDiNascita, gbcDateChooser);
		y++;
		
		JButton logIn = new JButton("LogIn");
		boolean loggato = false;
		ClienteFedele c1 = null;
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInDialog logindlg = new LogInDialog();
				logindlg.setVisible(true);
				System.out.println(""+logindlg.isSuccessed());
				}
			});
		logIn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel8.add(logIn, BorderLayout.EAST);
		
		
		JLabel errore = new JLabel("");
		errore.setForeground(Color.RED);
		errore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints glcErrore = new GridBagConstraints();
		glcErrore.anchor = GridBagConstraints.WEST;
		glcErrore.insets = new Insets(0, 0, 5, 5);
		glcErrore.gridx = k;
		glcErrore.gridy = y;
		panel9.add(errore, glcErrore);
		
		int oldP = -1;
		
		JPanel panel10 = new JPanel();
		panel10.setBackground(Color.BLUE);
		panel8.add(panel10, BorderLayout.EAST);
		GridBagLayout gblPanel10 = new GridBagLayout();
		gblPanel10.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gblPanel10.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0};
		gblPanel10.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gblPanel10.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel10.setLayout(gblPanel10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 0;
		panel10.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 2;
		panel10.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setVisible(false);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		panel10.add(lblEmail, gbc_lblEmail);
		
		JTextField textField = new JTextField();
		textField.setVisible(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 4;
		panel10.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setVisible(false);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 5;
		panel10.add(lblPassword, gbc_lblPassword);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setVisible(false);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 6;
		panel10.add(passwordField, gbc_passwordField);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 7;
		panel10.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JButton btnNewButton1 = new JButton("LOGIN");
		btnNewButton1.setVisible(false);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteFedele c = Controller.login(textField.getText(), passwordField.getText());
				if(c != null) {
					campi[0].setText(c.getNome());
					campi[0].setEditable(false);
					campi[1].setText(c.getCognome());
					campi[1].setEditable(false);
					emailInsert.setText(c.getEmail());
					emailInsert.setEditable(false);
					dataDiNascita.setDate(c.getDataDiNascita());
				}
			}
		});
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 8;
		panel10.add(btnNewButton1, gbc_btnNewButton);
		
		JCheckBox chckbxSonoUnCliente = new JCheckBox("Sono un Cliente Fedele");
		chckbxSonoUnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblEmail.isVisible())
					lblEmail.setVisible(false);
				else
					lblEmail.setVisible(true);
				
				if(textField.isVisible())
					textField.setVisible(false);
				else
					textField.setVisible(true);
				
				if(lblPassword.isVisible())
					lblPassword.setVisible(false);
				else
					lblPassword.setVisible(true);
				
				if(passwordField.isVisible())
					passwordField.setVisible(false);
				else
					passwordField.setVisible(true);
				
				if(btnNewButton1.isVisible())
					btnNewButton1.setVisible(false);
				else
					btnNewButton1.setVisible(true);
			}
		});
		chckbxSonoUnCliente.setBackground(Color.BLUE);
		chckbxSonoUnCliente.setForeground(Color.WHITE);
		chckbxSonoUnCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSonoUnCliente = new GridBagConstraints();
		gbc_chckbxSonoUnCliente.anchor = GridBagConstraints.WEST;
		gbc_chckbxSonoUnCliente.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSonoUnCliente.gridx = 0;
		gbc_chckbxSonoUnCliente.gridy = 1;
		panel10.add(chckbxSonoUnCliente, gbc_chckbxSonoUnCliente);
		
		JButton btnNewButton = new JButton("Continua");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean continua = true;
				for (int i = 0; i<campi.length;i++) {
					if (campi[i].getText().equals("") || emailInsert.getText().equals("") || emailInsert.isValid() == false){
						continua=false;
						if (!errore.getText().equals("")) {
							errore.setText("");
						}
						errore.setText("Errore");
					}
				}
				
				if(dataDiNascita.getDate().after(now)) {
					continua=false;
					if (!errore.getText().equals("")) {
						errore.setText("");
					}
					errore.setText("Errore");
				}
				
				else if (continua == true) {
					if (!errore.getText().equals("")) {
						errore.setText("");
					}
					Cliente c;
					if (! loggato) {
						c  = new Cliente();
						c.setNome(campi[0].getText());
						c.setCognome(campi[1].getText());
						c.setEmail(emailInsert.getText());
						c.setDataDiNascita(dataDiNascita.getDate());
						c.setIndirizzo("Via Duomo");}
					else {
						c = c1;
					}
					contentPane.removeAll();
					contentPane.add(SceltaPosti.esegui(contentPane, value, panel8, idVolo, c, modifica, oldP));
					contentPane.repaint();
					contentPane.revalidate();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnNewButton, BorderLayout.EAST);
		
		
		return panel8;
	}
	
	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) 
			return false; 
		
		return pat.matcher(email).matches();
	}
}
