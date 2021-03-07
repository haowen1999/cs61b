/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		ArrayDeque<String> lld1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("Wang");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("study");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("cs61b");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(2);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addFirst(1);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(3);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addFirst(1);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(4);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(5);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(6);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(7);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeLast();
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(7);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(8);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addFirst(0);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;


		System.out.println("Printing item 4: " + lld1.get(4));
		System.out.println("Printing item 10: " + lld1.get(10));

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
}
