package main.java;

import com.wrapper.spotify.models.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexPageServlet() {
		super();

	}
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    System.out.println("Hibernate starting...");
	    HibernateUtil hbm = new HibernateUtil();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");

		if (code == null) {
			request.setAttribute("clientID", SpotifyAPI.clientId);
			request.setAttribute("redirectLink", SpotifyAPI.redirectUri);
		} else {
			String accessToken = SpotifyAPI.getUserAccessToken(code);
			
			if(accessToken == null)
			{	
				request.setAttribute("clientID", SpotifyAPI.clientId);
				request.setAttribute("redirectLink", SpotifyAPI.redirectUri);
				response.setContentType("text/html");
				RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("/indexPage.jsp");
				dispatcher.forward(request, response);
				return;
			}
			Cookie newCookie = new Cookie("code", code);
		    newCookie.setPath(request.getContextPath());
		    response.addCookie(newCookie);
			
		    newCookie = new Cookie("accessToken", accessToken);
            newCookie.setPath(request.getContextPath());
            response.addCookie(newCookie);
			User user = SpotifyAPI.getCurrentUser(accessToken);
			if (user!=null){
				newCookie = new Cookie("user_id", user.getId());
                newCookie.setPath(request.getContextPath());
                response.addCookie(newCookie);
			}

		    response.sendRedirect("main");
		    return;
		}
		response.setContentType("text/html");
		RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("/indexPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
