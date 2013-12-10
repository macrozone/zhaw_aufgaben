public class Stack<T> {

	private static final int DEFAULT_SIZE = 1000;
	private T[] data;
	private int position = 0;

	public Stack() {
		data = (T[]) new Object[DEFAULT_SIZE];
	}

	public void push(T entry) {
		if (position >= data.length)
			throw new RuntimeException("cannot push, stack is full");
		data[position] = entry;
		position++;
	}

	public T pop() {
		if (position <= 0)
			throw new RuntimeException("cannot pop, stack is empty");
		position--;
		return data[position];
	}

	public boolean isEmpty() {
		return position == 0;
	}

	public int getSize() {
		return position;
	}

}
