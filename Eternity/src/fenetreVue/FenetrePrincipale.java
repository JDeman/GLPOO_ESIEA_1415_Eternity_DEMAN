package fenetreVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame implements ActionListener {

		private JPanel espJeu;
		private JMenuBar barMenu;
		private JMenu lancer, quitter;
		private gameArea terrainJeu;
		private stockArea terrainStock;
	
	// Creation de la fenetre principale
	public FenetrePrincipale() {
		
		super("Jeu Eternity - Menu principale");
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu();
		fenetreJeu();
		setContentPane(espJeu);
		setJMenuBar(barMenu);
		setVisible(true);
		
	}
		
	
	public void fenetreJeu() {
		
		buildgameArea();
		buildstockArea();
		
		espJeu = new JPanel();
		espJeu.setBackground(Color.LIGHT_GRAY);
		espJeu.setBounds(0, 0, 1200, 600);
		espJeu.setLayout(new BorderLayout());
		
		espJeu.add(terrainJeu, BorderLayout.EAST);
		espJeu.add(terrainStock, BorderLayout.WEST);
		
	}
	
	// Affichage du terrain de jeu
	public void buildgameArea() {
	
		terrainJeu = new gameArea();
		
	}
	
	// Affichage du terrain de stockage des cartes
	public void buildstockArea() {
		
		terrainStock = new stockArea();
		
	}


	// Creation du menu
	public void menu() {
			
		barMenu = new JMenuBar();
			
		lancer = new JMenu("Jouer");
			
		barMenu.add(lancer);
			
		quitter = new JMenu("Quitter");
		barMenu.add(quitter);
		
	}

	@Override
	public void actionPerformed (ActionEvent e) {

		System.exit(0);
	}
	
	public void MouseClicked (ActionEvent e) {
		
	}


}
