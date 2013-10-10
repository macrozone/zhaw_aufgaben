
public class IntegerList {

	private int value;
	private IntegerList tail;
	
	public IntegerList(int value)
	{
		this.value = value;
	}

	public IntegerList(int value, IntegerList tail)
	{
		this.value = value;
		this.tail = tail;
	}
	
	public void addToTail(int value)
	{
		if(this.tail == null)
			this.tail = new IntegerList(value);
		else
			this.tail.addToTail(value);
	}
	
	public int removeHead()
	{
		if(this.tail == null)
			throw new NullPointerException("cannot remove my own head");
		int headValue = this.getHeadValue();
		
		this.value = this.tail.getHeadValue();
		this.tail = this.tail.tail;
		return headValue;
	}
	
	public void addToHead(int value)
	{
		this.tail = new IntegerList(this.value, this.tail);
		this.value = value;
	}
	
	public int getHeadValue()
	{
		return value;
	}
	
	public int getTailValue()
	{
		if(this.tail == null)
			return getHeadValue();
		else
			return this.tail.getTailValue();
	}
	

	public int getSize()
	{
		if(this.tail == null)
			return 1;
		else
			return 1+this.tail.getSize();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof IntegerList))
			return false;
		IntegerList otherList = (IntegerList) obj;
		
		if(this.getHeadValue() != otherList.getHeadValue())
			return false;
		
		if(this.tail != null && otherList.tail != null)
			return tail.equals(otherList.tail);
		
		return this.tail == null && otherList.tail == null;

	}
	
	public boolean contains(int value)
	{
		if(this.value == value)
			return true;
		
		if(this.tail != null)
			return this.tail.contains(value);
		else
			return false;
			
	}
	
	@Override
	public String toString() {
		
		return this.value+(this.tail != null ? ","+this.tail.toString() : "");
		
	}
	
	
	
}
