import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {
	
	private JButton buttonSingle;
	private JButton buttonMulti;
	private MyListener myListener;
	
	public Menu() {
		setLayout(null);
		
		buttonSingle = new JButton("Single Mode");
		buttonMulti = new JButton("Multi Mode");
		myListener = new MyListener();
		
		int x = 150;	// 버튼 위치 좌표
		int y = 30;		// 버튼 위치 좌표
		buttonSingle.setBounds(Main.SCREEN_WIDTH/2-x/2, Main.SCREEN_HEIGHT/2, x, y);		// 화면의 중앙에 오도록 배치하기
		buttonMulti.setBounds(Main.SCREEN_WIDTH/2-x/2, Main.SCREEN_HEIGHT/2+y+10, x, y);
		buttonSingle.addActionListener(myListener);
		buttonMulti.addActionListener(myListener);
		
		add(buttonSingle);
		add(buttonMulti);
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
