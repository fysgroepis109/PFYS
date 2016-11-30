/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyfs;

/**
 *
 * @author Jaros
 */
public class mysql {
      private final String USENAME = "fys5";
    private final String PASSWORD = "ZRnRZSIbEXbj1FPg";
    private final String IPADDRESS = "it95.nl";
    private final String POORT = "3306";
    private final String DATABASENAAM = "fys5";
    private final boolean AUTORECONNECT = true;
    private final boolean SSL = false;
    
    
    String username(){
        return USENAME;
    };
        
    String password(){
        return PASSWORD;
    };
    
    String urlmysql(){
        return "jdbc:mysql://"+IPADDRESS+":"+POORT+"/"+DATABASENAAM+"?autoReconnect="+AUTORECONNECT+"&useSSL="+SSL;
    };
    }
    
    
    
    

