package vue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import modele.Connect;
import modele.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Inscription extends JFrame {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mail;
	private JTextField telephone;
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
		
		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, 378, 21);
		contentPane.add(menu);
		
		JMenuItem connexion = new JMenuItem("Connexion");
		connexion.setHorizontalAlignment(SwingConstants.CENTER);
		connexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				Connexion page=new Connexion();
				page.setVisible(true);
				dispose();
				}catch(Exception e){
					
				}
			}
		});
		
		JMenu annonce = new JMenu("Annonces");
		menu.add(annonce);
		
		JButton mntmNewMenuItem = new JButton("Rechercher");
		annonce.add(mntmNewMenuItem);
		menu.add(connexion);
		connexion.setPreferredSize(new Dimension(100, 10));
		
		JMenuItem deconnexion = new JMenuItem("deconnexion");
		menu.add(deconnexion);
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 36));
		lblInscription.setBounds(268, 76, 221, 65);
		contentPane.add(lblInscription);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(39, 203, 56, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(39, 255, 56, 16);
		contentPane.add(lblPrnom);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setBounds(422, 203, 56, 16);
		contentPane.add(lblMail);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setBounds(422, 255, 88, 16);
		contentPane.add(lblTlphone);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(253, 304, 112, 16);
		contentPane.add(lblMotDePasse);
		
		nom = new JTextField();
		nom.setBounds(117, 200, 116, 22);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(117, 252, 116, 22);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		mail = new JTextField();
		mail.setText("");
		mail.setBounds(528, 200, 116, 22);
		contentPane.add(mail);
		mail.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(526, 252, 116, 22);
		contentPane.add(telephone);
		telephone.setColumns(10);
		
		mdp = new JTextField();
		mdp.setBounds(377, 301, 116, 22);
		contentPane.add(mdp);
		mdp.setColumns(10);
		
		JLabel error = new JLabel("");
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setForeground(Color.RED);
		error.setFont(new Font("Tahoma", Font.ITALIC, 13));
		error.setBounds(39, 368, 696, 16);
		contentPane.add(error);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(nom.getText().isEmpty() || prenom.getText().isEmpty() || mail.getText().isEmpty() || telephone.getText().isEmpty() || mdp.getText().isEmpty()){
					error.setText("Veuillez remplir tous les champs.");
				}else{
					error.setText("");
					Connection cnx = null;
					PreparedStatement checkmail = null;
					
					try{	
						cnx = Connect.Connecter();
						String erreur = "";
				        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail.getText());
						if (!matcher.find()){
							erreur = "Veuillez rentrer un email valide. \n";
						}
						if(nom.getText().length() < 3){
							erreur = erreur + "Veuillez rentrer un nom valide d'au moins 3 caractères. \n";
						}
						if(prenom.getText().length() < 3){
							erreur = erreur + "Veuillez rentrer un prénom valide d'au moins 3 caractères. \n";
						}		
						if(mdp.getText().length() < 6){
							erreur = erreur + "Veuillez rentrer un mot de passe valide d'u moins 6 caractères. \n";
						}
						if(telephone.getText().length() < 10){
							erreur = erreur + "Veuillez rentrer un numéro de téléphone valide d'au moins 10 caractères. \n";
						}
						
						String Sqlcheck = "SELECT * FROM user WHERE mail='" + mail.getText() + "'";
						PreparedStatement checkmail1 = (PreparedStatement) cnx.prepareStatement(Sqlcheck);
						ResultSet check = checkmail1.executeQuery();
						if(check.next()){
							erreur = erreur + "L'adresse email entre existe déja. \n";
						}
						if(erreur.equals("")){
							User A = new User(mail.getText(), nom.getText(), prenom.getText(), mdp.getText(), telephone.getText());
							error.setForeground(Color.RED);
							error.setText("Inscription validé");

						}else{
							JOptionPane.showMessageDialog(null, "Veuillez remplir correctement les champs : \n" + erreur);
						}
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Problème lors de l'inscriptions : " + e);

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
		btnSinscrire.setBounds(305, 397, 133, 52);
		contentPane.add(btnSinscrire);
		

		

	}
}

