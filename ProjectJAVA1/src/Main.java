import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	public static final int SCREEN_WIDTH = 800;		// 창 가로 길이
	public static final int SCREEN_HEIGHT = 450;		// 창 세로 길이
	public static Main main;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main = new Main();
	}
	
	public static void changeScreen(JPanel panel1, JPanel panel2) {		// 화면 전환 메소드
		main.removeAll();;
		main.add(panel2);
	}
	
	public Main () {
		add(new Menu());
		
		setTitle("Mage Defence");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);	// 사이즈 조절 제한
		setLocationRelativeTo(null);	// 정 중앙에 위치	
		setDefaultCloseOperation(EXIT_ON_CLOSE); 	// 종료버튼 누르면 프로세스 종료
		setVisible(true);
		
		PlayMusic("sounds/music1.wav");
	}
	
	public void PlayMusic(String fileName)		//음악재생 메소드
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        }
        catch (Exception ex)
        {
        	System.out.println("음악 재생 실패 - "+ex);
        }
    }

}
