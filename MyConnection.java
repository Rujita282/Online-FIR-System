package online;
import java.sql.*;
public class MyConnection {
   

    
        
    
        
    static  Connection con = null;
    static
    {
        try 
        {
             Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Driver load...........");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
    
    public static Connection getConnection()
    {
        try {
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FIR", "root", "root");
             System.out.println("Data base Conneted.........");
          } 
        catch (SQLException e) 
        {
            System.out.println(e);
        } 
        return con;
    }
    public static void main(String[] args) {
        new MyConnection().getConnection();
}

}

