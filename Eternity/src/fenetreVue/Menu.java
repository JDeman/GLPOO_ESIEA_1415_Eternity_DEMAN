package fenetreVue;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;

@SuppressWarnings("unused")

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	//Variable utilisable dans tous le code
	public static JFrame menu = new JFrame();

	//création du Menu
	public Menu(){
		menu.setTitle("Menu");	
		menu.setSize(500, 300);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLocationRelativeTo(null);

		menu.setContentPane(new Panneau());
		menu.setVisible(true);
	}      
}

class Panneau extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton jouer;
	private JButton charger;
	private JButton quitter;

	public Panneau(){
		choix();
	}

	//Image de fond
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(getClass().getResource("/Images/index.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}                
	}

	public void choix(){

		jouer();
		charger();
		quitter();

		this.add(jouer);
		this.add(charger);
		this.add(quitter);		
	}

	public void jouer(){
		jouer = new JButton("Jouer");
		jouer.setPreferredSize(new Dimension(100, 50));
		/*	
		 	//Image à la place d'un bouton moche
		 	try{
			Image img = ImageIO.read(getClass().getResource("/Images/p1.jpg"));
			jouer.setIcon(new ImageIcon(img));
			}catch (IOException ex) {}
		*/
		jouer.addActionListener(new Action_jouer());
	}
	
	class Action_jouer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Ouvre la fentre de jeu
			new FenetrePrincipale();
			//Masque le Menu
			Menu.menu.dispose();
		}
	}

	public void charger(){
		charger = new JButton("Charger");
		charger.setPreferredSize(new Dimension(100, 50));
		charger.addActionListener(new Action_load());
	}
	
	class Action_load implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("Test3");
		}
	}

	public void quitter(){
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(100, 50));
		quitter.addActionListener(new Action_quit());
	}
	
	class Action_quit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Quitte le programme
			System.exit(0);
		}
	}
}