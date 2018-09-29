package theTowerofSorcerer;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Block {
	public static final int ITEM=0;
	public static final int WARRIOR=1;
	public static final int NPC=2;
	public static final int STAIRS=3;
	public static final int WALL=18;
	public static final int ROAD=19;
	
	public static final int UP=5,DOWN=6,LEFT=7,RIGHT=8;
	
	ImageIcon img;
	protected int blockType;
	protected int x,y;
	public int getBlkType(){
		return blockType;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public static void swap(Block a,Block person){
		int tempx=a.getX();
		int tempy=a.getY();
		a.setX(person.x);
		a.setY(person.y);
		person.setX(tempx);
		person.setY(tempy);
		Lib.floors[Lib.curfloor].getBlocks()[person.x][person.y]=Lib.MainCharacter;
		Lib.floors[Lib.curfloor].getBlocks()[a.x][a.y]=new Road(a.x,a.y);
	}
	public Block(int x,int y){
		this.x=x;
		this.y=y;
	}
}

