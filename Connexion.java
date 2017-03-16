package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import modele.Connect;
import modele.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField mail;
	private JTextField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() throws SQLException{
		this.addWindowListener(new MyWindowListener());
		setBounds(250, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Trajan Pro", Font.PLAIN, 40));
		lblConnexion.setBounds(342, 11, 271, 74);
		contentPane.add(lblConnexion);
		
		JLabel lblMail = new JLabel("Mail :");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblMail.setBounds(208, 239, 164, 40);
		contentPane.add(lblMail);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotDePasse.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblMotDePasse.setBounds(208, 290, 164, 41);
		contentPane.add(lblMotDePasse);
		
		mail = new JTextField();
		mail.setBounds(382, 244, 211, 32);
		contentPane.add(mail);
		mail.setColumns(10);
		
		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(382, 295, 211, 32);
		contentPane.add(mdp);
		
		JLabel error = new JLabel("");
		error.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		error.setForeground(new Color(139, 0, 0));
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setBounds(158, 116, 657, 40);
		contentPane.add(error);
		
		JButton valide = new JButton("Valider");
		valide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(mail.getText() == null || mail.getText() == "" || mdp.getText() == null || mdp.getText() == ""){
					error.setText("Veuillez remplir correctement tous les champs");			
				}else{
					Connection cnx = null;
					PreparedStatement checkmail = null;

					try{
						cnx = Connect.Connecter();
						String Sqlcheck = "SELECT * FROM user WHERE mail='" + mail.getText() + "'";
						checkmail = (PreparedStatement) cnx.prepareStatement(Sqlcheck);
						ResultSet check = checkmail.executeQuery();
						if(check.next()){
							String mdp2 = check.getString("mdp");
							if(mdp.getText().equals(mdp2)){ 
								User A = new User(mail.getText(), mdp.getText());
								Principal frame = new Principal(A);
								frame.setVisible(true);
								dispose();
							}else{
								error.setText("Les informations ne correspondent pas");			

							}
						}else{
							error.setText("Les informations ne correspondent pas");			

						}
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Problème lors de la connexion : " + e);
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
		valide.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		valide.setBounds(414, 338, 145, 41);
		contentPane.add(valide);
	}
}
