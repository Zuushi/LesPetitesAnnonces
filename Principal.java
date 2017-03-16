package vue;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.User;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
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
				Connexion page= new Connexion();
				page.setVisible(true);
				dispose();
				}catch(Exception e){
					
				}
			}
		});
		
		JMenu annonce = new JMenu("Annonces");
		menu.add(annonce);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Rechercher");
		annonce.add(mntmNewMenuItem);
		menu.add(connexion);
		connexion.setPreferredSize(new Dimension(100, 10));
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Inscription");
		menu.add(mntmNewMenuItem_1);
		
		JLabel isconnected = new JLabel("Veuillez vous connecter");
		isconnected.setHorizontalAlignment(SwingConstants.CENTER);
		isconnected.setBounds(549, 50, 274, 31);
		contentPane.add(isconnected);
	}
	
	public Principal(User b) {
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Rechercher");
		annonce.add(mntmNewMenuItem);
		menu.add(connexion);
		connexion.setPreferredSize(new Dimension(100, 10));
		
		JMenuItem deconnexion = new JMenuItem("deconnexion");
		menu.add(deconnexion);
		
		
		
		JLabel isconnected = new JLabel("Bienvenue " + b.getNom() + " " +  b.getPrenom() );
		isconnected.setHorizontalAlignment(SwingConstants.CENTER);
		isconnected.setBounds(549, 50, 274, 31);
		contentPane.add(isconnected);
	}
}
