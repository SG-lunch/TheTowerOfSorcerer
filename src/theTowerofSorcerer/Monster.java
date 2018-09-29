package theTowerofSorcerer;

public class Monster extends Warrior {
	private int expToGive;
	public int getExpGive(){
		return expToGive;
	}
	public void draw(int x, int y) {
		// TODO �Զ����ɵķ������
		
	}
	public Monster(int atk,int dfs,int hp,int money,int exp,int x,int y){
		super(x,y);
		setAttack(atk);
		setDefence(dfs);
		setHP(hp);
		this.money=money;
		expToGive=exp;
		
		blockType=WARRIOR;
	}

}

