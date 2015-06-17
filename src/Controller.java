import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by riku on 15/06/12.
 */
public class Controller {
	private String buffer;

	public Controller() {
		this.buffer = "0";
		MainPanel.display.setText(buffer);
	}

	private void show() {
		MainPanel.display.setText(buffer);
	}

	public class Cal implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			Button b = (Button)actionEvent.getSource();
			if (b.bnum() <= 9) { // numbers
				if(buffer.equals("0"))
					buffer = b.getlable(); // 先頭が０だと上書き
				else
					buffer += b.getlable(); //それ以外は付け足し
				show();
			} else if (b.bnum() >= 10 && b.bnum() <= 13) { // operators

			} else if (b.bnum() == 14) { // equal

			} else if (b.bnum() == 15) { // all clear

			}
			// show result
		}
	}
}
