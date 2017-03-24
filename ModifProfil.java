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

import com.mysql.jdbc.PreparedStatement;

import modele.Connect;
import modele.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;

public class ModifProfil extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField telephone;
	

	public ModifProfil(User a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificationDuProfil = new JLabel("Modification du profil de ");
		lblModificationDuProfil.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblModificationDuProfil.setBounds(38, 11, 221, 36);
		contentPane.add(lblModificationDuProfil);
		
		JLabel titre = new JLabel("Mr.bibi");
		titre.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		titre.setBounds(267, 11, 366, 36);
		contentPane.add(titre);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNom.setBounds(152, 186, 52, 36);
		contentPane.add(lblNom);
		
		nom = new JTextField();
		nom.setBounds(214, 191, 127, 26);
		contentPane.add(nom);
		nom.setColumns(10);
		
		JLabel label_1 = new JLabel("Prénom :");
		label_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		label_1.setBounds(420, 189, 76, 36);
		contentPane.add(label_1);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(506, 191, 127, 26);
		contentPane.add(prenom);
		
		JLabel label_2 = new JLabel("Téléphone :");
		label_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		label_2.setBounds(279, 254, 92, 36);
		contentPane.add(label_2);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(381, 259, 127, 26);
		contentPane.add(telephone);
		
		nom.setText(a.getNom());
		prenom.setText(a.getPrenom());
		telephone.setText(a.getTelephone());
		titre.setText(a.getPrenom());
		
		JLabel error = new JLabel("");
		error.setForeground(new Color(255, 0, 0));
		error.setBounds(165, 453, 579, 26);
		contentPane.add(error);
		
		JButton btnNewButton = new JButton("Gerer les annonces");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(66, 91, 178, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int option= JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment supprimer votre profil ?","Suppression",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
					try {
						a.supprimerProfil();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}else{
				}
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(153, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(627, 394, 107, 46);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("Valider");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(nom.getText().isEmpty() || prenom.getText().isEmpty() || telephone.getText().isEmpty() ){
					error.setText("Veuillez remplir tous les champs.");
				}else{
					error.setText("");
					Connection cnx = null;
					PreparedStatement checkmail = null;
					
					try{	
						cnx = Connect.Connecter();
						String erreur = "";
				        
						if(nom.getText().length() < 3){
							erreur = erreur + "Veuillez rentrer un nom valide d'au moins 3 caractères. \n";
						}
						if(prenom.getText().length() < 3){
							erreur = erreur + "Veuillez rentrer un prénom valide d'au moins 3 caractères. \n";
						}		
						
						if(telephone.getText().length() < 10){
							erreur = erreur + "Veuillez rentrer un numéro de téléphone valide d'au moins 10 caractères. \n";
						}
						
						
						if(erreur.equals("")){
							a.modifierProfil( nom.getText(), prenom.getText(), telephone.getText());
						}else{
							JOptionPane.showMessageDialog(null, "Veuillez remplir correctement les champs : \n" + erreur);
						}
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Problème lors de la modification : " + e);

					}finally{
						if(cnx != null){
							try {
								cnx.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(checkmail != null){
							try {
								checkmail.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
		
		
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		button.setBackground(new Color(0, 102, 0));
		button.setBounds(176, 394, 107, 46);
		contentPane.add(button);
		
		JButton btnModifierLeMot = new JButton("Modifier le mot de passe");
		btnModifierLeMot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String mdp=JOptionPane.showInputDialog("Quel est le nouveau mot de passe ?");
				if (mdp!=null){
					if (mdp.length()!=0){
						int option2= JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment que votre nouveau mot de passe soit "+mdp+" ?","Changement de mot de passe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(option2 == JOptionPane.OK_OPTION){
							try {
								a.modifierMdp(mdp);
								JOptionPane.showMessageDialog(null, "Votre mot de passe a bien été modifié !");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						}else{
							JOptionPane.showMessageDialog(null, "Le champ est vide");
						}
					
				
				}
				
			}
		
		});
		btnModifierLeMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModifierLeMot.setBounds(307, 321, 201, 32);
		contentPane.add(btnModifierLeMot);
		
		
	}
}
