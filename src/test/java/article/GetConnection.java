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
                System.out.println("�������������д���");  
            }  
  
            String url = "jdbc:mysql://39.106.126.222:3306/article?user=lchao&password=123456";  
            
            conn = (Connection) DriverManager.getConnection(url);  
            System.out.println("�ɹ��������ݿ⣡��");  
  
        }  
        catch (SQLException ex1)  
        {  
            System.out.print("ȡ�����ӵ�ʱ���д�����˶��û���������");  
        }  
        return conn;  
    } 
    
    public static void main(String[]args)  
	  {  
	      GetConnection getConn=new GetConnection();  
	      getConn.getConnection();  
	  } 
}