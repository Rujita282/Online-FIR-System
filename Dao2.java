package online;
import java.sql.*;

public class Dao2 {
  
             public boolean checkLogin(String user,String pass) throws SQLException
    {
         String sql;
        Connection con=null;
        sql="select * from admin_table where admin_id=? and pass=?";
        PreparedStatement ps=null;
        con=MyConnection.getConnection();
        ps=con.prepareStatement(sql);
        String admin_id = null;
        ps.setString(1, user);
        ps.setString(2, pass);
        System.out.println(ps);
        ResultSet rs=null;
        rs=ps.executeQuery();
        if(rs.next())
          return true;
        
     return false;
    }            }
