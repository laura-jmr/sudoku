import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class InnerField extends JPanel {

	Field field1 = new Field(this);
	Field field2 = new Field(this);
	Field field3 = new Field(this);
	Field field4 = new Field(this);
	Field field5 = new Field(this);
	Field field6 = new Field(this);
	Field field7 = new Field(this);
	Field field8 = new Field(this);
	Field field9 = new Field(this);
	Field[] allFields = new Field[9];
	GameField gameField;

	// Todo von puta => fields automatisiert initialisieren und dann das field array verwenden um die einzelnen fields zu accessen
	// e.g. field4 wird zu fields[3]
	//private InnerField[] fields;

	public InnerField (GameField field) {
		setBackground(new java.awt.Color(244, 244, 244));
		gameField = field;

		allFields[0] = field1;
		allFields[1] = field2;
		allFields[2] = field3;
		allFields[3] = field4;
		allFields[4] = field5;
		allFields[5] = field6;
		allFields[6] = field7;
		allFields[7] = field8;
		allFields[8] = field9;

		javax.swing.GroupLayout innerFieldLayout = new javax.swing.GroupLayout(this);
		this.setLayout(innerFieldLayout);
		innerFieldLayout.setHorizontalGroup(
				innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(innerFieldLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(field7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
										.addComponent(field4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(field1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(innerFieldLayout.createSequentialGroup()
												.addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(innerFieldLayout.createSequentialGroup()
												.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(field5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(field8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(field6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(field9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap())
		);
		innerFieldLayout.setVerticalGroup(
				innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(innerFieldLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(field3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(field4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(field5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(field6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(innerFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(field7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(field8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(field9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	}

	public String[] getNumberArray () {
		String[] numbers = new String[9];

		for (int i = 0; i < allFields.length; i++) {
			numbers[i] = allFields[i].getText();
		}

		return numbers;
	}
}

