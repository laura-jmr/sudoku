public class Solver {

	private static Field currentField;
	private static List<Integer> possibleNumbers;

	public static void solve (GameField game) {
		System.out.println("---solving---");
		//while (game.emptyFields()) {
			for (int i = 0; i < game.innerFields.length; i++) {
				for (int j = 0; j < game.innerFields[0].fields.length; j++) {
					currentField = game.innerFields[i].fields[j];

					if (currentField.getText().equals("")) {
						System.out.println("searching number for field " + j);
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

		if (checkOneNumberLeft(UserInterface.gameField.getInnerfieldOfField(currentField).fields)) {
			possibleNumbers.toFirst();
			while (possibleNumbers.hasAccess()) {
				possibleNumbers.remove();
			}

			possibleNumbers.append(findLeftNumber(UserInterface.gameField.getInnerfieldOfField(currentField).fields));
		} else  {
			checkRules();
			//other algorithms to find out
		}
	}

	private static int findLeftNumber (Field[] area) {
		for (int i = 0; i < area.length; i++) {
			System.out.print(area[i].getText() + " ");
		}

		List<Integer> allNumbers = possibleNumbers;

		for (int i = 0; i < area.length; i++) {
			allNumbers.toFirst();

			while (allNumbers.hasAccess()) {
				if (area[i].getText().equals("" + allNumbers.getContent())) {
					allNumbers.remove();
				} else {
					allNumbers.next();
				}
			}
		}

		if (allNumbers.getLength() == 1) {
			allNumbers.toFirst();
			return allNumbers.getContent();
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
	}
}
