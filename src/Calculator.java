import javax.swing.*;

/**
 * Created by riku on 15/06/03.
 */
public class Calculator extends JFrame {
	public Calculator() {
		setTitle("Calculator");

		MainPanel panel = new MainPanel();
		getContentPane().add(panel);

		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
