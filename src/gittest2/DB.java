/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import java.sql.*;


/**
 *
 * @author mcbookpro
 */
public class DB {
    
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com\\myisak:1433;databaseName=Github2";
   static final String USER = "root";
   static final String PASS = "199404046253";
   Connection conn = null;
   Statement stmt = null;
   
   
   public void koppla() throws ClassNotFoundException, SQLException {

       
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(jdbcUrl,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
    stmt = conn.createStatement();
      String sql;
      sql = "SELECT * From Kund";
      
     ResultSet rs = stmt.executeQuery(sql);
     
           while(rs.next()){
         //Retrieve by column name
  
         String first = rs.getString("fNamn");
         String last = rs.getString("eNamn");
        
          
         //Display values
        
         System.out.println(first + " " +last);
         
      }
      
      stmt.close();
      conn.close();
   }catch(SQLException se){
   }catch(Exception e){
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
       
       
   }
   
   public void stang() throws ClassNotFoundException, SQLException{
             try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }
       
   }
   
      
   
}//end main
    

