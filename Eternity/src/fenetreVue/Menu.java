package fenetreVue;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.*;

@SuppressWarnings("unused")

public class Menu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel boutton;
	private JButton jouer;
	private JButton charger;
	private JButton quitter;
	


	  public Menu(){
	    this.setTitle("Menu");
	    this.setSize(600, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    choix();
	    
	    this.setContentPane(boutton);
	    this.setVisible(true);
	  }      
	
	public void choix(){
		
		boutton = new JPanel();
		boutton.setBounds(0, 0, 300, 200);
		
		jouer();
		charger();
		quitter();
		
		boutton.add(jouer);
		boutton.add(charger);
		boutton.add(quitter);
		
	}

	public void jouer(){
		jouer = new JButton("Jouer");
		jouer.setPreferredSize(new Dimension(100, 50));
	//	jouer.addActionListener(new Action_jouer());
	}
	
	public void charger(){
		charger = new JButton("Charger");
		charger.setPreferredSize(new Dimension(100, 50));
		//charger.addActionListener(new Action_load());
	}
	
	public void quitter(){
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(100, 50));
		//quitter.addActionListener(new Action_quit());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Test1");
	}
	
	
}


class Action_jouer extends Menu implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Test2");
	}

}

class Action_load extends Menu implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Test3");
	}

}

class Action_quit extends Menu implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Test4");
	}

}

