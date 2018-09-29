package theTowerofSorcerer;

import javax.swing.ImageIcon;

public class Wall extends Block{

	public void draw(int x, int y) {
		// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
		
	}
	public Wall(int x,int y){
		super(x,y);
		blockType=WALL;
		img=new ImageIcon("image/wall.png");
	}
}

