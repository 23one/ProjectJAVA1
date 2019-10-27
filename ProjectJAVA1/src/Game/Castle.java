package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Main.Main;
import Main.PlayPanel;

public class Castle extends Characters implements Runnable {
	protected int hp = 1000;
	protected int money = 100;
	protected Rectangle body = new Rectangle(PlayPanel.CASTLE_W, PlayPanel.CASTLE_H);		// 성 몸체 생성
	protected Image img = Toolkit.getDefaultToolkit().getImage("pictures/castle.png");	// 이미지 파일 불러오기
	protected int x = PlayPanel.CASTLE_X;		// 위치 좌표
	protected int y = PlayPanel.CASTLE_Y;		// 위치 좌표
	protected JLabel hpStatus = new JLabel();	//성 체력을 표시할 라벨
	protected boolean isEnemy = false;
	
	public Castle(boolean isEnemy) {
		this.isEnemy = isEnemy;
		if (isEnemy)
			x = Main.SCREEN_WIDTH - body.width - PlayPanel.CASTLE_X*2;
		
		add(hpStatus);
		
		this.setBounds(x, y, body.width, body.height);
		
		this.setBorder(new LineBorder(Color.blue, 1));	//테스트를 위한 테두리 지정
		
		new Thread(this).start();
	}
	
	public Castle() {
		this(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 20, body.width, body.height, this);
		repaint();
	}
	
	public void run() {
		while (true) {
			this.hpStatus.setText(this.getHp()+" / 1000");
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
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
