import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Field extends JTextField {

	private Field currentField;

	public Field () {
		currentField = this;

		setHorizontalAlignment(javax.swing.JTextField.CENTER);
		setToolTipText("");
		setAutoscrolls(false);
		setMinimumSize(new java.awt.Dimension(27, 27));
		setPreferredSize(new java.awt.Dimension(27, 27));
		setSize(new java.awt.Dimension(27, 27));
		setText("");
		setForeground(Color.black);
		addKeyListener(new java.awt.event.KeyAdapter() {

			public void keyTyped(java.awt.event.KeyEvent evt) {
			handleInput(evt);
			RulesChecker.checkRules(currentField);
			}
		});
	}

	public void handleInput (KeyEvent event) {
		RulesChecker.checkInput(event.getKeyChar());
		String newInput;

		if (RulesChecker.errorInput) {
			event.consume();
			newInput = "";
		} else {
            event.consume();
			newInput = "" + event.getKeyChar();
		}

		currentField.setText(newInput);
	}
}