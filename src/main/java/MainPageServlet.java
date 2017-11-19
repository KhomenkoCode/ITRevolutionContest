package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Track;

import main.java.databasetables.TRatings;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/main")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		String accessToken = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("accessToken")) {
					accessToken = cookie.getValue();
				}
			}
		}
		if (accessToken == null) {
			response.sendRedirect("index");
			return;
		}
		
		Map<String, String> RatedArtistsInfo = RatingDAO.getMapOfRatedArtistsIdAndAverageRates();
		if(RatedArtistsInfo != null)
		{
			Map<Artist, String> RatedArtistsFullInfo = new HashMap<Artist, String>();
			for (Map.Entry<String, String> entry : RatedArtistsInfo.entrySet())
			{
				Artist currArtist = SpotifyAPI.getArtistInfo(entry.getKey(), accessToken);
				RatedArtistsFullInfo.put(currArtist, entry.getValue());
			}
			
			request.setAttribute("ratedArtists", RatedArtistsFullInfo);
		}
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("/mainPage.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		String accessToken = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("accessToken")) {
					accessToken = cookie.getValue();
				}
			}
		}
		if (accessToken == null) {
			response.sendRedirect("main");
			return;
		}
		List<Artist> artists = SpotifyAPI.getArtists(request.getParameter("artist"), accessToken);
		
		if (artists != null) {
			request.setAttribute("artists", artists);
			
			RatingDAO.setRating(SpotifyAPI.getCurrentUser(accessToken), artists.get(1), 4);
			//List<TRatings> rateList = RatingDAO.getRatings(SpotifyAPI.getCurrentUser(accessToken).getId(), artists.get(0).getId());
			//List<TRatings> rateList = RatingDAO.getRating(SpotifyAPI.getCurrentUser(accessToken).getId(), artists.get(0).getId());
			System.out.println( RatingDAO.calculateAverageRate(artists.get(0).getId()));
			List<List<Track>> topTracksByArtists = new ArrayList<List<Track>>();
			Iterator<Artist> artistsIter = artists.iterator();
			while (artistsIter.hasNext()) {
				Artist currArtist = artistsIter.next();
				List<Track> topTracksOfCurrArtist = SpotifyAPI.getTopTracks(accessToken, currArtist.getId());
				topTracksByArtists.add(topTracksOfCurrArtist);
			}
			request.setAttribute("topTracksByArtists", topTracksByArtists);
		}
		
		
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = (RequestDispatcher) request
				.getRequestDispatcher("/spotifyArtistsSearchPage.jsp");
		dispatcher.forward(request, response);

	}

}
