import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by riku on 15/06/12.
 */
public class Controller {
	String buf1; // buffer to display
	String buf2; // buffer to calculate
	enum state {NUMBER, ADD , SUB, MULTI, DIV, NON} // state of buffer
	state id1; // status of buf1
	state id2; // status of buf2

	public Controller() {
		buf1 = "0";
		id1 = id2 = state.NON;
		MainPanel.display.setText(buf1);
	}

	private void show() {
		MainPanel.display.setText(this.buf1);
	}

	private void result() {
		double tmp1 = Double.parseDouble(buf1); // 2 buffer cast String to double
		double tmp2 = Double.parseDouble(buf2);

		switch (id2) {
			case ADD:
				buf1 = String.valueOf(tmp2+tmp1);
				id1 = id2 = state.NON;
				show();
				break;
			case SUB:
				buf1 = String.valueOf(tmp2-tmp1);
				id1 = id2 = state.NON;
				show();
				break;
			case MULTI:
				buf1 = String.valueOf(tmp2*tmp1);
				id1 = id2 = state.NON;
				show();
				break;
			case DIV:
				buf1 = String.valueOf(tmp2/tmp1);
				id1 = id2 = state.NON;
				show();
				break;
			case NON:
				break;
		}
	}

	public class Cal implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			Button b = (Button)actionEvent.getSource();
			if (b.bnum() <= 9) { // numbers
				switch (id1) {
					case NON:
						buf1 = b.getText(); // overwrite "0"
						id1 = state.NUMBER; // change state to NUMBER
						show(); // push buffer to display
						break;
					case NUMBER:
						buf1 += b.getText(); // add char to buffer
						show();
						break;
					case ADD:
						buf2 = buf1; // move buffer to buf2
						id2 = state.ADD; // move id to id2
						buf1 = b.getText(); // overwrite buf1
						id1 = state.NUMBER; // overwrite id
						show();
						break;
					case SUB:
						buf2 = buf1;
						id2 = state.SUB;
						buf1 = b.getText();
						id1 = state.NUMBER;
						show();
						break;
					case MULTI:
						buf2 = buf1;
						id2 = state.MULTI;
						buf1 = b.getText();
						id1 = state.NUMBER;
						show();
						break;
					case DIV:
						buf2 = buf1;
						id2 = state.DIV;
						buf1 = b.getText();
						id1 = state.NUMBER;
						show();
						break;
				}
			} else if (b.bnum() >= 10 && b.bnum() <= 13) { // operators
				if(id2 != state.NON)
					result();
				switch (b.bnum()) {
					case 10:
						id1 = state.ADD;
						break;
					case 11:
						id1 = state.SUB;
						break;
					case 12:
						id1 = state.MULTI;
						break;
					case 13:
						id1 = state.DIV;
						break;
				}
			} else if (b.bnum() == 14) { // equal
				result();
			} else if (b.bnum() == 15) { // all clear
				id1 = id2 = state.NON;
				buf1 = "0";
				show();
			}
		}
	}
}
