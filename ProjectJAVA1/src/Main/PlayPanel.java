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
	public static final int CASTLE_X = 5;		// 아군 성의 좌표
	public static final int CASTLE_Y = 200;		// 아군 성의 좌표
	public static final int CASTLE_W = 100;		// 아군 성의 폭
	public static final int CASTLE_H = 150;		// 아군 성의 높이
	
	JLabel label;
	ArrayList<Mage> friendList = new ArrayList<Mage>();			// 생성된 아군(Mage)이 담겨있는 리스트
	ArrayList<Mage> enemyList = new ArrayList<Mage>();			// 생성된 적군이 담겨있는 리스트
	ArrayList<Castle> castleList = new ArrayList<Castle>();		// 아군과 적군의 성이 담겨있는 리스트
	
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
	
	// 상단의 캐릭터 생성과 현재 정보를 보기위한 패널
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
			
			this.setBorder(new LineBorder(Color.blue, 1));	//테스트를 위한 테두리 
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
