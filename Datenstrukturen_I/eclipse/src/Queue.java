import java.util.LinkedList;

public class Queue<T> {

	private LinkedList<T> data;

	public Queue() {
		data = new LinkedList<T>();
	}

	public void offer(T element) {
		data.add(element);
	}

	public T poll() {
		if (data.size() > 0)
			return data.removeFirst();
		else
			return null;
	}

	public boolean isEmpty() {
		return data.size() > 0;
	}

	public int getSize() {
		return data.size();
	}

}
