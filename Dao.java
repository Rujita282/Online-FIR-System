package online;
import java.sql.*;

public class Dao {
            public static int register(User u) {
                int status=0;
                try{
                    String sql;
                    sql="insert into user value(?,?,?,?,?,?,?)";
                    PreparedStatement ps=null;
                    Connection con=MyConnection.getConnection();
                    ps=con.prepareStatement(sql);
                    ps.setString(1,u.getName());
                     ps.setString(2, u.getEmail());
                      ps.setInt(3, u.getAge());
                       ps.setString(4, u.getPsw());
                         ps.setString(5, u.getNumber());
                          ps.setString(6, u.getAadhar());
                           ps.setString(7, u.getAddress());
                           status=ps.executeUpdate();
                }
                catch(Exception e){
                    System.out.println(e);
                }
                return status;

            }
             public boolean checkLogin(String user,String pass) throws SQLException
    {
         String sql;
        Connection con=null;
        sql="select * from user where email=? and psw=?";
        PreparedStatement ps=null;
        con=MyConnection.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs=null;
        rs=ps.executeQuery();
        if(rs.next())
          return true;
        
     return false;
    }            }
