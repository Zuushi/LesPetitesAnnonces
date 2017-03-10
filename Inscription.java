package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import modele.Connect;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField mail;
	private JTextField nom;
	private JTextField prenom;
	private JTextField tel;
	private JTextField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPremireConnexion = new JLabel("Premi\u00E8re connexion ?");
		lblPremireConnexion.setFont(new Font("Trajan Pro", Font.PLAIN, 35));
		lblPremireConnexion.setBounds(239, 11, 450, 59);
		contentPane.add(lblPremireConnexion);
		
		JLabel lblParIciLinscription = new JLabel(" Par ici l'inscription !");
		lblParIciLinscription.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		lblParIciLinscription.setBounds(326, 61, 270, 42);
		contentPane.add(lblParIciLinscription);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblEmail.setBounds(74, 258, 70, 32);
		contentPane.add(lblEmail);
		
		mail = new JTextField();
		mail.setBounds(148, 258, 263, 27);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNom.setBounds(513, 229, 70, 32);
		contentPane.add(lblNom);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(587, 229, 263, 27);
		contentPane.add(nom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblPrenom.setBounds(492, 310, 91, 32);
		contentPane.add(lblPrenom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(587, 314, 263, 27);
		contentPane.add(prenom);
		
		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblTelephone.setBounds(472, 394, 105, 32);
		contentPane.add(lblTelephone);
		
		tel = new JTextField();
		tel.setColumns(10);
		tel.setBounds(587, 398, 263, 27);
		contentPane.add(tel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe :");
		lblMotDePasse.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblMotDePasse.setBounds(22, 352, 133, 32);
		contentPane.add(lblMotDePasse);
		
		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(148, 356, 263, 27);
		contentPane.add(mdp);
		
		JButton btnNewButton = new JButton("Je m'inscrit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String mail1=mail.getText();
				String nom1=nom.getText();
				String prenom1=prenom.getText();
				String mdp1=mdp.getText();
				String tel1=tel.getText();
				Connection cnx = null;
				PreparedStatement checkinscri = null;
				try {
				cnx=Connect.Connecter();
				String sqlcheck= "INSERT INTO user (mail,nom,prenom,mdp,telephone) VALUES('"+mail1+"','"+nom1+"','"+prenom1+"','"+mdp1+"','"+tel1+"')";
				checkinscri = (PreparedStatement) cnx.prepareStatement(sqlcheck);
				checkinscri.executeUpdate();
				JOptionPane.showMessageDialog(null, "Inscription réussite");
				dispose();
				
				
				}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erreur d'obtention de departements" + e);
				JOptionPane.showMessageDialog(null, mail);


			}finally {
				if(cnx != null){
					try {
						cnx.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(checkinscri != null){
					try {
						checkinscri.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnNewButton.setBounds(517, 489, 160, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnNewButton_1.setBounds(280, 490, 160, 42);
		contentPane.add(btnNewButton_1);
	}
}
