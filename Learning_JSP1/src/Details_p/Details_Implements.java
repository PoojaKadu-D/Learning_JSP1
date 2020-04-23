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
		System.out.println("adddddd");
		Connection conn = getConnection();
		if(conn !=null) {
			
		try {
			String query = "insert into userData1(name , password, email, mobileNO) values(?,?,?,?)";
			PreparedStatement prmt = conn.prepareStatement(query);
			prmt.setString(1, fedata.getUname());
			prmt.setString(2, fedata.getPassword());
			prmt.setString(3, fedata.getEmail());
			prmt.setLong(4, fedata.getMobileno());
			int execute = prmt.executeUpdate();
			if(execute >0){
				return "Data inserted Successfully!";
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
		
		System.out.println(username);
		System.out.println(password);
		FetchData fetchData = null;
		
		
		if(conn!=null) {
			
		try {
			String sql = "select * from userData1 where name=? and password=?";
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

	/*
	 * private void log(String string) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public ArrayList<FetchData> getAllDetails() {
		System.out.println("getAllCOnnection");
		ArrayList<FetchData> addDataList = new ArrayList<FetchData>();
		Connection conn = getConnection();
		
			try {
				System.out.println("Haa mai hu try ke ander");
				PreparedStatement prmt = conn.prepareStatement("select * from userData1");
//				String checkQuery = "select * from userData1";
				//Statement st = conn.createStatement();
				ResultSet result = prmt.executeQuery();
				if (result!=null) {
					
					System.out.println("resultSet is not null");
					System.out.println("ghghg");
				}
				//System.out.println(result.getInt("id"));
				
				while(result.next()) {
					
					FetchData fetchdata = new FetchData();
					fetchdata.setId(result.getInt("id"));
					fetchdata.setUname(result.getString("name"));
					fetchdata.setPassword(result.getString("password"));
					fetchdata.setEmail(result.getString("email"));
					fetchdata.setMobileno(result.getLong("mobileNO"));
				
					addDataList.add(fetchdata);
//					System.out.println(addDataList);
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
			finally {
				try {
					conn.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			  System.out.println("--> " + addDataList);
		return addDataList;
	}

	@Override
	public  FetchData getElementbyId(Integer id) {
		FetchData fetchData1= null;
		Connection conn = getConnection();
		try {
			PreparedStatement prmt = conn.prepareStatement("select * from userData1 where id =?");
			prmt.setInt(1, id);
			ResultSet result = prmt.executeQuery();
			while(result.next()) {
				fetchData1 = new FetchData();
				fetchData1.setId(result.getInt("id"));
				fetchData1.setUname(result.getString("name"));
				fetchData1.setPassword(result.getString("password"));
				fetchData1.setEmail(result.getString("email"));
				fetchData1.setMobileno(result.getLong("mobileNO"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fetchData1;
	}

	@Override
	public boolean updateDetailById(FetchData fetchData) {
		Connection conn = getConnection();
		String update="select usedData1 set name=? , password=?, email=?, mobileNO=? where id=?";
		try {
			PreparedStatement prmt = conn.prepareStatement(update);
			prmt.setString(1, fetchData.getUname());
			prmt.setString(2, fetchData.getPassword());
			prmt.setString(3, fetchData.getEmail());
			prmt.setLong(4, fetchData.getMobileno());
			prmt.setInt(5, fetchData.getId());
			
			int exe_Update = prmt.executeUpdate();
			if(exe_Update>0) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try{
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
		
	}

	@Override
	public boolean deleteDetailById(Integer id) {

		return false;
		
	}

	
	
}
