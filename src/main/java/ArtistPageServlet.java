package main.java;

import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/artist")
public class ArtistPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ArtistPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String accessToken = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("accessToken")) {
                    accessToken = cookie.getValue();
                }
            }
        }
        if(accessToken == null){
            response.sendRedirect("main");
            return;
        }
        String searchedArtist = request.getParameter("artist");



        if (searchedArtist!=null) {
            Artist artist = SpotifyAPI.getArtistInfo(searchedArtist, accessToken);
            request.setAttribute("artist", artist);
            List<Artist> rel_art = SpotifyAPI.getRelatedArtists(searchedArtist, accessToken);
            request.setAttribute("rel_art", rel_art);
            List<Track> topTracksOfCurrArtist = SpotifyAPI.getTopTracks(accessToken,searchedArtist);

            request.setAttribute("topTracksByArtists", topTracksOfCurrArtist);

        }
        else {
            response.sendRedirect("main");
            return;
        }
        response.setContentType("text/html");
        RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("/spotifyArtistOverview.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Cookie[] cookies = request.getCookies();
        String accessToken = null;
        String userId = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("accessToken")) {
                    accessToken = cookie.getValue();
                }
            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_id")) {
                    userId = cookie.getValue();
                }
            }
        }
        if (accessToken == null) {
            response.sendRedirect("main");
            return;
        }
        System.out.println(request.getParameter("artist_post"));
        List<Artist> artists = SpotifyAPI.getArtists(request.getParameter("artist_post"), accessToken);

        if (artists != null) {
            request.setAttribute("artists", artists);
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
