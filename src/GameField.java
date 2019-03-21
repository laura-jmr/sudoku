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
			if (r < 3) {
				innerFieldsOfRow[i] = innerFields[i];
			} else if (r < 6) {
				innerFieldsOfRow[i] = innerFields[i + 3];
			} else if (r < 9) {
				innerFieldsOfRow[i] = innerFields[i + 6];
			}
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("\ninner row of the " + i + " innerfield: ");
			Field[] temp = innerFieldsOfRow[i].getRow(innerFieldsOfRow[i].getRowPos(field));
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
		int innerFieldPos = 0;
		InnerField innerFieldOfField = getInnerfieldOfField(field);

		for (int i = 0; i < UserInterface.gameField.innerFields.length; i++) {
			if (innerFieldOfField == UserInterface.gameField.innerFields[i]) {
				innerFieldPos = i;
				break;
			}
		}

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

		int temp = innerFieldOfField.getRowPos(field);
		row += temp;

		return row;
	}
}

