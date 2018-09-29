package theTowerofSorcerer;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Stone extends Item
{
	public static final int ATK=0,DFS=1,HP=2,SWORD=3,SHIELD=4;
	protected int stoneType;
	protected int effect;
	@Override
	protected void act(Block acted) 
	{
		// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
		if(acted instanceof Person)
		{
			switch(stoneType)
			{
			case ATK:
			{
				((Person) acted).incAtk(effect);
			}break;
			case DFS:
			{
				((Person)acted).incDfs(effect);
			}break;
			case HP:
			{
				((Person)acted).incHP(effect);
			}break;
			case SWORD:
			{
				((Person)acted).incAtk(effect);
			}break;
			case SHIELD:
			{
				((Person)acted).incDfs(effect);
			}break;
			default:break;
			}
		}
	}
	public int getEffect()
	{
		return effect;
	}
	public Stone(int x, int y)
	{
		super(x,y);
		blockType=ITEM;
		effect=10;
	}

}

class AtkStone extends Stone
{
	public AtkStone(int x, int y,int Effect) 
	{
		super(x, y);
		// TODO Auto-generated constructor stub
		stoneType=0;
		effect=Effect;
		img=new ImageIcon("image/atkstone.png");
	}
}
class DefStone extends Stone
{
	public DefStone(int x, int y,int Effect) 
	{
		super(x, y);
		// TODO Auto-generated constructor stub
		stoneType=1;
		effect=Effect;
		img=new ImageIcon("image/defencestone.png");
	}
}
class Hp extends Stone
{
	public Hp(int x, int y,int Effect) {
		super(x, y);
		// TODO Auto-generated constructor stub
		stoneType=2;
		effect=Effect;
		if(Effect < 300)
			img=new ImageIcon("image/redhp.png");
		else
			img=new ImageIcon("image/bluehp.png");
	}
}
class Sword extends Stone
{
	public Sword(int x, int y)
	{
		super(x, y);
		stoneType=3;
		effect=20;
		img=new ImageIcon("image/sword.png");
	}
}
class Shield extends Stone
{
	public Shield(int x, int y) 
	{
		super(x, y);
		// TODO Auto-generated constructor stub
		stoneType=4;
		effect=20;
		img=new ImageIcon("image/shield.png");
	}
}