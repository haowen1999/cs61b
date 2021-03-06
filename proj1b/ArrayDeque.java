public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static int INIT_CAPACITY = 8;
    private static int FACTOR = 2;
    private static double RATIO = 0.25;

    /** Creates an empty array deque.
     *  The starting size of your array should be 8. */
    public ArrayDeque() {
        array = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /** Helper method: minus one of the index. */
    private int minusOne(int index) {
        index = index - 1;
        if (index < 0) {
            index = array.length - 1;
        }
        return index;
    }

    /** Helper method: plus one of the index. */
    private int plusOne(int index) {
        index = index + 1;
        if (index > array.length - 1) {
            index = 0;
        }
        return index;
    }

    /** Helper method: Resize the array. */
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int start = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newArray[i] = array[start];
            start = plusOne(start);
        }
        array = newArray;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /** Helper method: Check resize. */
    private void checkResize() {
        if (size == array.length) {
            resize(size * FACTOR);
        }
        if (array.length >= 16 && size < array.length * RATIO) {
            resize(array.length / FACTOR);
        }
    }

    /** Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item) {
        checkResize();
        array[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T item) {
        checkResize();
        array[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last,
     *  separated by a space. Once all the items have been printed,
     *  print out a new line. */
    @Override
    public void printDeque() {
        int index = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(array[index] + " ");
            index = plusOne(index);
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T first = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;
        if (size < 0) {
            size = 0;
        }

        checkResize();

        return first;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T last = array[nextLast];
        array[nextLast] = null;
        size -= 1;
        if (size < 0) {
            size = 0;
        }

        checkResize();

        return last;
    }

    /** Gets the item at the given index, where 0 is the front,
     *  1 is the next item, and so forth. If no such item exists,
     *  returns null. Must not alter the deque! */
    @Override
    public T get(int index) {
        int pos = nextFirst + 1 + index;
        int diff = array.length - pos;
        if (index >= size) {
            return null;
        } else if (diff > 0) {
            return array[pos];
        } else {
            return array[-diff];
        }
    }
}
