package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Question;
import data.CustomerAnswers;


public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	// create getconnection method - create a connection to database 
		
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	            System.out.println("conn is created!!");
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// readAllQuestion() method
	public ArrayList<Question> readAllQuestion() {
		ArrayList<Question> list=new ArrayList<>();
		try {
			String sql = "SELECT * FROM questions";
			getConnection();
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery(sql);
			while (RS.next()){
				Question q=new Question();
				q.setId(RS.getInt("QUESTION_ID"));
				q.setQuestion(RS.getString("QUESTION"));
				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	// readQuestion() method
	public ArrayList<Question> readQuestion(Question q) {
		ArrayList<Question> singleQuestion=new ArrayList<>();
		try {
			String sql="SELECT * FROM questions WHERE QUESTION_ID=?";
			getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, q.getId());
			ResultSet RS=pstmt.executeQuery(sql);

			q.setId(RS.getInt("QUESTION_ID"));
			q.setQuestion(RS.getString("QUESTION"));
			singleQuestion.add(q);
			return singleQuestion;

		}
		catch(SQLException e) {
			return null;
		}
	}
	
	
	// update question text with updateQuestion(Question q) method
	public ArrayList<Question> updateQuestion(Question q) {
		try {
			String sql="UPDATE questions SET QUESTION= ? WHERE QUESTION_ID=?";
			getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getQuestion());
			pstmt.setInt(2, q.getId());
			pstmt.executeUpdate();
			return readAllQuestion();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	// deleteQuestion() method
	public ArrayList<Question> deleteQuestion(String id) {
		try {
			String sql="delete from questions where QUESTION_ID=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllQuestion();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	// readQuestion method
	public Question readQuestion(String id) {
		Question f=null;
		try {
			String sql="select * from questions where QUESTION_ID=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Question();
				f.setId(RS.getInt("QUESTION_ID"));
				f.setQuestion(RS.getString("QUESTION"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
	// update customer_answers table with customers answers customerAnswer(CustomerAnswers a) method
	public ArrayList<CustomerAnswers> customerAnswer(CustomerAnswers a) {

		try {


			String sql="UPDATE CUSTOMER_ANSWERS SET ANSWER=? WHERE QUESTION=?";
			getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(2, a.getNumber());
			pstmt.setInt(1, a.getAnswer());
			pstmt.executeUpdate();
			return readAllAnswers();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	// readAllAnswers() method
	public ArrayList<CustomerAnswers> readAllAnswers() {
		ArrayList<CustomerAnswers> list=new ArrayList<>();
		try {
			String sql = "SELECT * FROM CUSTOMER_ANSWERS";
			getConnection();
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery(sql);
			while (RS.next()){
				CustomerAnswers q=new CustomerAnswers();
				q.setNumber(RS.getInt("NUMBER"));
				q.setAnswer(RS.getInt("ANSWER"));
				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
}
