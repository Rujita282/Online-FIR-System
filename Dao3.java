package online;

import java.sql.*;
import java.io.*;
import javax.servlet.jsp.JspWriter;

public class Dao3 {
          public  int register(User3 u) {
                int status=0;
                try{
                    FileInputStream fis=null;
                   JspWriter wr = pageContext.getOut();
                    String sql;
                    sql="insert into complaint value(?,?,?,?,?,?,?,?)";
                    PreparedStatement ps=null;
                    Connection con=MyConnection.getConnection();
                    ps=con.prepareStatement(sql);
                    ps.setString(1,u.getName());
                     ps.setString(2, u.getEmail());
                      ps.setInt(3, u.getAge());
                       ps.setString(4, u.getCdate());
                         ps.setString(5, u.getMob());
                          ps.setString(6, u.getAddress());
                            ps.setString(7,u.getComp());
                    String img = null;
                            fis=new FileInputStream(img);
                        ps.setBinaryStream(8, (InputStream) fis, (int) (img.length())); 
                           status=ps.executeUpdate();
                       if(status!=0){
      wr.write("image inserted successfully");
    }
    else{
      wr.write("problem in image insertion");
    }  
  
                           
                }
                catch(Exception e){
                    System.out.println(e);
                }
                return status;

            }
}
