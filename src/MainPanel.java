import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by riku on 15/06/03.
 */
public class MainPanel extends JPanel {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 560;


	private Button button[] = new Button[16];
	public static Display display = new Display();
	private Controller.Cal cal = new Controller().new Cal();


	public MainPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		initGUI();
	}

	//	GUIを初期化する
	private void initGUI() {

		// 0−9までの数字ボタンを生成＆Listener登録
		for (int i = 0; i <= 15; i++) {
			button[i] = new Button(String.valueOf(i));
			button[i].addActionListener(cal);
		}
		// ボタンをパネルにのせる
		JPanel p_button = new JPanel();
		// レイアウト設定
		setLayout(new BorderLayout());
		add("North", display);
		add("Center", p_button);
		p_button.setLayout(new GridLayout(3, 5));
		for (int i = 0; i <= 15; i++)
			p_button.add(button[i]);
	}

}
