package theTowerofSorcerer;

import javax.swing.ImageIcon;

public abstract class Item extends Block{
	protected String name;
	protected abstract void act(Block acted);
	public Item(int x,int y){
		super(x,y);
	}
}

