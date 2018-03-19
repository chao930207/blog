package article;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class GetConnection {  
    public Connection getConnection()  
    {  
        Connection conn=null;  
        try  
        {  
            try {  
                Class.forName("com.mysql.jdbc.Driver");  
            }  
            catch (ClassNotFoundException ex)  
            {  
                System.out.println("加载驱动程序有错误");  
            }  
  
            String url = "jdbc:mysql://39.106.126.222:3306/article?user=lchao&password=123456";  
            
            conn = (Connection) DriverManager.getConnection(url);  
            System.out.println("成功连接数据库！！");  
  
        }  
        catch (SQLException ex1)  
        {  
            System.out.print("取得连接的时候有错误，请核对用户名和密码");  
        }  
        return conn;  
    } 
    
    public static void main(String[]args)  
	  {  
	      GetConnection getConn=new GetConnection();  
	      getConn.getConnection();  
	  } 
}