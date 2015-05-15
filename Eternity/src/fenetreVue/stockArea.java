package fenetreVue;

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

public class stockArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton [][]terrain;
	
	int rotation = 4;
	int rotation2 = 0;
	int numPiece = 0;
	int numPiece2 = 0;
	
	int i = 0, j = 0;
	int i2 = 0, j2 = 0;
	
	boolean switcheurFou = false;
	
	public stockArea() {
		
		setPreferredSize(new Dimension(800, 400));
		creaStockArea();
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {

				this.add(terrain[i][j]);
				
			}
		}
	}
	
	public void creaStockArea(){
		
		terrain = new JButton [4][4];
		//int i = 0, j = 0;
		ButtonMvt mouvement = new ButtonMvt();
		
		for (i = 0; i < terrain.length; i++) {
			for (j = 0; j < terrain.length; j++) {
				
				numPiece++;
				terrain[i][j] = new JButton();
				
				try {
					Image img = ImageIO.read(getClass().getResource("/Images/p" + numPiece + "r" + rotation + ".jpg"));
					ImageIcon imgIcon = new ImageIcon(img);
					terrain[i][j].setIcon(imgIcon);
				}
				catch (IOException ex) {}
				
				terrain[i][j].setPreferredSize(new Dimension(158, 158));
				//terrain[i][j].setBounds(0, 0, 0, 0);
				//terrain[i][j].setBackground(Color.BLUE);
				terrain[i][j].setActionCommand( i + ";" + j + ";" + numPiece);
				terrain[i][j].addActionListener(mouvement);
				terrain[i][j].addKeyListener(mouvement);
				terrain[i][j].addMouseListener(mouvement);
				setFocusable(true);
				
				
				System.out.println("On intègre la piece : " + numPiece + " de rotation " + rotation);

			}
		}
		
		
	}
	
	
	
	class ButtonMvt implements KeyListener, MouseListener, ActionListener {
		
		public void actionPerformed ( ActionEvent e) {
			
			 i = new Integer(e.getActionCommand().split(";")[0]);
			 j = new Integer(e.getActionCommand().split(";")[1]);
			 
			 numPiece = new Integer(e.getActionCommand().split(";")[2]);
			
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
							
						case KeyEvent.VK_DOWN:
							
							i2 = i;
							j2 = j;
							System.out.println("Coordonnées temporaires: (" + i2 + "," + j2 + ")" );
							System.out.println("Piece numero: (" + numPiece2 + ")" );
						
							switcheurFou = true;
												
			}
		
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			// Traitement du clic droit
			if(e.getButton() == MouseEvent.BUTTON3 && switcheurFou == true) {
				
				terrain[i][j].setSelected(true); 
				terrain[i][j].setFocusable(true);
				
				try {
					Image img = ImageIO.read(getClass().getResource("/Images/p" + numPiece + "r" + rotation + ".jpg"));
					ImageIcon imgIcon = new ImageIcon(img);
					terrain[i2][j2].setIcon(imgIcon);
				}
				catch (IOException ex) {}

				//switcheurFou = false;
	        }
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("Pression");
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("Relachement");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("On est sur la piece");
			
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
}


