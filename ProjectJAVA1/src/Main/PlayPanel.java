package Main;
import java.awt.Color;
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
	ArrayList<Castle> castleList = new ArrayList<Castle>();		// �Ʊ��� ������ ���� ����ִ� ����Ʈ
	
	public PlayPanel() {
		setLayout(null);
		
		ControlPanel cp = new ControlPanel();
		
		add(cp);
		
		//test
		castleList.add(new Castle());
		friendList.add(new Mage());
		
		add(castleList.get(0));
		add(friendList.get(0));
		
		cp.moneyLabel.setText((Integer.toString(castleList.get(0).getMoney())));
		cp.hpLabel.setText((Integer.toString(castleList.get(0).getHp())));
		//test
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
			
			button1 = new JButton();
			button2 = new JButton();
			button3 = new JButton();
			button4 = new JButton();
			moneyLabel = new JLabel();
			hpLabel = new JLabel();
			
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
				friendList.add(new Mage());
				Mage tmp = friendList.get(friendList.size()-1);
				tmp.setX(tmp.getX()+50*(friendList.size()-1));
				PlayPanel.this.add(tmp);
				PlayPanel.this.repaint();
				System.out.println(friendList.size());
				//test
				
			}
			else if (e.getSource() == button2) {
				if (friendList.size() != 0) {
					//test
					PlayPanel.this.remove(friendList.remove(friendList.size()-1));
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
}
