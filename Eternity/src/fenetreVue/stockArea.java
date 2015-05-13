package fenetreVue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class stockArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton [][]terrain;
	
	
	public stockArea() {
		
		int i=0, j=0;
		
		setPreferredSize(new Dimension(500, 400));
		creaStockArea();
		/*for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {*/
				this.add(terrain[i][j]);
			/*}
		}*/
	}
	
	private void creaStockArea(){
		terrain = new JButton [4][4];
		int /*x=25, y=25,*/ numPiece=1;
		int i=0, j=0;
		/*for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {*/
				
				terrain[i][j]= new JButton(new ImageIcon("p" + numPiece + ".jpg"));
				terrain[i][j].setIcon(new ImageIcon("p" + numPiece + ".jpg"));
				terrain[i][j].setPreferredSize(new Dimension(120, 120));
				//terrain[i][j].setBounds(x, y, 158, 158);
				//terrain[i][j].setBackground(Color.BLUE);
				//numPiece++;
				System.out.println(numPiece);
				//x+=25;
			/*}
			//y+=25;
		}*/
	}
}