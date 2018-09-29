package theTowerofSorcerer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class Person extends Warrior{
	public JButton b;
	public JFrame m;
	public JPanel j;
	public Graphics g;
	public JTextArea d;
	public JLabel []jlab;
	public JLabel perbagimglab[], perbagtextlab[];
	public JPanel permap, perbagimg, perbagtext;
	public static volatile boolean whetherBattle=false;
	int experience;
	int level;
    int coins;
    int redkeys=1;
    int yellowkeys=1;
    int bluekeys=1;
	private ArrayList<Item> items=new ArrayList();
	public ArrayList<Item> getItems(){
		return items;
	}
	public Item getItemByNum(int num){
		
		if(num>=items.size()) return null;
		return items.get(num);
	}
	public boolean hasAnItem(int item_type){
		return items.get(0)instanceof Item;//锟皆猴拷锟�
	}
	public Item getItemByType(int item_type){
		return items.get(0);//锟皆猴拷锟�
	}
	public boolean canBattle(Warrior enemy){
		if(enemy.getDfs()>=attack) return false;
		double turns=enemy.getHP()/(attack-enemy.getDfs());
		int turn=(int)Math.ceil(turns);
		int damage=turn*Math.max(0, enemy.getAtk()-defence);
		if(damage<life)
		return true;
		else return false;
	}
	public void incMoney(int incM){
		money+=incM;
	}
	public boolean decMoney(int decM){
		if(money-decM<0) return false;
		money-=decM;
		return true;
	}
	public int battleWith(Warrior enemy){//锟斤拷锟斤拷锟角凤拷胜锟斤拷,锟斤拷锟斤拷锟斤拷锟叫讹拷锟杰凤拷战锟斤拷
		if(!canBattle(enemy)) return NOT_END;
		decHP(enemy.getAtk()-defence);
		if(whetherDie()) return LOSE;
		enemy.decHP(getAtk()-enemy.getDfs());
		if(enemy.whetherDie()) return WIN;
		return NOT_END;
	}
	public void rob(Monster enemy){
		incExp(enemy.getExpGive());
		incMoney(enemy.money);
	}
	public int getExp(){
		return experience;
	}
	public void incExp(int increase){
		experience+=increase;
	}
	public int getLevel(){
		return level;
	}
	public void levelUp(){
		level++;
	}
	public void incHP(int hp){
		life+=hp;
	}
	public void incDfs(int dfs){
		setDefence(defence+dfs);
	}
	public void incAtk(int atk){
		setAttack(attack+atk);
	}
	public boolean move(int dir,TowerMap map){//锟斤拷锟斤拷锟狡讹拷锟角凤拷晒锟�
		Block temp=new Road(0,0);
		boolean hasMoved=false;
		switch (dir){
		case UP:
			if(y>0)
			{
				
				temp=map.getBlocks()[x][y-1];
				hasMoved=true;
			}
			
			break;
		case DOWN:
			if(y<Lib.Col-1)
			{
				
				temp=map.getBlocks()[x][y+1];
				hasMoved=true;
			}
			break;
		case LEFT:
			if(x>0)
			{
				
				temp=map.getBlocks()[x-1][y];
				hasMoved=true;
			}
			break;
		case RIGHT:
			if(x<Lib.Row-1)
			{
				
				temp=map.getBlocks()[x+1][y];
				hasMoved=true;
			}
			break;
		}
		if(hasMoved){
			
		switch(temp.getBlkType()){
		case ROAD:{
			Block.swap(temp, this);
			
			final Block t = temp;
			new Thread(()->
			{
				SwingUtilities.invokeLater(()->
				{
					jlab[Lib.MainCharacter.x*Lib.Col + Lib.MainCharacter.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y].img);
					jlab[t.x*Lib.Col + t.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[t.x][t.y].img);
				});
			}).start();
			
			return true;
		}
		case WALL:{
			return false;
		}
		case NPC:{
			if(temp instanceof Door){
				outer:
				for(Item t:items){
					if((t instanceof Key)&&((Key)t).getColor()==((Door)temp).getColor()){
						
						switch(((Door)temp).getColor())
						{
							case 0:
								if(yellowkeys==0){
									Lib.diagcontent = "没有黄色钥匙，无法开门";
									d.setText("没有黄色钥匙，无法开门");
									break outer;
								}
									
								t.act(temp);
								yellowkeys--;
								Lib.diagcontent = "使用一把黄钥匙打开了门！";
								//d.setText("使用一把黄钥匙打开了门！");
								Block.swap(temp, this);
								
								final Block tt = temp;
								new Thread(()->
								{
									SwingUtilities.invokeLater(()->
									{
										d.setText("使用一把黄钥匙打开了门！");
										jlab[Lib.MainCharacter.x*Lib.Col + Lib.MainCharacter.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y].img);
										jlab[tt.x*Lib.Col + tt.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[tt.x][tt.y].img);
										perbagimglab[2].setText(""+Lib.MainCharacter.yellowkeys);
									});
								}).start();
								
								break outer;
							case 1:
								if(bluekeys==0){
									Lib.diagcontent = "没有蓝色钥匙，无法开门";
									d.setText("没有蓝色钥匙，无法开门");
									break outer;
								}
								t.act(temp);
								bluekeys--;
								Block.swap(temp, this);
								Lib.diagcontent = "使用一把蓝钥匙打开了门！";
								//d.setText("使用一把蓝钥匙打开了门！");
								
								final Block tt1 = temp;
								new Thread(()->
								{
									SwingUtilities.invokeLater(()->
									{
										d.setText("使用一把蓝钥匙打开了门！");
										jlab[Lib.MainCharacter.x*Lib.Col + Lib.MainCharacter.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y].img);
										jlab[tt1.x*Lib.Col + tt1.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[tt1.x][tt1.y].img);
										perbagimglab[5].setText(""+Lib.MainCharacter.bluekeys);
									});
								}).start();
								
								break outer;
							case 2:
								if(redkeys==0){
									Lib.diagcontent = "没有红色钥匙，无法开门";
									d.setText("没有红色钥匙，无法开门");
									break outer;
								}
								t.act(temp);
								redkeys--;
								Block.swap(temp, this);
								Lib.diagcontent = "使用一把红钥匙打开了门！";
								//d.setText("使用一把红钥匙打开了门！");
								
								final Block tt11 = temp;
								new Thread(()->
								{
									SwingUtilities.invokeLater(()->
									{
										d.setText("使用一把红钥匙打开了门！");
										jlab[Lib.MainCharacter.x*Lib.Col + Lib.MainCharacter.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y].img);
										jlab[tt11.x*Lib.Col + tt11.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[tt11.x][tt11.y].img);
										perbagimglab[8].setText(""+Lib.MainCharacter.redkeys);
									});
								}).start();
								
								break outer;
						}
					}
				}
				
			}
			else if(temp instanceof Shop){
				System.out.println("shop");
				Shopdialog dg=new Shopdialog(m,true);
				dg.show();
			}
			else if(temp instanceof HintGiver){
				//如果方便可以顺手完成下
				((HintGiver)temp).say();
			}
			else return false;
			
		}break;
		case STAIRS:
		{
			//int nextx=temp.x+1;
			//int nexty=temp.y;
			//System.out.println(nextx+" "+nexty);
			if(((Stairs)temp).direction==Stairs.UP)
			{
			//	Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y]=new Road(Lib.MainCharacter.x,Lib.MainCharacter.y);
			//	Lib.curfloor++;
			//	int nextx=Lib.floors[Lib.curfloor].upstairX;
			//	int nexty=Lib.floors[Lib.curfloor].upstairY;
			//	Lib.floors[Lib.curfloor].getBlocks()[nextx][nexty]=Lib.MainCharacter;
			//	Lib.MainCharacter.x=nextx;
			//	Lib.MainCharacter.y=nexty;
				
				Lib.floors[Lib.curfloor].getBlocks()[this.x][this.y]=new Road(this.x,this.y);
				Lib.curfloor++;
				int nextx=Lib.floors[Lib.curfloor].upstairX;
				int nexty=Lib.floors[Lib.curfloor].upstairY;
				Lib.floors[Lib.curfloor].getBlocks()[nextx][nexty]=this;
				this.x=nextx;
				this.y=nexty;
			}
			else
			{
			//	Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y]=new Road(Lib.MainCharacter.x,Lib.MainCharacter.y);
			//	Lib.curfloor--;
			//	int nextx=Lib.floors[Lib.curfloor].downstairX;
			//	int nexty=Lib.floors[Lib.curfloor].downstairY;
			//	Lib.floors[Lib.curfloor].getBlocks()[nextx][nexty]=Lib.MainCharacter;
			//	Lib.MainCharacter.x=nextx;
			//	Lib.MainCharacter.y=nexty;
				
				Lib.floors[Lib.curfloor].getBlocks()[this.x][this.y]=new Road(this.x,this.y);
				Lib.curfloor--;
				int nextx=Lib.floors[Lib.curfloor].downstairX;
				int nexty=Lib.floors[Lib.curfloor].downstairY;
				Lib.floors[Lib.curfloor].getBlocks()[nextx][nexty]=this;
				this.x=nextx;
				this.y=nexty;
			}
			
			new Thread(()->
			{
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				SwingUtilities.invokeLater(()->
				{
					perbagtextlab[1].setText(""+Lib.curfloor);
					for(int i = 0; i < Lib.Row; ++i)
						for(int j = 0; j < Lib.Col; ++j)
						{
							//here may need to adjust the size of the icons
							//jlab[i*Lib.Col + j].setIcon(new ImageIcon());
							jlab[i*Lib.Col + j].setIcon(Lib.floors[Lib.curfloor].getBlocks()[i][j].img);
							//jlab[i*Lib.Col + j].repaint();
						}
					permap.repaint();
					perbagtextlab[1].repaint();
				});
			}).start();

		}break;
		case ITEM:{
			if(temp instanceof Key)
			{
				items.add((Key)temp);
				
				int color=((Key)temp).getColor();
				switch(color)
				{
					case 0:
						Lib.diagcontent="得到一把黄钥匙";
						d.setText("得到一把黄钥匙");
						yellowkeys++;
						break;
					case 1:
						Lib.diagcontent="得到一把蓝钥匙";
						d.setText("得到一把蓝钥匙");
						bluekeys++;
						break;
					case 2:
						Lib.diagcontent="得到一把红钥匙";
						d.setText("得到一把红钥匙");
						redkeys++;
						break;
				}
				temp=new Road(temp.x,temp.y);
				swap(temp,this);
				
				final Block t = temp;
				new Thread(()->
				{
					SwingUtilities.invokeLater(()->
					{
						jlab[Lib.MainCharacter.x*Lib.Col + Lib.MainCharacter.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y].img);
						jlab[t.x*Lib.Col + t.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[t.x][t.y].img);
						perbagimglab[2].setText(""+Lib.MainCharacter.yellowkeys);
						perbagimglab[5].setText(""+Lib.MainCharacter.bluekeys);
						perbagimglab[8].setText(""+Lib.MainCharacter.redkeys);
					});
				}).start();
				
				return true;
			}
			else if(temp instanceof Stone)
			{
				String text = "";
				((Stone)temp).act(this);
				switch(((Stone)temp).stoneType)
				{
				case Stone.ATK:
					text="得到了宝石！攻击力提升了";
					break;
				case Stone.DFS:
					text="得到了宝石！防御力提升了";
					break;
				case Stone.HP:
					text="得到了药水！生命值提升了";
					break;
				case Stone.SWORD:
					text="得到了圣剑！攻击力提升了";
					break;
				case Stone.SHIELD:
					text="得到了圣盾！防御力提升了";
					break;
				}
				text+=((Stone)temp).getEffect();
				text+="点！";
				Lib.diagcontent=text;
				d.setText(text);
				temp=new Road(temp.x,temp.y);
				swap(temp,this);
				
				final Block t = temp;
				new Thread(()->
				{
					SwingUtilities.invokeLater(()->
					{
						jlab[Lib.MainCharacter.x*Lib.Col + Lib.MainCharacter.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[Lib.MainCharacter.x][Lib.MainCharacter.y].img);
						jlab[t.x*Lib.Col + t.y].setIcon(Lib.floors[Lib.curfloor].getBlocks()[t.x][t.y].img);
						perbagtextlab[5].setText(""+Lib.MainCharacter.life);
						perbagtextlab[7].setText(""+Lib.MainCharacter.attack);
						perbagtextlab[9].setText(""+Lib.MainCharacter.defence);
					});
				}).start();
				
				//permap.repaint();
				return true;
			}
		}break;
		case WARRIOR:{
			if(!canBattle((Warrior)temp))
			{
				Lib.diagcontent="怪物的生命值为"+((Warrior) temp).getHP()+"，攻击力为"+((Warrior) temp).getAtk()+"，防御力为"+((Warrior) temp).getDfs()+"，你无法与之战斗，请继续修炼！";
				d.setText("怪物的生命值为"+((Warrior) temp).getHP()+"，攻击力为"+((Warrior) temp).getAtk()+"，防御力为"+((Warrior) temp).getDfs()+"，你无法与之战斗，请继续修炼！");
				return false;
			}
				
			Battle((Warrior)temp);
			//贾神完成战斗逻辑
			temp=new Road(temp.x,temp.y);
			swap(temp,this);
			System.out.println("Shakalaka bombom!");
		}break;
		default:break;
		}
		}
		return false;
		
	}
	
	void Battle(Warrior enemy)
	{
		whetherBattle=true;
		new Thread(()->
		{
			SwingUtilities.invokeLater(()->
			{
				g.setColor(new Color(0,0,0));
				g.fillRect(0, 100, 500, 200);
				g.drawImage(Lib.MainCharacter.img.getImage(), 80, 180, j);
				g.drawImage(enemy.img.getImage(),420,180,j);
				g.drawImage(Lib.battleStart, 180, 100,j );
			});
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int eneHP=enemy.getHP();
			System.out.println(eneHP);
			int eneDmg=attack-enemy.getDfs();
			int myDmg=Math.max(0, enemy.getAtk()-defence);
			while(enemy.getHP()>0)
			{
				SwingUtilities.invokeLater(()->
				{
					g.setColor(new Color(0,0,0));
					g.fillRect(0, 100, 500, 200);	//cover the last interface(all info need to be drawn again)
					g.drawImage(Lib.battleStart, 180, 100,j );
					g.drawImage(Lib.MainCharacter.img.getImage(), 80, 120, j);
					g.drawImage(enemy.img.getImage(),420,120,j);
					g.setColor(new Color(255,255,255));
					g.drawString("HP:   "+life, 80, 180);
					g.drawString("攻击力:  "+attack, 80, 200);
					g.drawString("防御力:  "+defence, 80, 220);
					g.drawString("HP:   "+enemy.getHP(), 400, 180);
					g.drawString("攻击力:  "+enemy.getAtk(), 400, 200);
					g.drawString("防御力:  "+enemy.getDfs(), 400, 220);
					enemy.decHP(eneDmg);
					if(enemy.getHP()>0)
						decHP(myDmg);
				});
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			SwingUtilities.invokeLater(()->
			{
				g.setColor(new Color(0,0,0));
				g.fillRect(0, 100, 500, 200);
				g.drawImage(Lib.battleWin, 180, 140,j );
				g.setColor(new Color(255,255,255));
				Lib.diagcontent="战斗胜利！获得经验："+enemy.getExp()+"，"+"获得金钱："+enemy.getMoney();
			});
			experience+=enemy.getExp();
			coins+=enemy.getMoney();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SwingUtilities.invokeLater(()->
			{
				g.clearRect(0, 100, 500, 200);
				d.setText(Lib.diagcontent);
				for(int i = 0; i < Lib.Row; ++i)
					for(int j = 0; j < Lib.Col; ++j)
					{
						//here may need to adjust the size of the icons
						jlab[i*Lib.Col + j].setIcon(Lib.floors[Lib.curfloor].getBlocks()[i][j].img);
					}
				permap.repaint();
				
				for(int i = 0; i < Lib.bagimgnum; ++i)	//link to bag images
					perbagimglab[i * 3].setIcon(new ImageIcon("image" + Lib.imgname[i]));
					//here need to adjust size
				
				perbagimglab[1].setText("X");
				perbagimglab[2].setText(""+Lib.MainCharacter.yellowkeys);
				perbagimglab[4].setText("X");
				perbagimglab[5].setText(""+Lib.MainCharacter.bluekeys);
				perbagimglab[7].setText("X");
				perbagimglab[8].setText(""+Lib.MainCharacter.redkeys);
				perbagimg.repaint();
				
				//for(int i=0;i<2*Lib.bagtextnum;++i)
					//perbagtextlab[i].setText("");
				perbagtextlab[0].setText("Floor:");
				perbagtextlab[1].setText(""+Lib.curfloor);
				perbagtextlab[2].setText("Level:");
				perbagtextlab[3].setText(""+Lib.MainCharacter.level);
				perbagtextlab[4].setText("HP:");
				perbagtextlab[5].setText(""+Lib.MainCharacter.life);
				perbagtextlab[6].setText("Attack:");
				perbagtextlab[7].setText(""+Lib.MainCharacter.attack);
				perbagtextlab[8].setText("Defence:");
				perbagtextlab[9].setText(""+Lib.MainCharacter.defence);
				perbagtextlab[10].setText("Coin:");
				perbagtextlab[11].setText(""+Lib.MainCharacter.coins);
				perbagtextlab[12].setText("EXPerience:");
				perbagtextlab[13].setText(""+Lib.MainCharacter.experience);
				perbagtext.repaint();
				
				
				
				//d.setText(Lib.diagcontent);
				//d.repaint();
			});
			whetherBattle=false;
		}).start();
	}
	
	void Buy(int type)
	{
		if(coins<Lib.shopMoney)
		{
			Lib.diagcontent="金币不足，无法购买。";
			d.setText("金币不足，无法购买。");
			return;
		}
		if(type==Shop.HP)
		{
			coins-=Lib.shopMoney;
			Lib.diagcontent=Lib.buyHP;
			SwingUtilities.invokeLater(()->d.setText(Lib.buyHP));
			incHP(Lib.shopHP);
		}
		if(type==Shop.ATK)
		{
			coins-=Lib.shopMoney;
			Lib.diagcontent=Lib.buyAtk;
			SwingUtilities.invokeLater(()->d.setText(Lib.buyAtk));
			attack+=Lib.shopAtk;
		}
		if(type==Shop.DFS)
		{
			coins-=Lib.shopMoney;
			Lib.diagcontent=Lib.buyDfs;
			SwingUtilities.invokeLater(()->d.setText(Lib.buyDfs));
			defence+=Lib.shopDfs;
		}
		
		new Thread(()->
		{
			SwingUtilities.invokeLater(()->
			{
				perbagtextlab[5].setText(""+Lib.MainCharacter.life);
				perbagtextlab[7].setText(""+Lib.MainCharacter.attack);
				perbagtextlab[9].setText(""+Lib.MainCharacter.defence);
				perbagtextlab[11].setText(""+Lib.MainCharacter.coins);
				perbagtext.repaint();
			});
		}).start();
	}
	public Person(int atk,int dfs,int hp,int x,int y){
		
		super(x,y);
		//items.add(new AtkStone(0,0));
		setAttack(atk);
		setDefence(dfs);
		setHP(hp);
		level=1;
		experience=0;
		money=0;
		coins=0;
		items.add(new Key(-1,-1,Key.YELLOW));
		items.add(new Key(-1,-1,Key.RED));
		items.add(new Key(-1,-1,Key.BLUE));
		img=new ImageIcon("image/man.png");
	}
}
