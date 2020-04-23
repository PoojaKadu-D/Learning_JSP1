package Details_p;

import java.util.ArrayList;

public interface Details_DAO {

	public String addUserDeatails(FetchData fedata);
	
	public FetchData checkLoginCredential(String username, String password);
	
	public ArrayList<FetchData> getAllDetails();
	
	public FetchData getElementbyId(Integer id);
	
	public boolean updateDetailById(FetchData fetData);//id change, if needed update
	
	public boolean deleteDetailById(Integer id);//delete operation
	
}
