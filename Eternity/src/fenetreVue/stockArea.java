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

@SuppressWarnings("unused")
public class stockArea extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton [][]terrain;

	int rotation = 4;
	int rotation2 = 0;
	int numPiece = 0;
	int numPiece2 = 0;
	int newNum = 0, oldNum = 0;
	int newNumPiece = 0;

	int i = 0, j = 0;
	int i2 = 0, j2 = 0;
	int i3 = 0, j3 = 0;
	int itmp = 0, jtmp = 0;

	boolean switcheurFou = false;

	//Creer le tableau de jeu
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
				//terrain[i][j].addMouseListener(mouvement);
				setFocusable(true);

				//System.out.println("On integre la piece : " + numPiece + " de rotation " + rotation);
			}
		}
	}

	class ButtonMvt implements KeyListener, ActionListener {

		//Lorsque l'on clique sur une piece
		public void actionPerformed ( ActionEvent e) {

			i = new Integer(e.getActionCommand().split(";")[0]);
			j = new Integer(e.getActionCommand().split(";")[1]);

			numPiece = new Integer(terrain[i][j].getActionCommand().split(";")[2]);

			System.out.print("Coordonnees: (" + i + "," + j + ")" );
			System.out.println("\tPiece numero: (" + numPiece + ")" );

		}

		public void keyTyped (KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyPressed(KeyEvent e) {

			System.out.println("Vous avez appuye sur la touche "+ e.getKeyCode());

			switch ( e.getKeyCode() ) {

				case KeyEvent.VK_SPACE:

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
					break;

				case KeyEvent.VK_UP:

					if(terrain[i-1][j]!=null){
						i2 = i;
						j2 = j;
						System.out.println("Coordonnees pice dŽbut (2): (" + i2 + "," + j2 + ")" );
						//System.out.println("Piece numero: (" + numPiece + ")" );

						i3 = i2 - 1;
						j3 = j2;

						numPiece2 = new Integer(terrain[i2][j2].getActionCommand().split(";")[2]);
						if(numPiece2 != numPiece)
							System.out.println("ya un petit probleme");
						newNumPiece = new Integer(terrain[i3][j3].getActionCommand().split(";")[2]);

						System.out.println("Piece numero 2: (" + numPiece2 +";"+ numPiece + ")" );
						System.out.println("Piece numero 3: (" + newNumPiece + ")" );

						ImageIcon tmpImgUp = new ImageIcon();
						tmpImgUp = (ImageIcon) terrain[i3][j3].getIcon();

						terrain[i3][j3].setIcon(terrain[i2][j2].getIcon());
						terrain[i2][j2].setIcon(tmpImgUp);
						/*
						   try {
						   Image img3 = ImageIO.read(getClass().getResource("/Images/p" + numPiece2 + "r" + rotation + ".jpg"));
						   ImageIcon imgIcon3 = new ImageIcon(img3);
						   terrain[i3][j3].setIcon(imgIcon3);
						   }
						   catch (IOException ex) {}
						   try {
						   Image img2 = ImageIO.read(getClass().getResource("/Images/p" + newNumPiece + "r" + rotation + ".jpg"));
						   ImageIcon imgIcon2 = new ImageIcon(img2);
						   terrain[i2][j2].setIcon(imgIcon2);
						   }
						 */
						//numPiece = newNumPiece;
						//newNumPiece = numPiece2;


						System.out.print("Coordonnees nouvelles Piece numero 2: (" + i3 + "," + j3 + ")" );
						System.out.println("\tPiece numero: (" + numPiece + ")" );
						System.out.print("Coordonnees Other: (" + i2 + "," + j2 + ")" );
						System.out.println("\tPiece numero: (" + newNumPiece + ")" );
					}
					break;

				case KeyEvent.VK_DOWN:

					if(terrain[i+1][j]!=null){
						i2 = i;
						j2 = j;
						System.out.println("Coordonnees temporaires: (" + i2 + "," + j2 + ")" );
						System.out.println("Piece numero: (" + numPiece + ")" );
	
						i3 = i2 + 1;
						j3 = j2;
	
						ImageIcon tmpImgDown = new ImageIcon();
						tmpImgDown = (ImageIcon) terrain[i3][j3].getIcon();
	
						terrain[i3][j3].setIcon(terrain[i2][j2].getIcon());
						terrain[i2][j2].setIcon(tmpImgDown);
						System.out.println("Coordonnees nouvelles: (" + i3 + "," + j3 + ")" );
						System.out.println("Piece numero: (" + numPiece + ")" );
					}
					break;

				case KeyEvent.VK_LEFT:

					if(terrain[i][j-1]!=null){
						i2 = i;
						j2 = j;
						System.out.println("Coordonnees temporaires: (" + i2 + "," + j2 + ")" );
						System.out.println("Piece numero: (" + numPiece + ")" );
	
						i3 = i2;
						j3 = j2 - 1;
	
						ImageIcon tmpImgLeft = new ImageIcon();
						tmpImgLeft = (ImageIcon) terrain[i3][j3].getIcon();
	
						terrain[i3][j3].setIcon(terrain[i2][j2].getIcon());
						terrain[i2][j2].setIcon(tmpImgLeft);
						System.out.println("Coordonnees nouvelles: (" + i3 + "," + j3 + ")" );
						System.out.println("Piece numero: (" + numPiece + ")" );
					}
					break;

				case KeyEvent.VK_RIGHT:

					if(terrain[i][j+1]!=null){
						i2 = i;
						j2 = j;
						System.out.println("Coordonnees temporaires: (" + i2 + "," + j2 + ")" );
						System.out.println("Piece numero: (" + numPiece + ")" );
	
						i3 = i2;
						j3 = j2 + 1;
	
						ImageIcon tmpImgRight = new ImageIcon();
						tmpImgRight = (ImageIcon) terrain[i3][j3].getIcon();
	
						terrain[i3][j3].setIcon(terrain[i2][j2].getIcon());
						terrain[i2][j2].setIcon(tmpImgRight);
						System.out.println("Coordonnees nouvelles: (" + i3 + "," + j3 + ")" );
						System.out.println("Piece numero: (" + numPiece + ")" );
					}
					break;
			}
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}
}