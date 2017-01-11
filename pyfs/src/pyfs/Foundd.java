package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author merij
 */
public class Foundd {

    mysql Mysql = new mysql();
    Found found1 = new Found();

    public Foundd() {
    }

    public void getLuggage() {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        String[] foundbagage = new String[5];
        foundbagage[0] = found1.getLugtype();
        foundbagage[1] = found1.getLugbrand();
        foundbagage[2] = found1.getLugcolor();
        foundbagage[3] = found1.getLugweight();
        foundbagage[4] = found1.getLugspef();

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            String primkey = "SELECT MAX(Lugagenr) FROM lugage ";
            ResultSet rs = st.executeQuery(primkey);

            String query = "INSERT INTO lugage (Lugagetype, Lugagebrand, Lugagecol, Lugageweight, Lugagespef, Lugagenr) VALUES (" + '"' + foundbagage[0] + '"' + "," + '"' + foundbagage[1] + '"' + "," + '"' + foundbagage[2] + '"' + "," + '"'
                    + foundbagage[3] + '"' + "," + '"' + foundbagage[4] + '"' + "," + '"' + +'"' + " )";

            st.executeUpdate(query);

        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public void getDate(String[] datex) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        
<<<<<<< HEAD
        
=======
        String[] datex = new String[4];
        datex[0] = found1.getDate().getText();
        datex[1] = found1.Time().getText();
        datex[2] = found1.getAirport();
        //datex[3] = found1.get VERGEET UNR NIET
>>>>>>> origin/master

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            
            
<<<<<<< HEAD
            String query = ("INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + datex[0] + '"' + "," + '"' + datex[1] + '"' + "," + '"' + datex[2] + '"' + " ,100)");
=======
            String query = "INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + datex[0] + '"' + "," + '"' + datex[1] + '"' + "," + '"' + datex[2] + '"' + "," + '"' + 100 + '"' + " )";
>>>>>>> origin/master
            st.executeUpdate(query);
        }
        catch (SQLException ed) {

            System.err.println(ed);

        }

    }}
