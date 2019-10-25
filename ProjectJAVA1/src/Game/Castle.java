package Game;

public class Castle {
	private int hp;
	private int money;
	
	public Castle() {
		hp = 2000;
		money = 100;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
