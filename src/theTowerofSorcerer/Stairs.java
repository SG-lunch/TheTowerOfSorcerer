package theTowerofSorcerer;

import javax.swing.ImageIcon;

public class Stairs extends Block
{
	public static final int UP=0;
	public static final int DOWN=1;
	int direction;
	public Stairs(int x, int y,int dir) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.blockType=STAIRS;
		switch(dir)
		{
			case UP:
				img=new ImageIcon("image/upstairs.png");
				direction=UP;
				break;
			case DOWN:
				img=new ImageIcon("image/downstairs.png");
				direction=DOWN;
				break;
				
		}
	}

}
