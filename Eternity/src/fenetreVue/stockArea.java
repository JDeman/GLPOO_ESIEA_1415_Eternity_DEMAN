package fenetreVue;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class stockArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton [][]terrain;
	
	
	public stockArea() {
		
		setPreferredSize(new Dimension(500, 400));
		creaStockArea();
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {
				this.add(terrain[i][j]);
			}
		}
	}
	
	private void creaStockArea(){
		
		terrain = new JButton [4][4];
		
		//Random rd = new Random();
		//int x=25, y=25; 
		int numPiece = 1 /*+rd.nextInt(16)*/;
		
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {
				
				terrain[i][j]= new JButton(/*new ImageIcon("p" + numPiece + ".jpg")*/);
				try {
					Image img = ImageIO.read(getClass().getResource("/Images/p" + numPiece + ".jpg"));
					terrain[i][j].setIcon(new ImageIcon(img));
				}
				catch (IOException ex) {}
				
				terrain[i][j].setPreferredSize(new Dimension(120, 120));
				terrain[i][j].setBounds(0, 0, 0, 0);
				//terrain[i][j].setBackground(Color.BLUE);
				numPiece++;
				System.out.println(numPiece);
			
			}
		}
	}
}