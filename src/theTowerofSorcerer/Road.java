package theTowerofSorcerer;

import javax.swing.ImageIcon;

public class Road extends Block{

	public Road(int x,int y){
		super(x,y);
		blockType=ROAD;
		img=new ImageIcon("image/ground.png");
	}
}

