/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author merij
 */
public class Admind {
    
    Admin admin1 = new Admin();
    mysql Mysql = new mysql();

    public Admind() {
    }
    
    public void Add() {
        
       String addUsername = admin1.getTextAddusername();
                String addPassword = admin1.getTextAddpassword();
                String addToegang = admin1.getTextAddtoegang();

                Connection conn;                                                            //making connection to database

                final String USERNAME = Mysql.username();
                final String PASSWORD = Mysql.password();
                final String CONN_STRING = Mysql.urlmysql();

                try {

                    conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                    String query = "INSERT INTO login (username, password, toegang) VALUES (" + '"' + addUsername + '"' + "," + '"' + addPassword + '"' + "," + '"' + addToegang + '"' + " )";
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);

                } catch (SQLException ed) {

                    System.err.println(ed);

                }
        
        
        
        
    }
    
    public void Delete() {
        
         String removeUsername = admin1.getTextRemoveusername();
                String removePassword = admin1.getTextRemovepassword();

                Connection conn;                                                            //making connection to database

                final String USERNAME = Mysql.username();
                final String PASSWORD = Mysql.password();
                final String CONN_STRING = Mysql.urlmysql();

                try {

                    conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                    String query = "DELETE FROM login WHERE username =" + '"' + removeUsername + '"' + "AND password = " + '"' + removePassword + '"' + "";
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);

                } catch (SQLException ed) {

                    System.err.println(ed);

                }
        
        
        
        
    }
    
    public void Update() {
        
         String updateUsername = admin1.getTextUpdateusername();
                String updatePassword = admin1.getTextUpdatepassword();
                String updateToegang = admin1.getTextUpdatetoegang();
                String updateCurrentUsername = admin1.getTextUpdateCurrent();

                Connection conn;                                                            //making connection to database

                final String USERNAME = Mysql.username();
                final String PASSWORD = Mysql.password();
                final String CONN_STRING = Mysql.urlmysql();

                try {

                    conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                    String query = "UPDATE login SET username =" + '"' + updateUsername + '"' + ", password = " + '"' + updatePassword + '"' + ", toegang = " + '"' + updateToegang + '"' + "WHERE username =" + '"' + updateCurrentUsername + '"';
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);

                } catch (SQLException ed) {

                    System.err.println(ed);

                }
        
        
        
        
        
    }
    
    
    
    
    
    
}
