import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by riku on 15/06/03.
 */
public class Button extends JButton {

	private int num;

	public Button(String s) {
		super(s);
		int i = Integer.parseInt(s);
		if(i <= 9) {
			this.setText(s);
		} else {
			switch (i) {
				case 10: this.setText("+");
					break;
				case 11: this.setText("-");
					break;
				case 12: this.setText("*");
					break;
				case 13: this.setText("/");
					break;
				case 14: this.setText("=");
					break;
				case 15: this.setText("AC");
					break;
			}
		}
		this.num = i;
		this.setFont(new Font("Century", Font.PLAIN, 32));
	}

	public int bnum() {
		return this.num;
	}
}

