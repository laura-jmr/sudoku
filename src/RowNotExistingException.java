public class RowNotExistingException extends Exception {

	public RowNotExistingException (int r) {
		new Exception("!the row " + r + " does not exist in the gamefield!");
	}
}
