package com.team.ordersales.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigureImpl{
   
   private static Connection conn = null;
   public final static String DB_URL = "jdbc:oracle:thin:@192.168.0.123:1521:xe";
//   public final static String DB_URL = "jdbc:oracle:thin:@192.168.35.29:1521:xe";
//   public final static String DB_URL = "jdbc:oracle:thin:@172.30.1.36:1521:xe";
//   public final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
   public final static String DB_USER = "team1";
   public final static String DB_PASS = "team1";
   
   private ConfigureImpl() {
   }
   
   public static Connection getConnObject() {
      if(conn == null) {
         try {
            Class.forName("oracle.jdbc.OracleDriver");
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } 
      
      return conn;
   }
   
   public static void closeConn() {
      try {
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}