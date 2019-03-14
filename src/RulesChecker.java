import java.awt.*;

public class RulesChecker {

	public static boolean rechecked = true;
	public static boolean errorInput = false;
	public static boolean errorInnerField = false;
	public static boolean errorRows = false;
	public static boolean errorColumns = false;
	public static boolean errorDiagLR = false;
	public static boolean errorDiagRL = false;
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

			if (errorInnerField || errorRows || errorColumns || errorDiagLR || errorDiagRL) {
				UserInterface.error();
			}
		}

		//checkRows(innerField.gameField);
	}

	private static void rechecking (InnerField innerField, Field field) {
		if (oldField == field) {
			for (int i = 0; i < oldField.getInnerField().allFields.length; i++) {
				if(oldField.getInnerField().allFields[i].getForeground() == Color.red) {
					oldField.getInnerField().allFields[i].setForeground(Color.black);
				}
			}
			errorFields = new List<>();
			rechecked = true;
			checkRules(innerField, field);
			return;
		} else {
			for (int i = 0; i < oldField.getInnerField().allFields.length; i++) {
				if(oldField.getInnerField().allFields[i].getForeground() == Color.red) {
					oldField.getInnerField().allFields[i].setForeground(Color.black);
				}
			}
			rechecked = true;
			checkRules(innerField, field);
		}
	}


	private static void resetErrors () {
		errorInput = false;
		errorInnerField = false;
		errorRows = false;
		errorColumns = false;
		errorDiagLR = false;
		errorDiagRL = false;
		currentNumberPos = 0;
		rechecked = true;
		errorFields = new List<>();
	}

	private static void checkRows (GameField gameField) {
		/*List<Integer> multiples = multipleNumbersInRows(gameField);

		if (!multiples.isEmpty()) {
			error = true;

		}
		else {
			error = false;
		}*/
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
