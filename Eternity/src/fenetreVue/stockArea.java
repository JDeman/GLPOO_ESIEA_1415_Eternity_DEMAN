package fenetreVue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class stockArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton [][]terrain;
	
	/*//@Override
    public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("index.jpg");
        g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);       
        
  }*/
	
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
		int /*x=25, y=25,*/ numPiece=0;
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain.length; j++) {
				
				terrain[i][j]= new JButton(new ImageIcon("p" + numPiece + ".jpg"));
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