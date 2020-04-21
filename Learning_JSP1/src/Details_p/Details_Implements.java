package Details_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Details_Implements implements Details_DAO {
	public static final String url  = "jdbc:mysql://localhost:3306/java_jdbc";
	public static String username = "root";
	public static String password = "root";
	public static String driver ="com.mysql.cj.jdbc.Driver";
	public static ArrayList<FetchData> addData;
	

	public Connection getConnection(){
		 Connection conn = null;
	
		 try {
			 Class.forName(driver);
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 System.out.println("Unable to find Class");
		 }
		 try {
			 conn = DriverManager.getConnection(url,username, password);
		 }catch(SQLException e) {
			 System.out.println("Unable to Connect with DB");
		 }
		 return conn;
	}
	
	@Override
	public String addUserDeatails(FetchData fedata) {
		Connection conn = getConnection();
		if(conn !=null) {
			String query = "insert into userData1(name , password, email, mobileNO) values(?,?,?,?)";
		try {
			PreparedStatement prmt = conn.prepareStatement(query);
			prmt.setString(1, fedata.getUname());
			prmt.setString(2, fedata.getPassword());
			prmt.setString(3, fedata.getEmail());
			prmt.setLong(4, fedata.getMobileno());
			int execute = prmt.executeUpdate();
			if(execute >0){
				return "Successful";
			}
		}catch(SQLException e) {
			System.out.println("Error");
			
		}
		finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		}
		
		return null;
	}

	@Override
	public FetchData checkLoginCredential(String username, String password) {
		Connection conn = getConnection();
		FetchData fetchData = null;
		if(conn!=null) {
			String sql = "select * from userData1 where name=? and password=?";
		try {
			
			PreparedStatement prmt= conn.prepareStatement(sql);
			prmt.setString(1,username );
			prmt.setString(2, password);
			ResultSet result = prmt.executeQuery();
			while(result.next()) {
				fetchData = new FetchData();
				fetchData.setId(result.getInt("id"));
				fetchData.setUname(result.getString("name"));
				fetchData.setPassword(result.getString("password"));
				fetchData.setEmail(result.getString("email"));
				fetchData.setMobileno(result.getLong("mobileNO"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
		
		return fetchData;
	}

	@Override
	public ArrayList<FetchData> getAllDetails() {
		
		Connection conn = getConnection();
		if(conn !=null) {
			String checkQuery = "select * from userData1";
			try {
				PreparedStatement prmt = conn.prepareStatement(checkQuery);
				ResultSet result = prmt.executeQuery();
				while(result.next()) {
					FetchData fetchdata = new FetchData();
					fetchdata.setId(result.getInt("id"));
					fetchdata.setUname(result.getString("name"));
					fetchdata.setPassword(result.getString("password"));
					fetchdata.setEmail(result.getString("email"));
					fetchdata.setMobileno(result.getLong("mobileNO"));
					
					addData.add(fetchdata);
					
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return addData;
	}

	
	
}
