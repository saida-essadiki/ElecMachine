package data;

public class CustomerAnswers {

	private int number;
	private int answer;

	
	public CustomerAnswers() {
		// TODO Auto-generated constructor stub
	}
	public CustomerAnswers(int number, int answer) {
		this.number = number;
		this.answer = answer;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setNumber(String number) {
		try {
			this.number = Integer.parseInt(number);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public void setAnswer(String answer) {
		try {
			this.answer = Integer.parseInt(answer);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}

	
}
