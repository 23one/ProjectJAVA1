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
		
		int x = 150;	// ��ư ��ġ ��ǥ
		int y = 30;		// ��ư ��ġ ��ǥ
		buttonSingle.setBounds(Main.SCREEN_WIDTH/2-x/2, Main.SCREEN_HEIGHT/2, x, y);		// ȭ���� �߾ӿ� ������ ��ġ�ϱ�
		buttonMulti.setBounds(Main.SCREEN_WIDTH/2-x/2, Main.SCREEN_HEIGHT/2+y+10, x, y);
		buttonSingle.addActionListener(myListener);
		buttonMulti.addActionListener(myListener);
		
		add(buttonSingle);
		add(buttonMulti);
	}
	
	private class MyListener implements ActionListener {		// ��ư �׼�, ���� Ŭ����
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonSingle) {
				setVisible(false);
				Main.main.add(new PlayPanel());
			}
		}
	}
}
