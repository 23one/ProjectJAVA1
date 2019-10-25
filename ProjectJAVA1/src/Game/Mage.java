package Game;

import java.awt.Rectangle;

public class Mage {

	private int hp;					// 체력
	private int speed;				// 이동속도
	private int attackPower;		// 공격력
	private int attackSpeed;		// 공격속도
	private Rectangle body;			// 캐릭터 몸
	private Rectangle range;		// 공격 사거리
	private int x;					// 위치
	
	public Mage() {
	
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
