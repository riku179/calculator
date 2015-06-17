import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by riku on 15/06/03.
 */
public class Button extends JButton {

	private String label;
	private int num;

	public Button(String s) {
		super(s);
		int i = Integer.parseInt(s);
		if(i <= 9) {
			this.label = s;
		} else {
			switch (i) {
				case 10: this.label = "+";
					break;
				case 11: this.label = "-";
					break;
				case 12: this.label = "*";
					break;
				case 13: this.label = "/";
					break;
				case 14: this.label = "=";
					break;
				case 15: this.label = "AC";
					break;
			}
		}
		this.num = i;
		this.setFont(new Font("Century", Font.PLAIN, 32));
	}

	public int bnum() {
		return this.num;
	}

	public String getlable() {
		return this.label;
	}
}

