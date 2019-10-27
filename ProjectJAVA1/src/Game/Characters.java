package Game;

import javax.swing.JPanel;

public class Characters extends JPanel {		// Mage와 Castle의 부모클래스
	protected int hp;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
