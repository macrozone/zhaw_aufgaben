public class IntegerSet {

	private IntegerList data;

	public IntegerSet() {

	}

	public void addElement(int value) {
		if (data == null)
			data = new IntegerList(value);
		else if (!data.contains(value))
			data.addToTail(value);

	}

	public boolean hasElement(int value) {
		if (data == null)
			return false;
		else
			return data.contains(value);
	}

	@Override
	public String toString() {
		if (data == null)
			return "{}";
		else
			return "{" + data.toString() + "}";
	}

	public int getSize() {

		if (data == null)
			return 0;
		else
			return data.getSize();
	}

	public int removeElement() {
		if (data == null)
			throw new NullPointerException(
					"cannot remove element from empty set");
		if (data.getSize() > 1)
			return data.removeHead();
		else {
			int value = data.getHeadValue();
			data = null;
			return value;
		}
	}

	public void union(IntegerSet otherSet) {

		if (otherSet != null) {

			otherSet = (IntegerSet) otherSet.clone();

			while (otherSet.getSize() > 0)
				addElement(otherSet.removeElement());

		}
	}

	public void interSec(IntegerSet otherSet) {
		if (otherSet != null) {
			otherSet = (IntegerSet) otherSet.clone();

			IntegerList intersection = null;
			while (otherSet.getSize() > 0) {
				int value = otherSet.removeElement();
				if (hasElement(value)) {
					if (intersection == null)
						intersection = new IntegerList(value);
					else
						intersection.addToTail(value);
				}
			}
			data = intersection;
		} else {
			// make empty set
			data = null;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof IntegerSet))
			return false;
		IntegerSet otherSet = (IntegerSet) obj;

		if (getSize() != otherSet.getSize())
			return false;

		otherSet = (IntegerSet) otherSet.clone();

		otherSet.union(this);
		System.out.println(otherSet.getSize());

		return otherSet.getSize() == getSize();
	}

	public IntegerSet clone() {
		IntegerSet clone = new IntegerSet();
		if (data != null)
			clone.data = data.clone();

		return clone;
	}

}
