package theTowerofSorcerer;

import javax.swing.ImageIcon;

public class Door extends NPC{
	public static final int YELLOW=0,BLUE=1,RED=2;
	private int color;
	public int getColor(){
		return color;
	}
	public void open(){
		blockType=ROAD;
		//锟斤拷要锟侥憋拷位图锟斤拷源锟斤拷锟酵匡拷锟斤拷伪装锟斤拷一锟斤拷road
	}
	public void draw(int x, int y) {
		// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
		
	}
	public Door(int x,int y,int color){
		super(x,y);
		blockType=NPC;
		this.color=color;
		switch(color)
		{
			case Door.YELLOW:
				img=new ImageIcon("image/yellowdoor.png");
				break;
			case Door.BLUE:
				img=new ImageIcon("image/bluedoor.png");
				break;
			case Door.RED:
				img=new ImageIcon("image/reddoor.png");
				break;
		}
	}
}
