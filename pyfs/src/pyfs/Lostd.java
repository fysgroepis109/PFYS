package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author Jaros
 */
public class Lostd {

    mysql Mysql = new mysql();
    Lost lost1 = new Lost();

    private String name;
    private String[] persoon;
    private String[] date;

    public void setDate(String[] date) {
        this.date = date;
    }

    public void setP(String[] persoon) {
        this.persoon = persoon;
    }

    public int invullenP() {

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        Connection conn;
        int count5 = 0;
        int count6 = 0;
        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected persoon");
            Statement stmt = (Statement) conn.createStatement();

            ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) AS total FROM persoon where zip = '" + persoon[3] + "' and country = '" + persoon[4] + "'");

            while (rs5.next()) {
                count5 = rs5.getInt("total");
            }

            if (count5 > 0) {

                ResultSet rs6 = stmt.executeQuery("SELECT Pnr FROM persoon where name = " + "'" + persoon[0] + "' and zip = '" + persoon[3]
                        + "' and country = '" + persoon[4] + "'");

                while (rs6.next()) {
                    count6 = rs6.getInt("Pnr");
                }

                String query = ("UPDATE persoon SET adress = '" + persoon[1] + "' ,city = '" + persoon[2] + "' ,tel = '" + persoon[5] + "' ,mail = '" + persoon[6]
                        + "' where zip = '" + persoon[3] + "' and country = '" + persoon[4] + "'");

                Statement st = conn.createStatement();
                st.executeUpdate(query);

            } else {
                ResultSet rs7 = stmt.executeQuery("SELECT COUNT(*) AS TOTAL FROM persoon");
                while (rs7.next()) {
                    count6 = rs7.getInt("total");
                    count6++;
                    System.out.println(count6);
                }

                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                String query = "INSERT INTO persoon (Pnr, name, adress, city, zip, country, tel, mail)"
                        + "values" + "( '" + count6 + "', '" + persoon[0] + "', '" + persoon[1] + "', '" + persoon[2] + "', '" + persoon[3]
                        + "', '" + persoon[4] + "', '" + persoon[5] + "', '" + persoon[6] + "')";

                Statement st = conn.createStatement();
                st.executeUpdate(query);

            }

        } catch (SQLException ed) {

            System.err.println(ed);

        }
        return count6;
    }

    public void invullenb() {

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        Connection conn;

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected persoon");
            Statement stmt = (Statement) conn.createStatement();

            ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) AS total FROM persoon where name = " + '"' + name + '"');

            while (rs5.next()) {
                //count5 = rs5.getInt("total");
            }

        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public int Unr() {

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        Connection conn;
        int count7 = 0;

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected persoon");
            Statement stmt = (Statement) conn.createStatement();

            ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) AS total FROM Unr");

            while (rs5.next()) {
                count7 = rs5.getInt("total");
            }
            count7++;

        } catch (SQLException ed) {

            System.err.println(ed);

        }
        return count7;
    }

    public void getLuggage(String[] lostbagage) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        int Pnr = 3;
        int Unr = 3;
        int Lugagenr = 3;

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();

            String query = "INSERT INTO lugage (Lugagelnr, Lugagetype, Lugagebrand, Lugagecol, Lugeweight, Lugagewespef, Unr,Pnr) VALUES (" + '"' + Lugagenr + '"' + "," + '"' + lostbagage[0] + '"' + "," + '"' + lostbagage[1] + '"' + "," + '"'
                    + lostbagage[2] + '"' + "," + '"' + lostbagage[3] + '"' + "," + '"' + lostbagage[4] + '"' + "," + '"' + Unr + '"' + "," + '"' + Pnr + '"' + " )";

            st.executeUpdate(query);

        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public void getDate(int Unr) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();

            String query = ("INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + date[0] + '"' + "," + '"' + date[1] + '"' + "," + '"' + date[2] + '"' + " ," + Unr + ")");

            st.executeUpdate(query);
        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public void getLabel(String[] label) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();

            String query = ("INSERT INTO flight (Unr, labelnr, flightnr, destin) VALUES (" + 12 + "," + '"' + label[0] + '"' + "," + '"' + label[1] + '"' + "," + '"' + label[2] + '"' + ")");

            //String query = "INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + datex[0] + '"' + "," + '"' + datex[1] + '"' + "," + '"' + datex[2] + '"' + "," + '"' + 100 + '"' + " )";
            st.executeUpdate(query);
        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public void zoeken(String labelnr) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        int count = 0;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet rs5 = stm.executeQuery("SELECT COUNT(*) AS total FROM flight where lablenr = '" + labelnr + "';");

            while (rs5.next()) {
                count = rs5.getInt("total");
            }
            if(count > 0){
                
            }
            

        } catch (SQLException ed) {
            System.err.println(ed);
        }
    }
}
