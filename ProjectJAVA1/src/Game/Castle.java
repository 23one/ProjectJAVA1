package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Main.PlayPanel;

public class Castle extends JPanel {
	private int hp = 1000;
	private int money = 100;
	public boolean isEnemy;		// 적군의 성이면 true
	private Rectangle body = new Rectangle(PlayPanel.CASTLE_W, PlayPanel.CASTLE_H);		// 성 몸체 생성
	private Image img = Toolkit.getDefaultToolkit().getImage("pictures/castle.png");	// 이미지 파일 불러오기
	private int x = PlayPanel.CASTLE_X;		// 위치 좌표
	private int y = PlayPanel.CASTLE_Y;		// 위치 좌표
	
	public Castle(boolean isEnemy) {
		this.isEnemy = isEnemy;
		
		this.setBounds(x, y, body.width, body.height);
		
		this.setBorder(new LineBorder(Color.blue, 1));	//테스트를 위한 테두리 지정
	}
	
	public Castle() {
		this(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, body.width, body.height, this);
	}


	// getter, setter 메소드
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

	public boolean isEnemy() {
		return isEnemy;
	}

	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
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
}
