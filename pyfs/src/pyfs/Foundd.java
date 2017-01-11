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

    public void getLuggage(String [] foundbagage) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        
        int Pnr = 2;
        int Unr = 2;
        int Lugagenr = 2;

       
        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            

            String query = "INSERT INTO lugage (Lugagelnr, Lugagetype, Lugagebrand, Lugagecol, Lugeweight, Lugagewespef, Unr,Pnr) VALUES (" + '"' + Lugagenr + '"' + "," + '"' + foundbagage[0] + '"' + "," + '"' + foundbagage[1] + '"' + "," + '"'
                    + foundbagage[2] + '"' + "," + '"' + foundbagage[3] + '"' + "," + '"' + foundbagage[4]  +'"' + "," + '"' + Unr  + '"' +  "," + '"' + Pnr  +'"' + " )";

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


        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            
            

            String query = ("INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + datex[0] + '"' + "," + '"' + datex[1] + '"' + "," + '"' + datex[2] + '"' + " ,100)");

            //String query = "INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + datex[0] + '"' + "," + '"' + datex[1] + '"' + "," + '"' + datex[2] + '"' + "," + '"' + 100 + '"' + " )";

            st.executeUpdate(query);
        }
        catch (SQLException ed) {

            System.err.println(ed);

        }

    }

 public void getTicket(String[] info) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();


        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            
            

            String query = ("INSERT INTO dta (Unr, labelnr, flightnr, destin) VALUES (" + '"' + 100 + '"' + "," + '"' + info[0] + '"' + "," + '"' + info[1] + '"' + "," + '"' +  info[2]+ '"' + ")");

            //String query = "INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + datex[0] + '"' + "," + '"' + datex[1] + '"' + "," + '"' + datex[2] + '"' + "," + '"' + 100 + '"' + " )";

            st.executeUpdate(query);
        }
        catch (SQLException ed) {

            System.err.println(ed);

        }

    }






}
