public class InnerField extends javax.swing.JPanel {

	Field[] fields;

	public InnerField () {
		setBackground(new java.awt.Color(244, 244, 244));
		fields = new Field[9];

		for (int i = 0; i < 9; i++) {
			fields[i] = new Field();
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

	public Field[] getRow (int r) {
		Field[] row = new Field[3];

		for (int i = 0; i < row.length; i++) {
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

		return row;
	}

	public int getRowPos (Field field) {
		int row = 10;
		int pos = 0;

		for (int i = 0; i < fields.length; i++) {
			if (field == fields[i]) {
				pos = i;
				break;
			}
		}

		if (pos < 3 && pos >= 0) {
			row = 0;
		} else if (pos < 6 && pos >= 3) {
			row = 1;
		} else if (pos < 9 && pos >= 6) {
			row = 2;
		}

		return row;
	}

	public int getColumnPos (Field field) {
		int column = 10;
		int pos = 0;

		for (int i = 0; i < fields.length; i++) {
			if (field == fields[i]) {
				pos = i;
				break;
			}
		}

		if (pos == 0 || pos == 3 || pos == 6) {
			column = 0;
		} else if (pos == 1 || pos == 4 || pos == 7) {
			column = 1;
		} else if (pos == 2 || pos == 5 || pos == 8) {
			column = 2;
		}

		return column;
	}

	public Field[] getColumn (int c) {
		Field[] column = new Field[3];

		switch (c) {
			case 0:
				column[0] = fields[0];
				column[1] = fields[3];
				column[2] = fields[6];
				break;
			case 1:
				column[0] = fields[1];
				column[1] = fields[4];
				column[2] = fields[7];
				break;
			case 2:
				column[0] = fields[2];
				column[1] = fields[5];
				column[2] = fields[8];
				break;
		}

		return column;
	}
}