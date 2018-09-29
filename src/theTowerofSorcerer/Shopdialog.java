package theTowerofSorcerer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shopdialog extends JDialog implements ActionListener 
{
	private JButton btn[];

	@Override
	public void actionPerformed(ActionEvent a) 
	{
		if (a.getSource() == btn[0]) 
		{
			Lib.MainCharacter.Buy(Shop.HP);
		}
		if (a.getSource() == btn[1]) 
		{
			Lib.MainCharacter.Buy(Shop.ATK);
		}
		if (a.getSource() == btn[2]) 
		{
			Lib.MainCharacter.Buy(Shop.DFS);
		}
		dispose();
		// TODO Auto-generated method stub

	}

	Shopdialog(JFrame p, boolean model) {
		super(p, model);
		setTitle("Shop");
		setSize(300, 300);
		setLayout(new GridLayout(4, 1));
		btn = new JButton[4];
		btn[0] = new JButton(Lib.buyHP);
		btn[1] = new JButton(Lib.buyAtk);
		btn[2] = new JButton(Lib.buyDfs);
		btn[3] = new JButton("Quit");
		for (int i = 0; i < 4; i++) {
			add(btn[i]);
			btn[i].addActionListener(this);
		}
	}
}
