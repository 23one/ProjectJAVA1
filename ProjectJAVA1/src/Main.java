import javax.swing.*;

public class Main extends JFrame {

	public static final int SCREEN_WIDTH = 800;		// â ���� ����
	public static final int SCREEN_HEIGHT = 450;		// â ���� ����
	public static Main main;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main = new Main();
	}
	
	public static void changeScreen(JPanel panel1, JPanel panel2) {		// ȭ�� ��ȯ �޼ҵ�
		main.removeAll();;
		main.add(panel2);
	}
	
	public Main () {
		add(new Menu());
		
		setTitle("Mage Defence");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);	// ������ ���� ����
		setLocationRelativeTo(null);	// �� �߾ӿ� ��ġ	
		setDefaultCloseOperation(EXIT_ON_CLOSE); 	// �����ư ������ ���μ��� ����
		setVisible(true);
	}

}
