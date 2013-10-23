import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

	private T value;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private BinaryTree<T> replaceTree;

	public BinaryTree(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void addValue(T value) {
		if (left == null) {
			left = new BinaryTree<T>(value);
			left.parent = this;
		} else if (value.compareTo(left.getValue()) <= 0)
			left.addValue(value);
		else if (right == null) {
			right = new BinaryTree<T>(value);
			right.parent = this;
		} else
			right.addValue(value);
	}

	public void addValue(List<T> values) {
		for (T value : values)
			addValue(value);
	}

	public void remove(T value) {
		if (this.value.equals(value)) {
			// remove me
			replaceMe();
			


		} else {
			if (left != null)
				left.remove(value);
			if (right != null)
				right.remove(value);
		}
	}

	private void replaceMe() {
		
		BinaryTree<T> 	replaceTree = 

		left.parent = this.parent;
		right.parent = this.parent;
		if (this.parent != null) {
			this.parent.left = left;
			this.parent.right = right;
		}
		
	}

	public int getDepth() {
		if (left == null && right == null)
			return 1;

		if (left == null)
			return 1 + right.getDepth();
		if (right == null)
			return 1 + left.getDepth();

		return Math.max(left.getDepth(), right.getDepth());
	}

	public int getSize() {
		int size = 1;
		if (left != null)
			size += left.getSize();
		if (right != null)
			size += right.getSize();
		return size;

	}
	
	public BinaryTree<T> getMinTree()
	{
		if(left == null && right == null)
			return this;
		if(right == null)
			return left.getMinTree();
		if(left == null)
			return right.getMinTree();
		return right.getMinTree(); // prefer right
	}

	public boolean contains(T value) {

		if (value.equals(this.value))
			return true;
		if (left == null && right == null)
			return false;
		if (left == null)
			return right.contains(value);
		if (right == null)
			return left.contains(value);
		return left.contains(value) || right.contains(value);

	}

}
