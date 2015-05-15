package fenetreVue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class gameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton [][]terrain;
	//Random rd = new Random();
	int rotation = 4 /*+rd.nextInt(4)*/;
	int numPiece = 0 /*+rd.nextInt(16)*/;
	int i = 0, j = 0;
	
	public gameArea() {
		
		setPreferredSize(new Dimension(500, 400));
		creaArea();
		
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {
				this.add(terrain[i][j]);
			}
		}
		
	}
	
	private void creaArea(){
		
		terrain = new JButton [4][4];
		
		ButtonMvt2 mouvement2 = new ButtonMvt2();
		
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {
								
				terrain[i][j]= new JButton();
				terrain[i][j].setPreferredSize(new Dimension(120, 120));
				//terrain[i][j].setBounds(x, y, 158, 158);
				terrain[i][j].setBackground(Color.DARK_GRAY);
				
				terrain[i][j].setActionCommand( i + ";" + j);
				terrain[i][j].addActionListener(mouvement2);
				terrain[i][j].addKeyListener(mouvement2);
				terrain[i][j].addMouseListener(mouvement2);
				
				setFocusable(true);
				System.out.println(numPiece);
				
			}
		}
		
	}
		
	
class ButtonMvt2 implements KeyListener, MouseListener, ActionListener {
		
		public void actionPerformed ( ActionEvent e) {
			
			 i = new Integer(e.getActionCommand().split(";")[0]);
			 j = new Integer(e.getActionCommand().split(";")[1]);
			
			System.out.println("Coordonnées: (" + i + "," + j + ")" );
			System.out.println("Piece numero: (" + numPiece + ")" );
			
		}
		
		public void keyTyped (KeyEvent e) {
		// TODO Auto-generated method stub

		}

		public void keyPressed(KeyEvent e) {
			
			System.out.println("Vous avez appuyé sur la touche "+ e.getKeyCode());
					
					switch ( e.getKeyCode() ) {
								
						case KeyEvent.VK_UP:
							
							rotation --;
							if (rotation == 0)
								rotation = 4;
							
							System.out.println("Nouvelle piece : p " + numPiece + " de rotation : " + rotation);
							
							try {
								Image img = ImageIO.read(getClass().getResource("/Images/p" + numPiece + "r" + rotation + ".jpg"));
								ImageIcon imgIcon = new ImageIcon(img);
								terrain[i][j].setIcon(imgIcon);
							}
							catch (IOException ex) {}
												
			}
		
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
}
