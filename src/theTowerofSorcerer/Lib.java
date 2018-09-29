package theTowerofSorcerer;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Lib 
{
	static String diagcontent="";
	static final int imgnums = 30;
	static final int Row = 11, Col = 11, floornum = 4;	//for the whole map
	static final int bagimgnum = 3, bagtextnum = 7;	//for the display of bag
	static String[] imgname;
	static TowerMap floors[] = null;
	static volatile int curfloor = 0;	// 0-3
	static String output;
	public static volatile Person MainCharacter=new Person(10,10,1000,10,5);
	public static Image battleStart,battleWin;
	public static final int shopHP=800,shopAtk=10,shopDfs=10,shopMoney=20;
	public static final String buyHP="Buy HP "+Lib.shopHP+" at the expense of "+Lib.shopMoney+" coins";
	public static final String buyAtk="Buy Atk "+Lib.shopAtk+" at the expense of "+Lib.shopMoney+" coins";
	public static final String buyDfs="Buy Dfs "+Lib.shopDfs+" at the expense of "+Lib.shopMoney+" coins";
	
 	static void init()
	{
		floors = new TowerMap[4];
		for(int i = 0; i < floornum; ++i)
			floors[i] = new TowerMap();
			
		imgname = new String [imgnums];
		imgname[0] = "/yellowkey.png";
		imgname[1] = "/bluekey.png";
		imgname[2] = "/redkey.png";
		imgname[3] = "/redhp.png";
		imgname[4] = "/bluehp.png";
		imgname[5] = "/sword.png";
		imgname[6] = "/shield.png";
		imgname[7] = "/man.png";
		imgname[8] = "/slam1.png";
		imgname[9] = "/slam2.png";
		imgname[10] = "/slam3.png";
		imgname[11] = "/boneman.png";
		imgname[12] = "/bonecaptain.png";
		imgname[13] = "/bat1.png";
		imgname[14] = "/bat2.png";
		imgname[15] = "/stoneman.png";
		imgname[16] = "/sorceress.png";
		imgname[17] = "/boss.png";
		imgname[18] = "/wall.png";
		imgname[19] = "/ground.png";
		imgname[20] = "/atkstone.png";
		imgname[21] = "/defencestone.png";
		imgname[22] = "/yellowdoor.png";
		imgname[23] = "/bluedoor.png";
		imgname[24] = "/reddoor.png";
		for(int k = 0; k < 4; ++k)
			for(int i = 0; i < Lib.Row; ++i)
				for(int j = 0; j < Lib.Col; ++j)
					floors[k].getBlocks()[i][j] = new Road(i, j);
		
	    Lib.floors[0].getBlocks()[10][5]=Lib.MainCharacter;
		/*
		# design our map from here
		*/
		
		/*
		# the first floor(floor[0])
		*/
	    
	    floors[0].downstairX=0;
	    floors[0].downstairY=1;
		Block[][] map=Lib.floors[0].getBlocks();
		map[0][0]=new Stairs(0,0,Stairs.UP);
		map[0][2]=new AtkStone(0,2,3);
		map[0][3]=new GreenSlam(0,3);
		map[0][4]=new RedSlam(0,4);
		map[0][5]=new GreenSlam(0,5);
		for(int i=0;i<10;i++)
			map[1][i]=new Wall(1,i);
		map[2][0]=new Hp(2,0,100);
		map[2][2]=new BoneMan(2,2);
		map[2][3]=new Door(2,3,Door.YELLOW);
		map[2][5]=new Wall(2,5);
		map[2][6]=new Hp(2,6,100);
		map[2][7]=new Key(2,7,Key.YELLOW);
		map[2][8]=new Hp(2,8,100);
		map[2][9]=new Wall(2,9);
		map[3][6]=new Hp(3,6,100);
		map[3][7]=new Key(3,7,Key.YELLOW);
		map[3][8]=new Hp(3,8,100);
		map[3][9]=new Wall(3,9);
		map[3][0]=new Key(3,0,Key.YELLOW);
		map[3][1]=new BoneMan(3,1);
		map[3][2]=new AtkStone(3,2,3);
		map[3][3]=new Wall(3,3);
		map[3][5]=new Wall(3,5);
		for(int i=0;i<=9;i++)
			map[4][i]=new Wall(4,i);
		map[4][1]=new Door(4,1,Door.YELLOW);
		map[4][4]=new Road(4,4);
		map[4][8]=new BlackSlam(4,8);
		map[5][0]=new Key(5,0,Key.YELLOW);
		map[5][1]=new BoneCaptain(5,1);
		map[5][3]=new Wall(5,3);
		map[5][5]=new Door(5,5,Key.YELLOW);
		map[5][6]=new Sorceress(5,6);
		map[5][7]=new GreenSlam(5,7);
		map[5][8]=new LittleBat(5,8);
		map[5][9]=new Wall(5,9);
		map[6][0]=new DefStone(6,0,3);
		map[6][2]=new Key(6,2,Key.BLUE);
		for(int i=3;i<10;i++)
			map[6][i]=new Wall(6,i);
		map[6][4]=new Road(6,4);
		for(int i=0;i<4;i++)
			map[7][i]=new Wall(7,i);
		map[7][2]=new Door(7,2,Door.YELLOW);
		map[8][1]=new BoneCaptain(8,1);
		for(int i=3;i<11;i++)
			map[8][i]=new Wall(8,i);
		map[8][9]=new Door(8,9,Door.YELLOW);
		map[8][5]=new Door(8,5,Door.RED);
		map[9][0]=new Hp(9,0,200);
		map[9][1]=new Hp(9,1,200);
		map[9][2]=new Key(9,2,Key.YELLOW);
		map[10][2]=new Key(10,2,Key.YELLOW);
		map[10][0]=new Hp(10,0,200);
		map[9][3]=new Wall(9,3);
		map[10][3]=new Wall(10,3);
		map[9][7]=new Wall(9,7);
		map[10][7]=new Wall(10,7);
		for(int i=8;i<11;i++)
			map[10][i]=new Key(10,i,Key.YELLOW);
		map[9][8]=new Key(9,8,Key.YELLOW);
		map[9][10]=new Key(9,10,Key.BLUE);
		
		
	
		 
		//the second floor(floor[1])
		floors[1].upstairX=10;
	    floors[1].upstairY=1;
	    floors[1].downstairX=9;
	    floors[1].downstairY=10;
		map=Lib.floors[1].getBlocks();
		map[10][0]=new Stairs(0,10,Stairs.DOWN);
		map[10][10]=new Stairs(10,10,Stairs.UP);
		map[0][3]=new Wall(0,3);
		map[0][7]=new Wall(0,7);
		map[0][8]=new Wall(0,8);
		map[0][9]=new Wall(0,9);
		map[0][10]=new Wall(0,10);
		map[1][3]=new Wall(1,3);
		map[1][7]=new Wall(1,7);
		map[2][3]=new Wall(2,3);
		map[2][4]=new Wall(2,4);
		map[2][6]=new Wall(2,6);
		map[2][7]=new Wall(2,7);
		map[2][9]=new Wall(2,9);
		map[3][0]=new Wall(3,0);
		map[3][2]=new Wall(3,2);
		map[3][3]=new Wall(3,3);
		map[3][7]=new Wall(3,7);
		map[3][9]=new Wall(3,9);
		map[4][3]=new Wall(4,3);
		map[4][4]=new Wall(4,4);
		map[4][5]=new Wall(4,5);
		map[4][7]=new Wall(4,7);
		map[4][9]=new Wall(4,9);
		map[5][0]=new GreenSlam(5,0);
		map[5][1]=new Wall(5,1);
		map[5][7]=new Wall(5,7);
		map[5][9]=new Wall(5,9);
		map[6][0]=new GreenSlam(6,0);
		map[6][1]=new Wall(6,1);
		map[6][2]=new Wall(6,2);
		map[6][3]=new Wall(6,3);
		map[6][4]=new Wall(6,4);
		map[6][5]=new Wall(6,5);
		map[6][9]=new Wall(6,9);
		map[7][5]=new Wall(7,5);
		map[7][6]=new Wall(7,6);
		map[7][8]=new Wall(7,8);
		map[7][9]=new Wall(7,9);
		map[8][0]=new Wall(8,0);
		map[8][1]=new Wall(8,1);
		map[8][2]=new Wall(8,2);
		map[8][3]=new Wall(8,3);
		map[8][5]=new Wall(8,5);
		map[8][9]=new Wall(8,9);
		map[9][0]=new Wall(9,0);
		map[9][5]=new Wall(9,5);
		map[9][9]=new Wall(9,9);
		map[10][2]=new Wall(10,2);
		map[10][3]=new Wall(10,3);
		map[10][4]=new Wall(10,4);
		map[10][5]=new Wall(10,5);
		map[10][9]=new Wall(10,9);
		map[2][0]=new Key(2,0,Key.YELLOW);
		map[1][1]=new Key(1,1,Key.RED);
		map[0][2]=new Key(0,2,Key.YELLOW);
		map[3][8]=new Key(3,8,Key.RED);
		map[4][8]=new Key(4,8,Key.BLUE);
		map[5][8]=new Key(5,8,Key.YELLOW);
		map[9][8]=new Key(9,8,Key.RED);
		map[10][8]=new Key(10,8,Key.BLUE);
		map[1][0]=new RedSlam(1,0);
		map[0][1]=new RedSlam(0,1);
		map[5][4]=new RedSlam(5,4);
		map[8][6]=new RedSlam(8,6);
		map[8][8]=new RedSlam(8,8);
		map[3][10]=new RedSlam(3,10);
		map[5][10]=new RedSlam(5,10);
		map[2][1]=new BoneMan(2,1);
		map[3][5]=new BoneMan(3,5);
		map[0][0]=new Sword(0,0);
		map[5][3]=new LittleBat(5,3);
		map[5][5]=new LittleBat(5,5);
		map[1][9]=new LittleBat(1,9);
		map[4][10]=new LittleBat(4,10);
		map[9][7]=new LittleBat(9,7);
		map[8][4]=new LittleBat(8,4);
		map[0][5]=new Shop(0,5);
		map[3][1]=new Door(3,1,Door.YELLOW);
		map[2][5]=new Door(2,5,Door.BLUE);
		map[7][7]=new Door(7,7,Door.RED);
		map[10][7]=new Hp(10,7,500);
		map[10][6]=new AtkStone(10,6,3);
		map[9][6]=new DefStone(9,6,3);
	
		
		// the third floor(floor[2])
		
		map=Lib.floors[2].getBlocks();
		Lib.floors[2].upstairX=9;
		Lib.floors[2].upstairY=10;
		Lib.floors[2].downstairX=9;
		Lib.floors[2].downstairY=0;
		map[10][0]=new Stairs(10,0,Stairs.UP);
		map[10][10]=new Stairs(10,10,Stairs.DOWN);
		for(int i=1;i<=10;i++) {
			map[i][1]=new Wall(i,1);
			map[i][9]=new Wall(i,9);
		}
		for(int i=0;i<10;i++) {
			map[i][3]=new Wall(i,3);
			map[i][7]=new Wall(i,7);
		}
		map[2][4]=new Wall(2,4);
		map[2][6]=new Wall(2,6);
		map[5][4]=new Wall(5,4);
		map[5][6]=new Wall(5,6);
		map[8][4]=new Wall(8,4);
		map[8][6]=new Wall(8,6);
		map[1][0]=new Door(1,0,Door.YELLOW);
		map[1][2]=new Door(1,2,Door.YELLOW);
		map[1][8]=new Door(1,8,Door.YELLOW);
		map[1][10]=new Door(1,10,Door.YELLOW);
		map[6][0]=new RedSlam(6,0);
		map[6][10]=new RedSlam(6,10);
		map[4][0]=new LittleBat(4,0);
		map[5][0]=new LittleBat(5,0);		
		map[4][10]=new LittleBat(4,10);
		map[5][10]=new LittleBat(5,10);
		map[0][1]=new BlackSlam(0,1);
		map[0][9]=new BlackSlam(0,9);
		map[10][3]=new BlackSlam(10,3);
		map[10][7]=new BlackSlam(10,7);
		map[3][2]=new BoneMan(3,2);
		map[3][8]=new BoneMan(3,8);
		map[4][2]=new Hp(4,2,300);
		map[5][2]=new Hp(5,2,300);
		map[4][8]=new Hp(4,8,300);
		map[5][8]=new Hp(5,8,300);
		map[9][4]=new Key(9,4,Key.YELLOW);
		map[9][6]=new Key(9,6,Key.YELLOW);
		map[8][5]=new Door(8,5,Door.YELLOW);
		map[7][5]=new Door(7,5,Door.RED);
		map[6][5]=new StoneMan(6,5);
		map[7][4]=new Sorceress(7,4);
		map[7][6]=new Sorceress(7,6);
		map[6][4]=new AtkStone(6,4,3);
		map[6][6]=new AtkStone(6,6,3);
		map[5][5]=new Door(5,5,Door.BLUE);
		map[4][5]=new StoneMan(4,5);
		map[3][5]=new BoneCaptain(3,5);
		map[4][4]=new BoneCaptain(4,4);
		map[4][6]=new BoneCaptain(4,6);
		map[3][4]=new DefStone(3,4,3);
		map[3][6]=new DefStone(3,6,3);
		map[2][5]=new StoneMan(2,5);
		map[1][5]=new StoneMan(1,5);
		map[0][5]=new Hp(0,5,150);
		map[0][6]=new Hp(0,6,150);
		map[0][4]=new Hp(0,4,150);
		map[1][4]=new AtkStone(1,4,3);
		map[1][6]=new AtkStone(1,6,3);
		
		
		//the forth floor(floor[3])
		
		map=Lib.floors[3].getBlocks();
		Lib.floors[3].upstairX=9;
		Lib.floors[3].upstairY=0;
		Lib.floors[3].downstairX=-1;
		Lib.floors[3].downstairY=-1;
		map[10][0]=new Stairs(10,0,Stairs.DOWN);
		for(int i = 0; i < 7; ++i)
			map[i][1]=new Wall(i,1);
		map[6][2]=new Wall(6,2);
		map[7][2]=new Wall(7,2);
		map[8][2]=new Wall(8,2);
		map[9][2]=new Wall(9,2);
		map[8][0]=new Wall(8,0);
		map[8][1]=new Wall(8,1);
		for(int i = 0; i < 5; ++i)
			map[i][3]=new Wall(i,3);
		map[4][4]=new Wall(4,4);
		map[6][4]=new Wall(6,4);
		map[7][4]=new Wall(7,4);
		map[8][4]=new Wall(8,4);
		map[9][4]=new Wall(9,4);
		map[4][5]=new Wall(4,5);
		map[6][5]=new Wall(6,5);
		map[2][6]=new Wall(2,6);
		map[3][6]=new Wall(3,6);
		map[4][6]=new Wall(4,6);
		map[6][6]=new Wall(6,6);
		map[8][6]=new Wall(8,6);
		map[9][6]=new Wall(9,6);
		map[10][6]=new Wall(10,6);
		map[2][7]=new Wall(2,7);
		map[6][7]=new Wall(6,7);
		map[8][8]=new Wall(8,8);
		map[10][8]=new Wall(10,8);
		map[2][9]=new Wall(2,9);
		map[2][10]=new Wall(2,10);
		map[8][10]=new Wall(8,10);
		map[9][10]=new Wall(9,10);
		map[10][10]=new Wall(10,10);
		map[3][1]=new Door(3,1,Door.YELLOW);
		map[8][5]=new Door(8,5,Door.YELLOW);
		map[2][8]=new Door(2,8,Door.YELLOW);
		map[9][8]=new Door(9,8,Door.YELLOW);
		map[8][9]=new Door(8,9,Door.RED);
		map[9][9]=new Door(9,9,Door.RED);
		map[8][7]=new Door(8,7,Door.BLUE);
		map[10][2]=new LittleBat(10,2);
		map[8][3]=new LittleBat(8,3);
		map[9][5]=new LittleBat(9,5);
		map[5][5]=new LittleBat(5,5);
		map[6][3]=new BlackSlam(6,3);
		map[7][3]=new BlackSlam(7,3);
		map[5][6]=new BoneMan(5,6);
		map[2][4]=new BoneCaptain(2,4);
		map[3][5]=new BoneCaptain(3,5);
		map[3][9]=new BoneCaptain(3,9);
		map[4][10]=new BoneCaptain(4,10);
		map[2][0]=new BigBat(2,0);
		map[4][0]=new BigBat(4,0);
		map[3][2]=new Sorceress(3,2);
		map[1][4]=new Sorceress(1,4);
		map[0][5]=new Sorceress(0,5);
		map[0][8]=new Sorceress(0,8);
		map[1][9]=new Sorceress(1,9);
		map[3][8]=new StoneMan(3,8);
		map[7][8]=new StoneMan(7,8);
		map[7][9]=new StoneMan(7,9);
		map[0][9]=new Key(0,9,Key.YELLOW);
		map[1][10]=new Key(1,10,Key.YELLOW);
		map[10][7]=new Key(10,7,Key.YELLOW);
		map[0][10]=new Key(0,10,Key.BLUE);
		map[0][2]=new Hp(0,2,150);
		map[0][4]=new Hp(0,4,300);
		map[1][2]=new AtkStone(1,2,3);
		map[5][0]=new AtkStone(5,0,3);
		map[6][0]=new DefStone(6,0,3);
		map[9][7]=new DefStone(9,7,3);
		map[1][4]=new Shield(3,4);
		//map[10][9]=new Boss
		
	// test start
		
		
		
		
	// test finish	
		
		/*
		
		for(int k = 0; k < floornum; ++k)
			for(int i = 0; i < Row; ++i)
				for(int j = 0; j < Col; ++j)	
				{	
					floors[k].getBlocks()[i][j].img = new ImageIcon("image" + imgname[floors[k].getBlocks()[i][j].getBlkType()]);
					floors[k].getBlocks()[i][j].img.setImage(floors[k].getBlocks()[i][j].img.getImage().getScaledInstance(475/Lib.Col,400/Lib.Row,Image.SCALE_DEFAULT));
				}*/
		battleStart=Toolkit.getDefaultToolkit().createImage("image/startBattle.png");
		battleWin=Toolkit.getDefaultToolkit().createImage("image/winBattle.png");
	}
	
}

