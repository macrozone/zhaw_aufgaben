
public class IntegerSet {
	
	private IntegerList data;
	
	
	public IntegerSet()
	{
		
	}
	
	public void addElement(int value)
	{
		if(data == null)
			data = new IntegerList(value);
		else if(!data.contains(value))
				data.addToTail(value);
		
	}
	
	
	public boolean hasElement(int value)
	{
		if(data == null)
			return false;
		else
			return data.contains(value);
	}
	
	@Override
	public String toString() {
		if(data == null)
			return "{}";
		else
			return "{"+data.toString()+"}";
	}
	
	public void union(IntegerSet otherSet)
	{
		if(otherSet != null)
		{
			
		}
	}

}
