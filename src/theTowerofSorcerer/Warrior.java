package theTowerofSorcerer;

import javax.swing.ImageIcon;

public abstract class Warrior extends Block {
	public Warrior(int x, int y) {
		super(x, y);
		// TODO 锟皆讹拷锟斤拷锟缴的癸拷锟届函锟斤拷锟斤拷锟�
		this.blockType=Block.WARRIOR;
	}
	protected int attack,defence,life,money,exp;
	public static final int WIN=0,LOSE=1,NOT_END=2;
	public int getMoney(){
		return money;
	}
	public void setMoney(int m){
		if(m<0) return;
		money=m;
	}
	public int getExp(){
		return exp;
	}
	public void setExp(int m){
		if(m<0) return;
		exp=m;
	}
	public int getAtk(){
		return attack;
	}
	protected void setAttack(int atk){
		if(atk<0){
			attack=0;
			return;
		}
		attack=atk;
	}
	public int getDfs(){
		return defence;
	}
	protected void setDefence(int dfs){
		if(dfs<0){
			defence=0;
			return;
		}
		defence=dfs;
	}
	public int getHP(){
		return life;
	}
	protected void setHP(int hp){
		life=hp;
		if(hp<0) hp=0;
	}
	public boolean decHP(int lf){
		life-=lf;
		if(life<0) life=0;
		return whetherDie();
	}
	public boolean whetherDie(){
		return life==0;
	}
	
}
//怪物的参数需要设计
class BigBat extends Warrior
{

	public BigBat(int x, int y) {
		super(x, y);
		setHP(150);
		setAttack(65);
		setDefence(30);
		setMoney(10);
		setExp(8);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/bat2.png");
		//set all the date here!
	}
}
class LittleBat extends Warrior
{
	public LittleBat(int x, int y) {
		super(x, y);
		setHP(100);
		setAttack(20);
		setDefence(5);
		setMoney(3);
		setExp(3);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/bat1.png");
		//set all the date here!
	}
}
class BoneCaptain extends Warrior
{

	public BoneCaptain(int x, int y) {
		super(x, y);
		setHP(400);
		setAttack(90);
		setDefence(50);
		setMoney(15);
		setExp(12);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/bonecaptain.png");
		//set all the date here!
	}
}
class BoneMan extends Warrior
{

	public BoneMan(int x, int y) {
		super(x, y);
		setHP(110);
		setAttack(25);
		setDefence(5);
		setMoney(5);
		setExp(4);
		
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/boneman.png");
		//set all the date here!
	}
}
class Boss extends Warrior
{

	public Boss(int x, int y) {
		super(x, y);
		setHP(50);
		setAttack(20);
		setDefence(1);
		setMoney(1);
		setExp(1);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/boss.png");
		//set all the date here!
	}
}
class GreenSlam extends Warrior
{

	public GreenSlam(int x, int y) {
		super(x, y);
		setHP(50);
		setAttack(20);
		setDefence(1);
		setMoney(1);
		setExp(1);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/slam1.png");
		//set all the date here!
	}
}
class RedSlam extends Warrior
{

	public RedSlam(int x, int y) {
		super(x, y);
		setHP(70);
		setAttack(15);
		setDefence(2);
		setMoney(2);
		setExp(2);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/slam2.png");
		//set all the date here!
	}
}
class BlackSlam extends Warrior
{

	public BlackSlam(int x, int y) {
		super(x, y);
		setHP(200);
		setAttack(35);
		setDefence(10);
		setMoney(5);
		setExp(5);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/slam3.png");
		//set all the data here
	}
	
}

class Sorceress extends Warrior
{

	public Sorceress(int x, int y) {
		super(x, y);
		setHP(125);
		setAttack(50);
		setDefence(25);
		setMoney(1);
		setExp(1);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/sorceress.png");
		//set all the data here
	}
	
}
class StoneMan extends Warrior
{

	public StoneMan(int x, int y) {
		super(x, y);
		setHP(50);
		setAttack(150);
		setDefence(90);
		setMoney(22);
		setExp(19);
		// TODO Auto-generated constructor stub
		img=new ImageIcon("image/stoneman.png");
		//set all the data here
	}
	
}

