import java.awt.*;

public class RulesChecker {


	static boolean errorInput;
	static boolean errorInnerField;
	static boolean errorRows;
	static boolean errorColumns;
	static boolean rechecked;
	static Field currentField;
	static Field oldField;
	static GameField gameField;
	static List<Field> errorFields;

	public RulesChecker (GameField g) {
		gameField = g;
		init();
	}

	private static void init () {
		errorInput = false;
		errorInnerField = false;
		errorRows = false;
		errorColumns = false;
		rechecked = true;
		errorFields = new List<>();
	}

	public static void checkInput (char inputC) {
		char newInput = ' ';

		try {
			int inputI = Integer.parseInt("" + inputC);

			if (inputI != 0) {
				newInput = (char) inputI;
			}
		} catch (NumberFormatException e) {
			System.err.println(e);
		}

		if (newInput == ' ')
			errorInput = true;
	}

	public static void checkRules (InnerField innerField, Field field) {

		if (!rechecked) {
			oldField = currentField;
			currentField = field;

			recheck(innerField, field);
		} else {
			currentField = field;

			init();

			checkInnerField(innerField);
			checkRows(UserInterface.gameField);

			if (errorInnerField || errorRows || errorColumns) {
				UserInterface.error();
			}
		}
	}

	private static void recheck (InnerField innerField, Field field) {

		for (int i = 0; i < UserInterface.gameField.getInnerfieldOfField(oldField).fields.length; i++) {
			if(UserInterface.gameField.getInnerfieldOfField(oldField).fields[i].getForeground() == Color.red) {
				UserInterface.gameField.getInnerfieldOfField(oldField).fields[i].setForeground(Color.black);
			}
		}

		if (oldField == field) {
			errorFields = new List<>();
			rechecked = true;

			checkRules(innerField, field);

			return;

		} else {
			rechecked = true;

			checkRules(innerField, field);
		}
	}

	private static void checkInnerField (InnerField innerField) {
		String[] numbers = innerField.getNumberArray();
		String currentNumber;

		for (int i = 0; i < numbers.length - 1; i++) {
			currentNumber = numbers[i];

			for (int j = i + 1; j < numbers.length; j++) {

				if (currentNumber.equals(numbers[j]) && !currentNumber.equals("")) {
					errorInnerField = true;

					if (currentField == innerField.fields[i]) {
						errorFields.append(innerField.fields[j]);

					} else if (currentField == innerField.fields[j]) {
						errorFields.append(innerField.fields[i]);
					}
				}
			}
		}
	}

	private static void checkRows (GameField gameField) {

		try {
			Field[] row = gameField.getRow(0);
		} catch (RowNotExistingException e) {
			System.err.println(e.getMessage() + "\nplease choose a row between 0 and 8...");
		}

		/*List<Field> multiples = multipleNumbersInRows(gameField);

		if (!multiples.isEmpty()) {
			errorRows = true;

		}
		else {
			errorRows = false;
		}


		String currentNumber;
		boolean found = false;
		String[][] gameNumbers = gameField.get2DNumberArray();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				switch (j) {
					case 0:
						for (int k = 0; k < 3; k++) {
							currentNumber = gameNumbers[i][j];
						}

					case 1:
					case 2:
				}
				currentNumber = gameNumbers[i][j];

				for (int k = 1; k < 3; k++) {
					if (currentNumber.equals(gameNumbers[i][k]) && !currentNumber.equals("") && j!=k) {
						errorFields.append(i);
						errorFields.append(j);
						errorFields.append(i);
						errorFields.append(k);
						found = true;
					}
					if (found)
						k = 8;
				}
			}
		}

		List<Field> numbers = new List<>();
		int length = 0;
		for (int i = 0; i < gameField.allFields.length; i++) {
			for (int j = 0; j < gameField.allFields[0].allFields.length; j++) {
				length++;
				numbers.append(gameField.allFields[i].allFields[j]);
			}
		}

		for (int i = 0; i < length; i++) {

		}*/

	}
}
