package fenetreVue;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class gameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton [][]terrain;
	
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
		int /*x=25, y=25,*/ numPiece=0;
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {
				
				terrain[i][j]= new JButton(new ImageIcon("p1.jpg"));
				terrain[i][j].setPreferredSize(new Dimension(120, 120));
				//terrain[i][j].setBounds(x, y, 158, 158);
				terrain[i][j].setBackground(Color.DARK_GRAY);
				numPiece++;
				System.out.println(numPiece);
				//x+=25;
			}
			//y+=25;
		}
	}
}
