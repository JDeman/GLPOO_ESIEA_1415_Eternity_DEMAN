package fenetreVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fenetreVue.Menu;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variable utilisable dans tous le code
	public static JFrame fenetrePrincipale = new JFrame();
	
	private JPanel espJeu;
	private JMenuBar barMenu;
	private JMenu option;
	private JMenuItem restart, quitter;
	private gameArea terrainJeu;
	private stockArea terrainStock;

	// Creation de la fenetre principale
	public FenetrePrincipale() {

		fenetrePrincipale.setTitle("Jeu Eternity - Menu principale");
		fenetrePrincipale.setSize(1200, 700);
		fenetrePrincipale.setLocationRelativeTo(null);
		fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu();
		fenetreJeu();
		fenetrePrincipale.setContentPane(espJeu);
		fenetrePrincipale.setJMenuBar(barMenu);
		fenetrePrincipale.setVisible(true);
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


		
		option = new JMenu("Options");
		barMenu.add(option);

		restart = new JMenuItem("Revenir au menu");
		restart.addActionListener(new Back_menu());
		option.add(restart);

		quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new Quitter());
		option.add(quitter);


	}

	public void MouseClicked (ActionEvent e) {

	}

	class Back_menu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Creer un nouveau Menu
			new Menu();
			//Masque la fenetre de jeu
			fenetrePrincipale.dispose();
			//menu.setVisible(true);
		}
	}

	class Quitter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Quitte le programme
			System.exit(0);
		}
	}
}
