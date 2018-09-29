package theTowerofSorcerer;

import javax.swing.ImageIcon;

public class Key extends Item{
	public static final int YELLOW=0,BLUE=1,RED=2;
	private int color;
	public int getColor(){
		return color;
	}
	@Override
	protected void act(Block acted) {
		// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
		if(acted.getBlkType()==NPC&&acted instanceof Door){
			Door d=(Door)acted;
			if(d.getColor()==color)d.open();
		}
	}

	public Key(int x, int y,int color)
	{
		super(x,y);
		blockType=ITEM;
		this.color=color;
		switch(color)
		{
			case 0:
				img=new ImageIcon("image/yellowkey.png");
				break;
			case 1:
				img=new ImageIcon("image/bluekey.png");
				break;
			case 2:
				img=new ImageIcon("image/redkey.png");
				break;
			default:break;
		}
	}
	
}

