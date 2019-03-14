import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameField extends JPanel {

	private InnerField innerField1;
	private InnerField innerField2;
	private InnerField innerField3;
	private InnerField innerField4;
	private InnerField innerField5;
	private InnerField innerField6;
	private InnerField innerField7;
	private InnerField innerField8;
	private InnerField innerField9;
	InnerField[] allFields;
	UserInterface game;

	public GameField (UserInterface g) {
		innerField1 = new InnerField(this);
		innerField2 = new InnerField(this);
		innerField3 = new InnerField(this);
		innerField4 = new InnerField(this);
		innerField5 = new InnerField(this);
		innerField6 = new InnerField(this);
		innerField7 = new InnerField(this);
		innerField8 = new InnerField(this);
		innerField9 = new InnerField(this);
		allFields = new InnerField[9];

		allFields[0] = innerField1;
		allFields[1] = innerField2;
		allFields[2] = innerField3;
		allFields[3] = innerField4;
		allFields[4] = innerField5;
		allFields[5] = innerField6;
		allFields[6] = innerField7;
		allFields[7] = innerField8;
		allFields[8] = innerField9;

		game = g;

		this.setBackground(new java.awt.Color(255, 255, 255));
		this.setForeground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout gameFieldLayout = new javax.swing.GroupLayout(this);
		this.setLayout(gameFieldLayout);
		gameFieldLayout.setHorizontalGroup(
				gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(gameFieldLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(innerField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(innerField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(innerField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(innerField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(innerField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(innerField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(innerField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(innerField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(innerField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gameFieldLayout.setVerticalGroup(
				gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(gameFieldLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(gameFieldLayout.createSequentialGroup()
														.addComponent(innerField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(innerField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(innerField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(gameFieldLayout.createSequentialGroup()
														.addComponent(innerField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(innerField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(innerField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameFieldLayout.createSequentialGroup()
												.addComponent(innerField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(innerField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(innerField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	}

	public String[][] get2DNumberArray () {
		String[][] numbers = new String[9][9];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				switch (i) {
					case 0:
						switch (j) {

							case 0:
								fill2DNumberArray(numbers, this.innerField7, i , j);
								break;
							case 1:
								fill2DNumberArray(numbers, this.innerField8, i , j);
								break;
							case 2:
								fill2DNumberArray(numbers, this.innerField9, i , j);
								break;
						}
						break;

					case 1:
						switch (j) {

							case 0:
								fill2DNumberArray(numbers, this.innerField4, i , j);
								break;
							case 1:
								fill2DNumberArray(numbers, this.innerField5, i , j);
								break;
							case 2:
								fill2DNumberArray(numbers, this.innerField6, i , j);
								break;
						}
						break;

					case 2:
						switch (j) {

							case 0:
								fill2DNumberArray(numbers, this.innerField1, i , j);
								break;
							case 1:
								fill2DNumberArray(numbers, this.innerField2, i , j);
								break;
							case 2:
								fill2DNumberArray(numbers, this.innerField3, i , j);
								break;
						}
						break;

				}
			}
		}

		return numbers;
	}

	private void fill2DNumberArray (String[][] num, InnerField field, int y, int x) {

		switch (y) {
			case 0:
				y = 0;
				break;
			case 1:
				y = 3;
				break;
			case 2:
				y = 6;
				break;
		}

		switch (x) {
			case 0:
				x = 0;
				break;
			case 1:
				x = 3;
				break;
			case 2:
				x = 6;
				break;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				switch (i) {
					case 0:
						num[y + i][x + j] = field.allFields[j].getText();
						break;
					case 1:
						num[y + i][x + j] = field.allFields[j + 3].getText();
						break;
					case 2:
						num[y + i][x + j] = field.allFields[j + 6].getText();
						break;
				}
			}
		}
	}
}

