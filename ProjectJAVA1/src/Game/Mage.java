package Game;

import java.awt.Rectangle;

public class Mage {

	private int hp;					// ü��
	private int speed;				// �̵��ӵ�
	private int attackPower;		// ���ݷ�
	private int attackSpeed;		// ���ݼӵ�
	private Rectangle body;			// ĳ���� ��
	private Rectangle range;		// ���� ��Ÿ�
	private int x;					// ��ġ
	
	public Mage() {
	
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public void move() {
		
	}
}
