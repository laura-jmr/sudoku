public class Solver {

	private static Field currentField;
	private static List<Integer> possibleNumbers;

	public static void solve (GameField game) {
		System.out.println("\n---solving---");
		//while (game.emptyFields()) {
			for (int i = 0; i < game.innerFields.length; i++) {
				for (int j = 0; j < game.innerFields[0].fields.length; j++) {
					currentField = game.innerFields[i].fields[j];
					System.out.println();
					if (currentField.getText().equals("")) {
						System.out.println("searching number for field " + j + " in innerfield " + i);
						findPossibleNumbers();

						if (possibleNumbers.getLength() == 1) {
							possibleNumbers.toFirst();
							currentField.setText("" + possibleNumbers.getContent());
						}
					}
				}
			}
		//}
	}

	private static void findPossibleNumbers () {
		possibleNumbers = new List<>();

		for (int i = 1; i < 10; i++) {
			possibleNumbers.append(i);
		}
		System.out.println("all possible numbers in beninging: ");
		possibleNumbers.toFirst();
		while (possibleNumbers.hasAccess()) {
			System.out.print(possibleNumbers.getContent());
			possibleNumbers.next();
		}

		boolean innerField = checkOneNumberLeft(UserInterface.gameField.getInnerfieldOfField(currentField).fields);
		boolean row = checkOneNumberLeft(UserInterface.gameField.getRow(currentField, UserInterface.gameField.getRowPosOfField(currentField)));
		boolean column = checkOneNumberLeft(UserInterface.gameField.getColumn(currentField, UserInterface.gameField.getColumnPosOfField(currentField)));


		if (innerField || row || column) {
			System.out.println("this field is only field left");
			System.out.println("checking in innerfield: " + innerField + ", checking in row: " + row + ", checking in column: " + column);

			possibleNumbers.toFirst();
			while (possibleNumbers.hasAccess()) {
				possibleNumbers.remove();
			}

			if (innerField) {
				possibleNumbers.append(findLeftNumber(UserInterface.gameField.getInnerfieldOfField(currentField).fields));
			} else if (row) {
				possibleNumbers.append(findLeftNumber(UserInterface.gameField.getRow(currentField, UserInterface.gameField.getRowPosOfField(currentField))));
			} else if (column) {
				System.out.println("checking column..");
				possibleNumbers.append(findLeftNumber(UserInterface.gameField.getColumn(currentField, UserInterface.gameField.getColumnPosOfField(currentField))));
			}

			possibleNumbers.toFirst();
			int length = possibleNumbers.getLength();
			System.out.println("length of possible numbers " + length);

			while (length > 1) {
				int temp = possibleNumbers.getContent();

				possibleNumbers.toFirst();

				while (possibleNumbers.hasAccess()) {
					possibleNumbers.next();
					if (temp == possibleNumbers.getContent()) {
						possibleNumbers.remove();
					}
				}

			}

			possibleNumbers.toFirst();
			System.out.println("last possibleNumber: " + possibleNumbers.getContent());
		} else  {
			checkRules();
			//other algorithms to find out
		}
	}

	private static int findLeftNumber (Field[] area) {
		List<Integer> temp = new List<>();

		for (int i = 1; i < 10; i++) {
			temp.append(i);
		}

		System.out.println();
		for (int i = 0; i < area.length; i++) {

			System.out.print(area[i].getText() + " ");
		}

		for (int i = 0; i < area.length; i++) {
			temp.toFirst();

			while (temp.hasAccess()) {
				if (area[i].getText().equals("" + temp.getContent())) {
					temp.remove();
				} else {
					temp.next();
				}
			}
		}

		if (temp.getLength() == 1) {
			temp.toFirst();
			return temp.getContent();
		}

		return 0;
	}

	private static boolean checkOneNumberLeft (Field[] field) {
		int leftNumbers = 0;

		for (int i = 0; i < field.length; i++) {
			if (field[i].getText().equals("")) {
				leftNumbers++;
			}
		}

		if (leftNumbers == 1) {
			return true;
		}

		return false;
	}

	private static void checkRules () {
		RulesChecker.checkRules(currentField);
		if (RulesChecker.errorInnerField || RulesChecker.errorRows || RulesChecker.errorColumns) {
			List<Field> errors = RulesChecker.errorFields;

			while (!errors.isEmpty()) {
				errors.toFirst();
				possibleNumbers.toFirst();
				while (possibleNumbers.hasAccess()) {
					if (errors.getContent().getText().equals("" + possibleNumbers.getContent())) {
						possibleNumbers.remove();
						break;
					}
					possibleNumbers.next();
				}
				errors.remove();
			}
		}
		System.out.println("after checking rules: ");
		possibleNumbers.toFirst();
		while (possibleNumbers.hasAccess()) {
			System.out.print(possibleNumbers.getContent());
			possibleNumbers.next();
		}
	}
}