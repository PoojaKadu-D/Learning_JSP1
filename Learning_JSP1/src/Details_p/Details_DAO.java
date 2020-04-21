package Details_p;

import java.util.ArrayList;

public interface Details_DAO {

	public String addUserDeatails(FetchData fedata);
	
	public FetchData checkLoginCredential(String username, String password);
	
	public ArrayList<FetchData> getAllDetails();
}
