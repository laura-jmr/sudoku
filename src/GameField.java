import javax.swing.*;

public class GameField extends JPanel {

	InnerField[] innerFields;

	public GameField () {
		innerFields = new InnerField[9];

		for (int i = 0; i < innerFields.length; i++) {
			innerFields[i] = new InnerField();
		}

		setBackground(new java.awt.Color(255, 255, 255));
		setForeground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout gameFieldLayout = new javax.swing.GroupLayout(this);
		this.setLayout(gameFieldLayout);
		gameFieldLayout.setHorizontalGroup(
			gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gameFieldLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(innerFields[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(innerFields[3], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(innerFields[6], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(innerFields[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(innerFields[4], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(innerFields[7], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(innerFields[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(innerFields[5], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(innerFields[8], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gameFieldLayout.setVerticalGroup(
			gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gameFieldLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(gameFieldLayout.createSequentialGroup()
								.addComponent(innerFields[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(innerFields[4], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(innerFields[7], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(gameFieldLayout.createSequentialGroup()
								.addComponent(innerFields[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(innerFields[5], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(innerFields[8], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameFieldLayout.createSequentialGroup()
							.addComponent(innerFields[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(innerFields[3], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addComponent(innerFields[6], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	}

	public Field[] getRow (Field field, int r) {
		Field[] row = new Field[9];
		InnerField[] innerFieldsOfRow = new InnerField[3];

		for (int i = 0; i < innerFieldsOfRow.length; i++) {
			if (r < 3 && r >= 0) {
				innerFieldsOfRow[i] = innerFields[i];
			} else if (r < 6 && r >= 3) {
				innerFieldsOfRow[i] = innerFields[i + 3];
			} else if (r < 9 && r >= 6) {
				innerFieldsOfRow[i] = innerFields[i + 6];
			}
		}

		for (int i = 0; i < 3; i++) {
			Field[] temp = innerFieldsOfRow[i].getRow(getInnerfieldOfField(field).getRowPos(field));
			for (int j = 0; j < temp.length; j++) {
				switch (i) {
					case 0:
						row[j] = temp[j];
					case 1:
						row[j + 3] = temp[j];
					case 2:
						row[j + 6] = temp[j];
				}
			}
		}

		return row;
	}

	public InnerField getInnerfieldOfField (Field field) {

		for (int i = 0; i < innerFields.length; i++) {
			for (int j = 0; j < innerFields[0].fields.length; j++) {
				if (innerFields[i].fields[j] == field){
					return innerFields[i];
				}
			}
		}

		return null;
	}

	public int getRowPosOfField (Field field) {
		InnerField[] innerFieldsInRow = new InnerField[3];
		int row = 0;
		int innerFieldPos = getInnerFieldPos(getInnerfieldOfField(field));

		if (innerFieldPos < 3) {
			for (int i = 0; i < innerFieldsInRow.length; i++) {
				innerFieldsInRow[i] = UserInterface.gameField.innerFields[i];
			}
			row = 0;
		} else if (innerFieldPos < 6) {
			for (int i = 0; i < innerFieldsInRow.length; i++) {
				innerFieldsInRow[i] = UserInterface.gameField.innerFields[i + 3];
			}
			row = 3;
		} else if (innerFieldPos < 9) {
			for (int i = 0; i < innerFieldsInRow.length; i++) {
				innerFieldsInRow[i] = UserInterface.gameField.innerFields[i + 6];
			}
			row = 6;
		}

		int temp = getInnerfieldOfField(field).getRowPos(field);
		row += temp;

		return row;
	}

	private int getInnerFieldPos (InnerField innerField) {
		int innerFieldPos = 0;

		for (int i = 0; i < UserInterface.gameField.innerFields.length; i++) {
			if (innerField == UserInterface.gameField.innerFields[i]) {
				innerFieldPos = i;
				break;
			}
		}

		return innerFieldPos;
	}

	public Field[] getColumn (Field field, int c) {
		Field[] column = new Field[9];
		InnerField[] innerFieldsOfRow = new InnerField[3];

		if (c < 3 && c >= 0) {
			innerFieldsOfRow[0] = innerFields[0];
			innerFieldsOfRow[1] = innerFields[3];
			innerFieldsOfRow[2] = innerFields[6];
		} else if (c < 6 && c >= 3) {
			innerFieldsOfRow[0] = innerFields[1];
			innerFieldsOfRow[1] = innerFields[4];
			innerFieldsOfRow[2] = innerFields[7];
		} else if (c < 9 && c >= 6) {
			innerFieldsOfRow[0] = innerFields[2];
			innerFieldsOfRow[1] = innerFields[5];
			innerFieldsOfRow[2] = innerFields[8];
		}

		for (int i = 0; i < 3; i++) {
			Field[] temp = innerFieldsOfRow[i].getColumn(getInnerfieldOfField(field).getColumnPos(field));

			for (int j = 0; j < temp.length; j++) {
				switch (i) {
					case 0:
						column[j] = temp[j];
					case 1:
						column[j + 3] = temp[j];
					case 2:
						column[j + 6] = temp[j];
				}
			}
		}

		return column;
	}

	public int getColumnPosOfField (Field field) {
		InnerField[] innerFieldsInRow = new InnerField[3];
		int column = 0;
		int innerFieldPos = getInnerFieldPos(getInnerfieldOfField(field));

		if (innerFieldPos == 0 || innerFieldPos == 3 || innerFieldPos == 6) {
			for (int i = 0; i < 3; i++) {
				innerFieldsInRow[i] = UserInterface.gameField.innerFields[innerFieldPos];
			}
			column = 0;
		} else if (innerFieldPos == 1 || innerFieldPos == 4 || innerFieldPos == 7) {
			for (int i = 0; i < 3; i++) {
				innerFieldsInRow[i] = UserInterface.gameField.innerFields[innerFieldPos];
			}
			column = 3;
		} else if (innerFieldPos == 2 || innerFieldPos == 5 || innerFieldPos == 8) {
			for (int i = 0; i < 3; i++) {
				innerFieldsInRow[i] = UserInterface.gameField.innerFields[innerFieldPos];
			}
			column = 6;
		}

		int temp = getInnerfieldOfField(field).getColumnPos(field);
		column += temp;

		return column;
	}

	public void setAllFieldsTextBlack () {

		for (int i = 0; i < innerFields.length; i++) {
			for (int j = 0; j < innerFields[0].fields.length; j++) {
				if (innerFields[i].fields[j].getForeground() == java.awt.Color.red) {
					innerFields[i].fields[j].setForeground(java.awt.Color.black);
				}
			}
		}
	}

	public void clearAllFields () {
		for (int i = 0; i < innerFields.length; i++) {
			for (int j = 0; j < innerFields[0].fields.length; j++) {
				innerFields[i].fields[j].setText("");
			}
		}
	}

	public boolean emptyFields () {

		for (int i = 0; i < innerFields.length; i++) {
			for (int j = 0; j < innerFields[0].fields.length; j++) {
				if (innerFields[i].fields[j].getText().equals("")) {
					return true;
				}
			}
		}

		return false;
	}
}