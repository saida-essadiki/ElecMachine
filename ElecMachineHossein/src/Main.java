import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tlahti
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String driver = "com.mysql.jdbc.Driver";
        String DBpath = "//localhost:3306/election_machine";
        String username = "root";
        String password = "Hh4497";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        
        // IN GENERAl try and catches are here to help us find our errors and where they happen.
        
        
        try {
            Class.forName(driver).newInstance();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "poo!!", ex);
        }

        
        // Here we are trying to create connection to our database, with the variables are created created at the beginning the code which are related to our database information details 
        try {
            // con = DriverManager.getConnection("jdbc:mysql:" + DBpath + ";create=false");
            // // Creating connection to the database
            con = DriverManager.getConnection("jdbc:mysql:" + DBpath, username, password); // Creating connection to the
                                                                                            // database

            stmt = con.createStatement();
            String sql;

            // Here we are going through all answers from candidate which is available in database in answers TABLE
            // we have also have an array for this customer answers
            // We compare the answers of a customer for all question (1 by 1 for answers)
            
            // going through Candidates (for example for first candidate)
            for(int i = 1; i < 2; i++){
            	System.out.println(i);
            	// going through questions (19 question available)
                	
        	        // 1st part is candidate ID and 2nd part is question number
        	        int[][] ans = new int[1][19];
        	        
                	sql = "SELECT * FROM ANSWERS";
                	
                	// for test
                	//System.out.println(sql);
                	rs = stmt.executeQuery(sql); // Note now this is a query not an update
        	        
    	         	int j=1;
        	        while (rs.next()) {

        	        	if (i==rs.getInt("CANDIDATE_ID")) {
        	        		
        	        		// just for test to find out were is the bug
                        	// System.out.println("CANDIDATE_ID is "+ rs.getInt("CANDIDATE_ID"));
                        	// System.out.println(i+" and "+j);
                        	int Answer = rs.getInt("ANSWER");
            	            ans[i-1][j-1] = Answer;
            	            
            	            // for test that ans array is working
            	            System.out.println(ans[i-1][j-1]);
            	            // System.out.println("Answer of candidate "+i+" for question "+j+ " is "+ ans[i-1][j-1]);
            	            j++;
        	        	}
        	        }
  	
                }  
            	
            
    
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Something went wrong in the whole process!!", e);
        } finally {

            System.out.println("Closing everything!");

            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Wow, I think everything worked nicely!... But still I somehow doubt :)");
        }
    }
}