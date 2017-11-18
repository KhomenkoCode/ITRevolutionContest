package main.java;

import main.java.databasetables.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.User;

import main.java.databasetables.*;
import main.java.HibernateUtil;

public abstract class RatingDAO {
	
	static List<TRatings> getRatings(String currUserID, String artistID){
		
		Session session = null;
		List<TRatings> rating = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session
					.createQuery(" from main.java.databasetables.TRatings r" + " where r.user_id = :uid and r.artist_id = :aid")
					.setParameter("uid", currUserID).setParameter("aid", artistID);
			rating = query.list();
			session.getTransaction().commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
		return rating;
	}
	
	static void setRating(User currUser, Artist currArtist, int rating){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         
        TUsers usr = new TUsers();
        usr.setUser_id(currUser.getId());
        usr.setUsername(currUser.getDisplayName());
        session.save(usr);
        
        TArtists artist = new TArtists();
        artist.setSpotify_artist_id(currArtist.getId());
        artist.setArtist_name(currArtist.getName());
        session.save(artist);
        
        TRatings rate = new TRatings();
        rate.setArtist_id(currArtist.getId());
        rate.setUser_id(currUser.getId());
        rate.setRating(rating);
        session.save(rate);
        
        
 
        //Commit the transaction
        session.getTransaction().commit();
	}
}
