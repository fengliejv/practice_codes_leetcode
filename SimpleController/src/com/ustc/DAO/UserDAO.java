package com.ustc.DAO;

import java.sql.*;
import com.ustc.javabean.UserBean;
/**
 * һ����̣�

����(1) ����Class.forName()����������������

����(2) ����DriverManager�����getConnection()���������һ��Connection����

����(3) ����һ��Statement����׼��һ��SQL��䣬���SQL��������Statement��������ִ�еĵ���䣩��PreparedStatement��䣨Ԥ�������䣩��CallableStatement���󣨴洢���̵��õ���䣩��

����(4) ����excuteQuery()�ȷ���ִ��SQL��䣬�������������ResultSet���󣻻��ߵ���executeUpdate()�ȷ���ִ��SQL��䣬������ResultSet����Ľ����

����(5)�Է��ص�ResultSet���������ʾ���൱�Ĵ���

����(6)�ͷ���Դ�� 
 * */

public class UserDAO {
	//String driver="com.mysql.jdbc.Driver";//�������ݿ�����
	String driver="org.sqlite.JDBC";//�������ݿ�����
	//String url="jdbc:mysql://localhost:3306/feng";//����mysql���ݿ��ڱ��ص�·��
	String url="jdbc:sqlite://E:/sqlite/sqlite-dll-win32-x86-3150200/user.db";
	String user="root";//��½���û���
	String password="1111";//����
	Connection conn=null;//
	Statement stmt=null;//
	ResultSet rs = null;//��ѯ������󼯺�
	
	
	
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
			   System.out.println("û���ҵ���Ӧ�����ݿ�����");
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
			   System.out.println("û���ҵ���Ӧ�����ݿ�����");
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
              System.out.println("���ݿ����ӹ��Ѿ���");
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
			System.out.println("δ��ѯ���������");
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
			System.out.println("���ݿ�������");
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
			System.out.println("���ݿ�������ݳ���");
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
			System.out.println("����ɾ��ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
