package com.ustc.DAO;

import java.sql.*;
import com.ustc.javabean.UserBean;
/**
 * 一般过程：

　　(1) 调用Class.forName()方法加载驱动程序。

　　(2) 调用DriverManager对象的getConnection()方法，获得一个Connection对象。

　　(3) 创建一个Statement对象，准备一个SQL语句，这个SQL语句可以是Statement对象（立即执行的的语句）、PreparedStatement语句（预编译的语句）或CallableStatement对象（存储过程调用的语句）。

　　(4) 调用excuteQuery()等方法执行SQL语句，并将结果保存在ResultSet对象；或者调用executeUpdate()等方法执行SQL语句，不返回ResultSet对象的结果。

　　(5)对返回的ResultSet对象进行显示等相当的处理。

　　(6)释放资源。 
 * */

public class UserDAO {
	//String driver="com.mysql.jdbc.Driver";//设置数据库驱动
	String driver="org.sqlite.JDBC";//设置数据库驱动
	//String url="jdbc:mysql://localhost:3306/feng";//设置mysql数据库在本地的路径
	String url="jdbc:sqlite://E:/sqlite/sqlite-dll-win32-x86-3150200/user.db";
	String user="root";//登陆的用户名
	String password="1111";//密码
	Connection conn=null;//
	Statement stmt=null;//
	ResultSet rs = null;//查询结果对象集合
	
	
	
	public UserDAO() {
		super();
		openDBConnection();
	}
	
	
	public Connection openDBConnection2(){
		   try{
			   Class.forName(driver);
			   conn=DriverManager.getConnection(url);
			   stmt=conn.createStatement();
			   
		   }catch(ClassNotFoundException e){
			   System.out.println("没有找到对应的数据库驱动");
			   e.printStackTrace();
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		   return conn;
	   }

	public Connection openDBConnection(){
		   try{
			   Class.forName(driver);
			   conn=DriverManager.getConnection(url,user,password);
			   stmt=conn.createStatement();
			   
		   }catch(ClassNotFoundException e){
			   System.out.println("没有找到对应的数据库驱动");
			   e.printStackTrace();
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		   return conn;
	   }
	
	public boolean closeDBConnection() {  
		if(rs != null ){              
            try {
              rs.close();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              return false;
          }              
        }          
        if(stmt != null){              
          try {
              stmt.close();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              return false;
          }
        }
        if(conn != null){
          try {
              conn.close();
              System.out.println("数据库连接关已经闭");
          } catch (SQLException e) {
              e.printStackTrace();
              return false;
          }
        }       
        return true;
    }
	
	public UserBean queryUser(String userName){
		String sql="select password from users where username='"+userName+"'";
		String passWord =null;
		UserBean user = null;
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			passWord=rs.getString("password");
			user= new UserBean(userName,passWord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未查询到相关数据");
			e.printStackTrace();
		}
		
		return user;		
	}
	
	public boolean insertUser(UserBean u) {
		String sql="insert into users(username,password) values('"+u.getUsername()+"','"+u.getPassword()+"')";
	    try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库插入出错");
			e.printStackTrace();
			return false;
		}
		return true;		
	}
	
	public boolean updateUser(UserBean u){
		String sql="update users set password='"+u.getPassword()+"' where username='"+u.getUsername()+"'";
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库更新数据出错");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteUser(UserBean u){
		String sql = "delete from users where username='"+u.getUsername()+"'";  
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
