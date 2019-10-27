package Main;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {
	
	private Image backgroundImg = Toolkit.getDefaultToolkit().getImage("pictures/Main.PNG");
	private JButton buttonSingle;
	private JButton buttonMulti;
	private MyListener myListener;
	
	public Menu() {
		setLayout(null);
		
		buttonSingle = new JButton("Single Mode");
		buttonMulti = new JButton("Multi Mode");
		myListener = new MyListener();
		
		//버튼 꾸미기
		buttonSingle = new JButton("Single Mode");
		buttonSingle.setBackground(Color.ORANGE);
		buttonSingle.setFont(new Font("맑은고딕",Font.BOLD,20));
		buttonSingle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonSingle.setForeground(Color.white);
		buttonMulti = new JButton("Multi Mode");
		buttonMulti.setBackground(Color.CYAN);
		buttonMulti.setFont(new Font("맑은고딕",Font.BOLD,20));
		buttonMulti.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonMulti.setForeground(Color.white);
		
		int x = 150;	// 버튼 위치 좌표
		int y = 30;		// 버튼 위치 좌표
		buttonSingle.setBounds(Main.SCREEN_WIDTH/2-x/2, Main.SCREEN_HEIGHT/2, x, y);		// 화면의 중앙에 오도록 배치하기
		buttonMulti.setBounds(Main.SCREEN_WIDTH/2-x/2, Main.SCREEN_HEIGHT/2+y+10, x, y);
		buttonSingle.addActionListener(myListener);
		buttonMulti.addActionListener(myListener);
		
		add(buttonSingle);
		add(buttonMulti);
	}
	
	@Override
	   public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.drawImage(backgroundImg, 0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, this);
	   }
	
	private class MyListener implements ActionListener {		// 버튼 액션, 내부 클래스
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonSingle) {
				setVisible(false);
				Main.main.add(new PlayPanel());
			}
		}
	}
}
