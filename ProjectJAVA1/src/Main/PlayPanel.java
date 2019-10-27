package Main;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Game.Castle;
import Game.Mage;

public class PlayPanel extends JPanel{
	public static final int CASTLE_X = 5;		// �Ʊ� ���� ��ǥ
	public static final int CASTLE_Y = 200;		// �Ʊ� ���� ��ǥ
	public static final int CASTLE_W = 100;		// �Ʊ� ���� ��
	public static final int CASTLE_H = 150;		// �Ʊ� ���� ����
	
	JLabel label;
	ArrayList<Mage> friendList = new ArrayList<Mage>();			// ������ �Ʊ�(Mage)�� ����ִ� ����Ʈ
	ArrayList<Mage> enemyList = new ArrayList<Mage>();			// ������ ������ ����ִ� ����Ʈ
	ArrayList<Castle> castleList = new ArrayList<Castle>();		// �Ʊ��� ������ ���� ����ִ� ����Ʈ, 0=�Ʊ� 1=����
	ControlPanel controlPanel;		// ��Ʈ���г� ����
	
	public PlayPanel() {
		setLayout(null);
		
		controlPanel = new ControlPanel();
		
		add(controlPanel);
		
		//test
		castleList.add(new Castle());
		castleList.add(new Castle(true));
		add(castleList.get(0));
		add(castleList.get(1));
		
		Thread t1 = new Thread(new Check());
		t1.start();
		//test
		
		repaint();
	}
	
	// ����� ĳ���� ������ ���� ������ �������� �г�
	public class ControlPanel extends JPanel implements ActionListener {
		JButton button1;
		JButton button2;
		JButton button3;
		JButton button4;
		JLabel moneyLabel;
		JLabel hpLabel;
		
		public ControlPanel() {
			setLayout(new GridLayout(1,10,5,5));
			setBounds(0, 0, Main.SCREEN_WIDTH, 70);
			
			button1 = new JButton("Mage1");
			button2 = new JButton("Mage2");
			button3 = new JButton("Mage3");
			button4 = new JButton("Mage4");
			moneyLabel = new JLabel();
			hpLabel = new JLabel();
			
			// ��ư �ٹ̱�
			button1.setBackground(Color.red);
			button1.setFont(new Font("�������",Font.BOLD,30));
			button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			button1.setForeground(Color.white);
			button2.setFont(new Font("�������",Font.BOLD,30));
			button2.setBackground(Color.YELLOW);
			button2.setForeground(Color.white);
			button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			button3.setForeground(Color.white);
			button3.setFont(new Font("�������",Font.BOLD,30));
			button3.setBackground(Color.green);
			button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			button4.setForeground(Color.white);
			button4.setFont(new Font("�������",Font.BOLD,30));
			button4.setBackground(Color.blue);
			button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			moneyLabel.setHorizontalAlignment(JLabel.CENTER);
			hpLabel.setHorizontalAlignment(JLabel.CENTER);
			
			add(button1);
			add(button2);
			add(button3);
			add(button4);
			add(moneyLabel);
			add(hpLabel);
			
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
			button4.addActionListener(this);
			
			this.setBorder(new LineBorder(Color.blue, 1));	//�׽�Ʈ�� ���� �׵θ� 
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				//test
				if (castleList.get(0).getMoney() >= 10)
				{
					castleList.get(0).setMoney(castleList.get(0).getMoney() - 10);
					friendList.add(new Mage());
					Mage tmp = friendList.get(friendList.size()-1);
					PlayPanel.this.add(tmp);
					PlayPanel.this.repaint();
					System.out.println(friendList.size());
				}
				//test
				
			}
			else if (e.getSource() == button2) {
				if (friendList.size() != 0) {
					//test
					PlayPanel.this.remove(friendList.remove(0));
					PlayPanel.this.repaint();
					System.out.println(friendList.size());
					//test
					
				}
			}
			else if (e.getSource() == button3) {
				
			}
			else if (e.getSource() == button4) {
				
			}
		}
	}
	
	public class Check implements Runnable {
		public void run() {
			while (true) {
				for (int i=0; i<friendList.size(); i++) {
					friendList.get(i).fight(enemyList, castleList.get(1));
					repaint();
				}
				controlPanel.moneyLabel.setText((Integer.toString(castleList.get(0).getMoney())));
				controlPanel.hpLabel.setText((Integer.toString(castleList.get(0).getHp())));
				try {
					Thread.sleep(30);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
