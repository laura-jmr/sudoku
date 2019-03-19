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

	public Field[] getRow (int r) throws RowNotExistingException {
		Field[] row = new Field[9];
		InnerField[] innerFieldsOfRow = new InnerField[3];

		if (r < 0 || r >= 9) {
			throw new RowNotExistingException(r);
		} else if (r < 3) {
			innerFieldsOfRow[0] = innerFields[0];
			innerFieldsOfRow[1] = innerFields[1];
			innerFieldsOfRow[2] = innerFields[2];
		} else if (r < 6) {
			innerFieldsOfRow[0] = innerFields[3];
			innerFieldsOfRow[1] = innerFields[4];
			innerFieldsOfRow[2] = innerFields[5];

		} else if (r < 9) {
			innerFieldsOfRow[0] = innerFields[6];
			innerFieldsOfRow[1] = innerFields[7];
			innerFieldsOfRow[2] = innerFields[8];

		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < innerFields.length; j++) {
				if (innerFields[j] == innerFieldsOfRow[i]) {
					System.out.println("index of " + i + " is " + j);
				}
			}
		}


		switch (r) {
			case 0:
				row = getFieldsOfRow(innerFieldsOfRow, 0);
				break;
			case 1:
				row = getFieldsOfRow(innerFieldsOfRow, 1);
				break;
			case 2:
				row = getFieldsOfRow(innerFieldsOfRow, 2);
				break;
			case 3:
				row = getFieldsOfRow(innerFieldsOfRow, 0);
				break;
			case 4:
				row = getFieldsOfRow(innerFieldsOfRow, 1);
				break;
			case 5:
				row = getFieldsOfRow(innerFieldsOfRow, 2);
				break;
			case 6:
				row = getFieldsOfRow(innerFieldsOfRow, 0);
				break;
			case 7:
				row = getFieldsOfRow(innerFieldsOfRow, 1);
				break;
			case 8:
				row = getFieldsOfRow(innerFieldsOfRow, 2);
				break;
		}

		return row;
	}

	private Field[] getFieldsOfRow (InnerField[] innerFields, int r) throws RowNotExistingException{
		Field[] row = new Field[9];

		if (r < 3 && r >= 0) {
			for (int i = 0; i < 3; i++) {
				Field[] temp = innerFields[i].getRow(r);

				for (int j = 0; j < 3; j++) {
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

		} else {
			throw new RowNotExistingException(r);
		}


		for (int i = 0; i < row.length; i++) {
			System.out.println("row: " + row[i].getText());
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
		int rowPos;
		int pos = 0;

		for (int i = 0; i < UserInterface.gameField.innerFields.length; i++) {
			for (int j = 0; j < UserInterface.gameField.innerFields[0].fields.length; j++) {
				if (UserInterface.gameField.getInnerfieldOfField(field).fields[i] == field) {
					break;
				}
				pos++;
			}
		}

		rowPos = pos / 9;
		System.out.println("rowpos of currentfield is " + rowPos );

		return rowPos;
	}
}

