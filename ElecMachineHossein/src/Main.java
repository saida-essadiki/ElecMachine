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
        String DBpath = "//localhost:3306/qadb";
        String username = "root";
        String password = "Hh4497";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver).newInstance();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "poo!!", ex);
        }

        try {
            // con = DriverManager.getConnection("jdbc:mysql:" + DBpath + ";create=false");
            // // Creating connection to the database
            con = DriverManager.getConnection("jdbc:mysql:" + DBpath, username, password); // Creating connection to the
                                                                                            // database

            stmt = con.createStatement();

            // Create a Table to the Database

            String sql;

            sql = "DROP TABLE FIRSTTABLE";

            try {
                stmt.executeUpdate(sql);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Failed dropping the Table", ex);
                // System.exit(0);
            }

//            sql = "CREATE TABLE FIRSTTABLE ("
//                    + "ID INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,"
//                    + "FIRSTNAME VARCHAR(40) NOT NULL,"
//                    + "LASTNAME VARCHAR(40) NOT NULL)";

            sql = "CREATE TABLE `qadb`.`FIRSTTABLE` (" + "`id` INT NOT NULL AUTO_INCREMENT, "
            //sql = "CREATE TABLE `demo`.`FIRSTTABLE` (" + "`id` INT NOT NULL, "
                    + "`FIRSTNAME` VARCHAR(45) NOT NULL," + "`LASTNAME` VARCHAR(45) NOT NULL,"
                    + "  PRIMARY KEY (`id`))";

            try {
                stmt.executeUpdate(sql);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Creating table failed", ex);
                // System.exit(0);
            }

            try {
                sql = "INSERT INTO FIRSTTABLE(ID, FIRSTNAME, LASTNAME) VALUES(1, 'Mauno', 'Koivisto')";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO FIRSTTABLE(ID, FIRSTNAME, LASTNAME) VALUES(2, 'Tellervo', 'Koivisto')";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO FIRSTTABLE(ID, FIRSTNAME, LASTNAME) VALUES(3, 'Martti', 'Ahtisaari')";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO FIRSTTABLE(ID, FIRSTNAME, LASTNAME) VALUES(4, 'Urho', 'Kekkonen')";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO FIRSTTABLE(ID, FIRSTNAME, LASTNAME) VALUES(5, 'Tarja', 'Halonen')";
                stmt.executeUpdate(sql);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Adding a row failed!", ex);
            }

            try {
                sql = "DELETE FROM FIRSTTABLE WHERE ID = 2";
                stmt.executeUpdate(sql);
                System.out.println("Was here: For debuging!");
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Deleting a row failed!", ex);
                // System.exit(0);
            }

            // Reading information from the table
            sql = "SELECT * FROM FIRSTTABLE";
            rs = stmt.executeQuery(sql); // Huomaa nyt on kyseessä query ei update

            // Trying to read data without first using rs.next()
            try {
                int i = rs.getInt("ID"); // There is also other version for getInt which relies on column index number
                System.out.println("i: " + i + "\n");
            } catch (Exception ex) {
                System.out.println("*** Does not work without first using rs.next()!!! ***");
                // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Going through the results
            while (rs.next()) {
                int i = rs.getInt("ID");
                System.out.println("i: " + i);
            }

            // Closing ResultSet, Statement and Connection

        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Something went wrong in the whole process!", e);
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