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
	//Random rd = new Random();
	int rotation = 4 /*+rd.nextInt(4)*/;
	int numPiece = 0 /*+rd.nextInt(16)*/;
	
	
	public stockArea() {
		
		setPreferredSize(new Dimension(500, 400));
		creaStockArea();
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {

				this.add(terrain[i][j]);
				
			}
		}
	}
	
	public void creaStockArea(){
		
		terrain = new JButton [4][4];
		int i = 0, j = 0;
		ButtonMvt mouvement = new ButtonMvt();
		
		for (i = 0; i < terrain.length; i++) {
			for (j = 0; j < terrain.length; j++) {
				
				numPiece++;
				terrain[i][j] = new JButton(/*new ImageIcon("p" + numPiece + ".jpg")*/);
				
				try {
					Image img = ImageIO.read(getClass().getResource("/Images/p" + numPiece + "r" + rotation + ".jpg"));
					ImageIcon imgIcon = new ImageIcon(img);
					terrain[i][j].setIcon(imgIcon);
				}
				catch (IOException ex) {}
				
				terrain[i][j].setPreferredSize(new Dimension(120, 120));
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
		
		int i, j, numPiece;
		
		
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


