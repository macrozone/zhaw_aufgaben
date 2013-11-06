import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

	private T value;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void addValue(T value) {

		if (value.compareTo(getValue()) < 0) {
			// goes left
			if (left == null) {
				left = new BinaryTree<T>(value);
				left.parent = this;
			} else {
				left.addValue(value);
			}
		} else {

			// goes right
			if (right == null) {
				right = new BinaryTree<T>(value);
				right.parent = this;
			} else {
				right.addValue(value);
			}
		}

	}

	public void addValue(List<T> values) {
		for (T value : values)
			addValue(value);
	}

	public void remove(T value) {
		if (this.value.equals(value)) {
			removeMe();
		} else {
			if (left != null)
				left.remove(value);
			if (right != null)
				right.remove(value);
		}
	}

	private void removeMe() {

		BinaryTree<T> replaceTree = getMinTree();

		this.value = replaceTree.value;

		if (replaceTree.parent.left == replaceTree)
			replaceTree.parent.left = null;
		else if (replaceTree.parent.right == replaceTree)
			replaceTree.parent.right = null;
		replaceTree.parent = null;

		// replaceTree is no orphan

	}

	public int getDepth() {
		if (left == null && right == null)
			return 1;

		if (left == null)
			return 1 + right.getDepth();
		if (right == null)
			return 1 + left.getDepth();

		return 1 + Math.max(left.getDepth(), right.getDepth());
	}

	public int getSize() {
		int size = 1;
		if (left != null)
			size += left.getSize();
		if (right != null)
			size += right.getSize();
		return size;

	}

	public BinaryTree<T> getMinTree() {
		if (left == null && right == null)
			return this;
		if (right == null)
			return left.getMinTree();
		if (left == null)
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

	@Override
	public String toString() {
		String string = "[";
		string += " "+value.toString()+" ";
		if (left != null)
			string += left.toString();
		if (right != null)
			string += right.toString();
		return string + "]";

	}

}
