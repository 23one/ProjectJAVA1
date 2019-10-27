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

	protected int hp = 100;								// 체력
	protected int speed = 3;							// 이동속도
	protected int attackPower = 10;						// 공격력
	protected int attackSpeed = 1000;					// 공격속도, ms
	protected Rectangle body = new Rectangle(30, 40);	// 캐릭터 몸체
	protected int range = 100;							// 공격 사거리
	protected Image img = Toolkit.getDefaultToolkit().getImage("pictures/mage.png");	// 이미지 파일 불러오기
	protected int x = PlayPanel.CASTLE_X;				// 위치 좌표
	protected int y = PlayPanel.CASTLE_Y;				// 위치 좌표
	protected boolean isAttack = true;					// 공격 쿨타임과 관련된 boolean
	
	public Mage() {
		x += PlayPanel.CASTLE_W;
		y += PlayPanel.CASTLE_H - body.height;		// 성의 바닥을 기준으로 맞추기
				
		this.setBackground(new Color(0,0,0,0));
		this.setBounds(x, y, body.width, body.height);
		
		//this.setBorder(new LineBorder(Color.blue, 1));	//테스트를 위한 테두리 지정
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, body.width, body.height, this);
	}
	
	public void fight(ArrayList<Mage> list, Castle castle) {		// 싸우는 메소드, 앞에 적이나 성이 있으면 싸우고 없으면 움직임
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
	
	public void attack(Characters attacked) {		// 파라미터엔 공격할 대상의 HP를 입력
		if (isAttack) {
			Thread t = new Thread(new CoolTime());
			attacked.setHp(attacked.getHp()-this.attackPower);
			isAttack = false;
			t.start();
			System.out.println("공격함");
		}
	}
	
	public void move() {
		if (x < Main.SCREEN_WIDTH - 100)
			x += speed;
	}
	
	public void isDead() {
		
	}

	// getter, setter 메소드
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
