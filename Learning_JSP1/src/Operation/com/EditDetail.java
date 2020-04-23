package Operation.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Details_p.Details_DAO;
import Details_p.Details_Implements;
import Details_p.FetchData;

/**
 * Servlet implementation class EditDetail
 */
@WebServlet("/EditDetail")
public class EditDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FetchData fetchData = null;
		
		String userid = request.getParameter("id");//change in name
		int id1 = Integer.parseInt(userid);
		System.out.println(id1);
		response.getWriter().print("You have selected"+id1);
		
		Details_DAO editDao = new Details_Implements();
		
		 FetchData fetchData = editDao.getElementbyId(id1);
		 System.out.println("hiiii");
		 if(fetchData!=null) {
			 request.setAttribute("data", fetchData);
			 RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
			 rd.forward(request, response);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
