package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Main.PlayPanel;

public class Mage extends JPanel {

	private int hp = 100;							// ü��
	private int speed = 10;							// �̵��ӵ�
	private int attackPower = 10;					// ���ݷ�
	private int attackSpeed = 100;					// ���ݼӵ�
	private Rectangle body = new Rectangle(30, 40);	// ĳ���� ��ü
	private Rectangle range = new Rectangle();		// ���� ��Ÿ�
	private Image img = Toolkit.getDefaultToolkit().getImage("pictures/mage.png");	// �̹��� ���� �ҷ�����
	private int x = PlayPanel.CASTLE_X;				// ��ġ ��ǥ
	private int y = PlayPanel.CASTLE_Y;				// ��ġ ��ǥ
	
	public Mage() {
		x += PlayPanel.CASTLE_W;
		y += PlayPanel.CASTLE_H - body.height;		// ���� �ٴ��� �������� ���߱�
				
		this.setBounds(x, y, body.width, body.height);
		
		this.setBorder(new LineBorder(Color.blue, 1));	//�׽�Ʈ�� ���� �׵θ� ����
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, body.width, body.height, this);
	}
	
	public void move() {
		
	}

	// getter, setter �޼ҵ�
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public Rectangle getBody() {
		return body;
	}

	public void setBody(Rectangle body) {
		this.body = body;
	}

	public Rectangle getRange() {
		return range;
	}

	public void setRange(Rectangle range) {
		this.range = range;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
