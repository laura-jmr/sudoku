import java.awt.*;

public class RulesChecker {

	public static boolean rechecked = true;
	public static boolean errorInput = false;
	public static boolean errorInnerField = false;
	public static boolean errorRows = false;
	public static boolean errorColumns = false;
	public static int currentNumberPos;
	static Field currentField;
	static Field oldField;
	public static List<Field> errorFields;


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

		if (newInput == ' ') {
			errorInput = true;
		}

	}

	public static void checkRules (InnerField innerField, Field field) {
		if (!rechecked) {
			oldField = currentField;
			currentField = field;
			rechecking(innerField, field);
		} else {
			currentField = field;

			resetErrors();
			checkInnerField(innerField);
			//checkRows(innerField.gameField);

			if (errorInnerField || errorRows || errorColumns) {
				UserInterface.error();
			}
		}


	}

	private static void rechecking (InnerField innerField, Field field) {
		for (int i = 0; i < oldField.getInnerField().allFields.length; i++) {
			if(oldField.getInnerField().allFields[i].getForeground() == Color.red) {
				oldField.getInnerField().allFields[i].setForeground(Color.black);
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


	private static void resetErrors () {
		errorInput = false;
		errorInnerField = false;
		errorRows = false;
		errorColumns = false;
		currentNumberPos = 0;
		rechecked = true;
		errorFields = new List<>();
	}

	private static void checkRows (GameField gameField) {
		/*List<Field> multiples = multipleNumbersInRows(gameField);

		if (!multiples.isEmpty()) {
			errorRows = true;

		}
		else {
			errorRows = false;
		}*/


		/*String currentNumber;
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
		}*/

		List<Field> numbers = new List<>();
		int length = 0;
		for (int i = 0; i < gameField.allFields.length; i++) {
			for (int j = 0; j < gameField.allFields[0].allFields.length; j++) {
				length++;
				numbers.append(gameField.allFields[i].allFields[j]);
			}
		}

		for (int i = 0; i < length; i++) {

		}

	}

	private static List<Field> multipleNumbersInRows (GameField gameField) {
		String currentNumber;
		boolean found = false;
		errorFields = new List<>();
		/*String[][] gameNumbers = gameField.get2DNumberArray();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				currentNumber = gameNumbers[i][j];
				for (int k = 1; k < 9; k++) {
					if (currentNumber.equals(gameNumbers[i][k]) && !currentNumber.equals("") && j!=k) {
						//System.out.println("found multiiple numbers! Pos: y: " + i + " x: " + j + " 2Pos: y: " + i + " x: " + k );
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
		}*/
		return errorFields;
	}

	private static void checkInnerField (InnerField innerField) {
		String[] numbers = innerField.getNumberArray();
		String currentNumber;

		for (int i = 0; i < numbers.length - 1; i++) {
			currentNumber = numbers[i];

			for (int j = i + 1; j < numbers.length; j++) {

				if (currentNumber.equals(numbers[j]) && !currentNumber.equals("")) {
					errorInnerField = true;

					if (currentField == innerField.allFields[i]) {
						errorFields.append(innerField.allFields[j]);

					} else if (currentField == innerField.allFields[j]) {
						errorFields.append(innerField.allFields[i]);
					}
				}
			}
		}
	}
}
