package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import Main.Main;
import Main.PlayPanel;

public class Mage extends Characters {

	protected int hp = 100;								// ü��
	protected int speed = 3;							// �̵��ӵ�
	protected int attackPower = 10;						// ���ݷ�
	protected int attackSpeed = 1000;					// ���ݼӵ�, ms
	protected Rectangle body = new Rectangle(30, 40);	// ĳ���� ��ü
	protected int range = 100;							// ���� ��Ÿ�
	protected Image img = Toolkit.getDefaultToolkit().getImage("pictures/mage.png");	// �̹��� ���� �ҷ�����
	protected int x = PlayPanel.CASTLE_X;				// ��ġ ��ǥ
	protected int y = PlayPanel.CASTLE_Y;				// ��ġ ��ǥ
	protected boolean isAttack = true;					// ���� ��Ÿ�Ӱ� ���õ� boolean
	
	public Mage() {
		x += PlayPanel.CASTLE_W;
		y += PlayPanel.CASTLE_H - body.height;		// ���� �ٴ��� �������� ���߱�
				
		this.setBackground(new Color(0,0,0,0));
		this.setBounds(x, y, body.width, body.height);
		
		//this.setBorder(new LineBorder(Color.blue, 1));	//�׽�Ʈ�� ���� �׵θ� ����
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, body.width, body.height, this);
	}
	
	public void fight(ArrayList<Mage> list, Castle castle) {		// �ο�� �޼ҵ�, �տ� ���̳� ���� ������ �ο�� ������ ������
		int i;
		for (i=0; i<list.size(); i++) {
			Mage tmp = list.get(i);
			if (x+range >= tmp.getX()) {
				attack(tmp);
				break;
			}
		}
		if (i==list.size()) {
			if (x+range >= castle.getX()) {
				attack(castle);
			} else {
				move();
			}
		}
	}
	
	public void attack(Characters attacked) {		// �Ķ���Ϳ� ������ ����� HP�� �Է�
		if (isAttack) {
			Thread t = new Thread(new CoolTime());
			attacked.setHp(attacked.getHp()-this.attackPower);
			isAttack = false;
			t.start();
			System.out.println("������");
		}
	}
	
	public void move() {
		if (x < Main.SCREEN_WIDTH - 100)
			x += speed;
	}
	
	public void isDead() {
		
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
	
	public class CoolTime implements Runnable {
		public void run() {
			try {
				Thread.sleep(attackSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isAttack = true;
		}
	} 
}
