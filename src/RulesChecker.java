public class RulesChecker {

	static boolean errorInput = false;
	static boolean errorInnerField = false;
	static boolean errorRows = false;
	static boolean errorColumns = false;
	static Field currentField = new Field();
	static List<Field> errorFields = new List<>();

	private static void resetErrors () {
		errorInput = false;
		errorInnerField = false;
		errorRows = false;
		errorColumns = false;
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
			System.err.println();
		}

		if (newInput == ' ')
			errorInput = true;
	}

	public static void checkRules (Field field) {
		currentField = field;
		errorFields = new List<>();

		resetErrors();
		UserInterface.gameField.setAllFieldsTextBlack();

			checkInnerField(UserInterface.gameField.getInnerfieldOfField(field));
			checkRows();
			checkColumns();

			if (errorInnerField || errorRows || errorColumns) {
				if (errorInnerField) {
					System.out.print("innerfield error");
				}
				if (errorRows) {
					System.out.print("rows error");
				}
				if (errorColumns) {
					System.out.print("columns error");
				}

				UserInterface.error();
			} else {
				UserInterface.resetInfoBox();
			}
	}

	public static void checkInnerField (InnerField innerField) {
		errorInnerField = getMultipleNumbers(innerField.fields);
	}

	public static void checkRows () {
		Field[] row = UserInterface.gameField.getRow(currentField, UserInterface.gameField.getRowPosOfField(currentField));

		errorRows = getMultipleNumbers(row);
	}

	public static void checkColumns () {
		Field[] column = UserInterface.gameField.getColumn(currentField, UserInterface.gameField.getColumnPosOfField(currentField));

		errorColumns = getMultipleNumbers(column);
	}

	public static boolean getMultipleNumbers (Field[] array) {
		String currentNumber;
		boolean error = false;
		String[] numbers = fieldToStringArray(array);

		for (int i = 0; i < numbers.length - 1; i++) {
			currentNumber = numbers[i];

			for (int j = i + 1; j < numbers.length; j++) {

				if (currentNumber.equals(numbers[j]) && !currentNumber.equals("") && !currentNumber.equals(" ")) {
					error = true;

					if (currentField == array[i]) {
						errorFields.append(array[j]);

					} else if (currentField == array[j]) {
						errorFields.append(array[i]);
					}
				}
			}
		}

		return error;
	}

	private static String[] fieldToStringArray (Field[] arr) {
		String[] array = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			array[i] = arr[i].getText();
		}

		return array;
	}
}