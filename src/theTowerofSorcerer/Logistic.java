package theTowerofSorcerer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

class Logistic extends JFrame implements Runnable
{
	private JPanel contentPane;
	public Graphics gr;
	private JPanel mmap;
	private JPanel bag, bagimg, bagtext;
	private JLabel dialog, bagimglab[], bagtextlab[];//dialog and bag images 
	private JTextArea diag;
	JLabel []lab = new JLabel[Lib.Row*Lib.Col];
	private Thread th;
	static int wid = 0, height = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{	
			public void run() 
			{
				try 
				{
					
					Logistic frame = new Logistic();
					Lib.MainCharacter.m=frame;
					//frame.setVisible(true);
					
					frame.setResizable(false);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Logistic() 
	{
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JButton b=new JButton();
		add(b);
		getContentPane().setLayout(new BorderLayout(0, 0));
		Lib.init();
		
		
		mmap = new JPanel();	//here
		bag = new JPanel();
		dialog = new JLabel();
		mmap.setLayout(new GridLayout(Lib.Row, Lib.Col));
		getContentPane().add("Center", mmap);
		//getContentPane().add("South", dialog);
		getContentPane().add("West",  bag);
		
	//finish the design of ContentPane
		
		bagimg = new JPanel();
		bagtext = new JPanel();
		diag = new JTextArea();
		bag.setLayout(new BorderLayout(0, 0));
		bag.add("North", bagtext);		
		bag.add("South", bagimg);	
		diag.setEditable(false);
		diag.setLineWrap(true);
		diag.setWrapStyleWord(true);
		bag.add("Center", diag);
		diag.setText("Welcome to the tower of sorcerer!");
		
	//finish the design of bag
		
		
		bagimg.setLayout(new GridLayout(Lib.bagimgnum, 2));
		bagimglab = new JLabel[Lib.bagimgnum * 3];
		for(int i = 0; i < Lib.bagimgnum*3; ++i)
			bagimglab[i] = new JLabel();
		bagtext.setLayout(new GridLayout(Lib.bagtextnum, 3));
		bagtextlab = new JLabel[Lib.bagtextnum * 2];
		for(int i = 0; i < Lib.bagtextnum*2; ++i)
			bagtextlab[i] = new JLabel();
		
		for(int i = 0; i < 3*Lib.bagimgnum; ++i)
			bagimg.add(bagimglab[i]);
		for(int i = 0; i < 2*Lib.bagtextnum; ++i)
			bagtext.add(bagtextlab[i]);
	//finish the detail of bag (bagImg & bagText)
		
		
		b.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				
				if(Person.whetherBattle)
					return;
				char tmp=e.getKeyChar();
				switch(tmp)
				{
				    case 'S':
					case 's':
						Lib.MainCharacter.move(Block.RIGHT, Lib.floors[Lib.curfloor]);
						
						break;
					case 'D':
					case 'd':
						Lib.MainCharacter.move(Block.DOWN, Lib.floors[Lib.curfloor]);
						
						break;
					case 'W':
					case 'w':
						Lib.MainCharacter.move(Block.LEFT, Lib.floors[Lib.curfloor]);
						
						break;
					case 'A':
					case 'a':
						Lib.MainCharacter.move(Block.UP, Lib.floors[Lib.curfloor]);
						
						break;
					default:
						break;
				}
			}
			
		});

		for(int i = 0; i < Lib.Row*Lib.Col; ++i)
		{
			lab[i] = new JLabel();
			mmap.add(lab[i]);
		}
		setVisible(true);
		Lib.MainCharacter.g=getGraphics();
		Lib.MainCharacter.g.drawImage(Lib.battleWin, 180, 140,contentPane );
		Lib.MainCharacter.g.drawImage(Lib.battleStart, 150, 100,contentPane );
		Lib.MainCharacter.j=contentPane;
		Lib.MainCharacter.d=diag;
		Lib.MainCharacter.b=b;
		Lib.MainCharacter.jlab=lab;
		Lib.MainCharacter.permap=mmap;
		Lib.MainCharacter.perbagimglab=bagimglab;
		Lib.MainCharacter.perbagtextlab=bagtextlab;
		Lib.MainCharacter.perbagimg=bagimg;
		Lib.MainCharacter.perbagtext=bagtext;
		
		th = new Thread(this);	// initialize the interface
		th.start();
	}

    
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
		//initial our screen
		SwingUtilities.invokeLater(()->
		{
			for(int i = 0; i < Lib.Row; ++i)
				for(int j = 0; j < Lib.Col; ++j)
				{
					//here may need to adjust the size of the icons
					lab[i*Lib.Col + j].setIcon(Lib.floors[Lib.curfloor].getBlocks()[i][j].img);
					//lab[i*Lib.Col + j].repaint();
				}
			//mmap.repaint();
			
			for(int i = 0; i < Lib.bagimgnum; ++i)	//link to bag images
				bagimglab[i * 3].setIcon(new ImageIcon("image" + Lib.imgname[i]));
				//here need to adjust size
			
			bagimglab[1].setText("X");
			bagimglab[2].setText(""+Lib.MainCharacter.yellowkeys);
			bagimglab[4].setText("X");
			bagimglab[5].setText(""+Lib.MainCharacter.bluekeys);
			bagimglab[7].setText("X");
			bagimglab[8].setText(""+Lib.MainCharacter.redkeys);
			
			bagtextlab[0].setText("Floor:");
			bagtextlab[1].setText(""+Lib.curfloor);
			bagtextlab[2].setText("Level:");
			bagtextlab[3].setText(""+Lib.MainCharacter.level);
			bagtextlab[4].setText("HP:");
			bagtextlab[5].setText(""+Lib.MainCharacter.life);
			bagtextlab[6].setText("Attack:");
			bagtextlab[7].setText(""+Lib.MainCharacter.attack);
			bagtextlab[8].setText("Defence:");
			bagtextlab[9].setText(""+Lib.MainCharacter.defence);
			bagtextlab[10].setText("Coin:");
			bagtextlab[11].setText(""+Lib.MainCharacter.coins);
			bagtextlab[12].setText("EXPerience:");
			bagtextlab[13].setText(""+Lib.MainCharacter.experience);
			
			diag.setText(Lib.diagcontent);
		});
		//finish the update of dialog	
		
	}

}

