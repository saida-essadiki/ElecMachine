package data;

public class Question {
	private int id;
	private String questionText;
	
	public Question(String id, String questionText) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.questionText = questionText;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	// getter and setter for question ID (id)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	// getter and setter for question text (questionText)
	public String getQuestion() {
		return questionText;
	}
	public void setQuestion(String questionText) {
		this.questionText = questionText;
	}

}





