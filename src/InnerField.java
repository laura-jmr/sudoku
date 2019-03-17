public class InnerField extends javax.swing.JPanel {

	Field[] fields;
	GameField gameField;

	public InnerField () {
		setBackground(new java.awt.Color(244, 244, 244));
		fields = new Field[9];

		for (int i = 0; i < 9; i++) {
			fields[i] = new Field(this);
		}

		javax.swing.GroupLayout innerFieldLayout = new javax.swing.GroupLayout(this);
		this.setLayout(innerFieldLayout);
		innerFieldLayout.setHorizontalGroup(
				innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(innerFieldLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(fields[6], javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
										.addComponent(fields[3], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(fields[0], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(innerFieldLayout.createSequentialGroup()
												.addComponent(fields[1], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(fields[2], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(innerFieldLayout.createSequentialGroup()
												.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(fields[4], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(fields[7], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(fields[5], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(fields[8], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap())
		);
		innerFieldLayout.setVerticalGroup(
				innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(innerFieldLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(fields[0], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(fields[1], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(fields[2], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(fields[3], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(fields[4], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(fields[5], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(fields[6], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(fields[7], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(fields[8], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	}

	public String[] getNumberArray () {
		String[] numbers = new String[9];

		for (int i = 0; i < fields.length; i++) {
			numbers[i] = fields[i].getText();
		}

		return numbers;
	}

	public Field[] getRow (int r) {
		Field[] row = new Field[3];


		for (int i = 0; i < 3; i++) {
			switch (r) {
				case 0:
					row[i] = fields[i];
					break;
				case 1:
					row[i] = fields[i + 3];
					break;
				case 2:
					row[i] = fields[i + 6];
					break;
			}
		}

		for (int i = 0; i < row.length; i++) {
			System.out.println("innerrow: " + row[i].getText());
		}


		return row;
	}
}

