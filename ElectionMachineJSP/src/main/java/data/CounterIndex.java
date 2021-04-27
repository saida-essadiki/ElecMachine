package data;

public class CounterIndex {

	private int index;
	
	public CounterIndex() {
		// TODO Auto-generated constructor stub
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setIndex(String index) {
		try {
			this.index = Integer.parseInt(index);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public void higherIndex() {
		index++;
	}
	public void lowerIndex() {
		index--;
	}
}
