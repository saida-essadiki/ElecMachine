import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.lang.Math;


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

        
        Random rand = new Random();
        
        int num = 4; //number of candidates
        int que = 19; // number of question
        
        int[] customer1_Ans= new int[que];
        for (int k=0; k < customer1_Ans.length;k++) {
            int n = 1 + rand.nextInt(5);
        	customer1_Ans[k]= n;
        	System.out.println("customer1 question"+(k+1)+ " answer is "+ customer1_Ans[k]);
        }
        
        
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
            
	        // 1st part is candidate ID and 2nd part is question number
	        int[][] ans = new int[num][que];

            // Here we are going through all answers from candidate which is available in database in answers TABLE
            // we have also have an array for this customer answers
            // We compare the answers of a customer for all question (1 by 1 for answers)
            
            // going through Candidates (for example for 4 first candidate)
            for(int i = 1; i <= num; i++){
            	
            	// for test i value
            	//System.out.println(i);
            	
            	// going through questions (que=19 question available)
                	
        	        
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
            	            System.out.println("candidate "+i+" question "+j+ " is "+ans[i-1][j-1]);
            	            // System.out.println("Answer of candidate "+i+" for question "+j+ " is "+ ans[i-1][j-1]);
            	            j++;
        	        	}
        	        }
  	
                }
            // here we are going to calculate the point of customer1 similarity to each candidate in percent
            double[] point = new double[num];
            for (int m=0;m<num;m++) {
                point[m] = 0;
            	for(int n=0;n<que;n++) {

                    
                    //for test
                    //System.out.println("Ready?!? "+ m + " "+ n);
                    //System.out.println("candidateAns "+ans[m][n]);
                    //System.out.println("customer "+ customer1_Ans[n]);
                    double abs;
                    if(ans[m][n]<customer1_Ans[n]) {
                    	abs = ((4-customer1_Ans[n]+ans[m][n])*0.25*5.263);
                    	//abs = (3*0.25);
                    }else {
                    	abs =((4-ans[m][n]+customer1_Ans[n])*0.25*5.263);
                    	//abs = (1*0.25);

                    }
                    // for test
                    //System.out.println("abs: "+abs);
                	point[m] = point[m]+abs;
                    //System.out.printf("%.2f\n",point[m]);

            	}
            }
            System.out.printf("%.2f\n",point[0]);
            System.out.printf("%.2f\n",point[1]);
            System.out.printf("%.2f\n",point[2]);
            System.out.printf("%.2f\n",point[3]);

	        try {
	            sql = "INSERT INTO CUSTOMER_RESAULT(CUSTOMER_ID, COMPARE_CAN1, COMPARE_CAN2, COMPARE_CAN3, COMPARE_CAN4) VALUES(3,"+ point[0]+","+ point[1]+","+ point[2]+","+ point[3]+")";


	            stmt.executeUpdate(sql);

	        } catch (Exception ex) {
	            Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Adding a row failed!", ex);
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