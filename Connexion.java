package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

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
	public Connexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		valide.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		valide.setBounds(414, 338, 145, 41);
		contentPane.add(valide);
	}
}
