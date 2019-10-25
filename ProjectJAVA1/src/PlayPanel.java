import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.*;

public class PlayPanel extends JPanel{
	JLabel label;
	ArrayList<Mage> friendList = new ArrayList<Mage>();			// 생성된 아군(Mage)이 담겨있는 리스트
	ArrayList<Mage> enemyList = new ArrayList<Mage>();			// 생성된 적군이 담겨있는 리스트
	ArrayList<Castle> castleList = new ArrayList<Castle>();		// 아군과 적군의 성이 담겨있는 리스트
	
	public PlayPanel() {
		setLayout(null);
		
		ControlPanel cp = new ControlPanel();
		
		cp.setBounds(0, 0, Main.SCREEN_WIDTH, 100);
		
		add(cp);
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
			
			button1 = new JButton();
			button2 = new JButton();
			button3 = new JButton();
			button4 = new JButton();
			moneyLabel = new JLabel("test");
			hpLabel = new JLabel("test");
			
			moneyLabel.setHorizontalAlignment(JLabel.CENTER);
			hpLabel.setHorizontalAlignment(JLabel.CENTER);
			
			add(button1);
			add(button2);
			add(button3);
			add(button4);
			add(moneyLabel);
			add(hpLabel);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				
			}
			else if (e.getSource() == button2) {
				
			}
			else if (e.getSource() == button3) {
				
			}
			else if (e.getSource() == button4) {
				
			}
		}
	}
}
