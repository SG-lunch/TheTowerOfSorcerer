package theTowerofSorcerer;

import javax.swing.ImageIcon;

public class Shop extends NPC{
	public static final int ATK=0,DFS=1,HP=2;
	private int sellType;
	private int cost,effect;
	public Shop(int x,int y)
	{
		super(x,y);
		blockType=NPC;
		img=new ImageIcon("image/salesman.png");
	}
	public boolean sell(Block sellee){//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷锟角凤拷晒锟�
		if(!(sellee instanceof Person)) return false;
		Person temp=(Person)sellee;
		if(temp.getMoney()<cost) return false;
		switch(sellType){
		case ATK:{
			temp.decMoney(cost);
			temp.incAtk(effect);
		}break;
		case DFS:{
			temp.decMoney(cost);
			temp.incDfs(effect);
		}break;
		case HP:{
			temp.decMoney(cost);
			temp.incHP(effect);
		}break;
		default:return false;
		}
		return true;
		
	}
	public void say(){
		String saying="锟斤拷锟斤拷"+cost+"元锟斤拷锟斤拷锟杰革拷锟斤拷锟斤拷锟斤拷"+effect+"锟斤拷锟�"+convert(sellType);
		//锟斤拷锟斤拷锟斤拷锟斤拷图锟斤拷应锟矫帮拷锟斤拷浠帮拷锟斤拷
	}
	private String convert(int type){
		
		switch(type){
		case ATK:{
			return "锟斤拷锟斤拷锟斤拷";
		}
		case DFS:{
			return "锟斤拷锟斤拷锟斤拷";
		}
		case HP:{
			return "HP";
		}
		default:return "锟斤拷锟斤拷";
		}
	}
	
}
