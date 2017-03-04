package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 363, 21);
		contentPane.add(menuBar);
		
		JMenuItem annonce = new JMenuItem("Annonce");
		menuBar.add(annonce);
		annonce.setPreferredSize(new Dimension(10,10));
		
		JMenuItem connexion = new JMenuItem("Connexion");
		connexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connexion page=new Connexion();
				page.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(connexion);
		connexion.setPreferredSize(new Dimension(10,10));
		
		JMenuItem inscription = new JMenuItem("Inscription");
		menuBar.add(inscription);
		inscription.setPreferredSize(new Dimension(10,10));
	}
}
