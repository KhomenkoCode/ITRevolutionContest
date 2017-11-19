package main.java;

import main.java.databasetables.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.User;

import main.java.databasetables.*;
import main.java.HibernateUtil;

public abstract class RatingDAO {
	
	static float calculateAverageRate(String artistID){

		float result = 0f;
		List<TRatings> rates = getRatings(artistID);
		
		if(rates.size() == 0)
			return 0;
		
		for(int i=0; i<rates.size();i++){
			result += rates.get(i).getRating();
		}
		
		return (result/rates.size());
	}
	
	static Map<String, String> getMapOfRatedArtistsIdAndAverageRates(){
		Session session = null;
		List<TRatings> rating = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(" from main.java.databasetables.TRatings r");
			rating = query.list();
			session.getTransaction().commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
		if(rating.size() == 0)
			return null;
		
		Map<String, String> listOfRatedArtistsId = new HashMap<String, String>();
		for(int i=0; i<rating.size(); i++)
		{
			String currentArtistId = rating.get(i).getArtist_id();
			listOfRatedArtistsId.put(currentArtistId, Float.toString(calculateAverageRate(currentArtistId)));
		}
		
		return listOfRatedArtistsId;
	}
	
	static List<TRatings> getRatings(String artistID) {

		Session session = null;
		List<TRatings> rating = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(" from main.java.databasetables.TRatings r" + " where r.artist_id = :aid")
					.setParameter("aid", artistID);
			rating = query.list();
			session.getTransaction().commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return rating;
	}

	static List<TRatings> getRating(String currUserID, String artistID) {

		Session session = null;
		List<TRatings> rating = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session
					.createQuery(" from main.java.databasetables.TRatings r"
							+ " where r.artist_id = :aid and r.user_id = :uid")
					.setParameter("aid", artistID).setParameter("uid", currUserID);
			rating = query.list();
			session.getTransaction().commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return rating;
	}

	static void setRating(User currUser, Artist currArtist, int rating) {
		List<TRatings> a = getRating(currUser.getId(), currArtist.getId());
		if (a.size() != 0) {
		    System.out.println(a.size());
			deleteRateInfo(currUser, currArtist, rating, a.get(0).getRating_id());
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		TRatings rate = new TRatings();
		rate.setArtist_id(currArtist.getId());
		rate.setUser_id(currUser.getId());
		rate.setRating(rating);
		session.save(rate);

		// Commit the transaction
		session.getTransaction().commit();
	}

	static void deleteRateInfo(User currUser, Artist currArtist, int rating, int id){
		 Session session = HibernateUtil.getSessionFactory().openSession(); 
		 session.beginTransaction();
		 TRatings oldRait = session.get(TRatings.class, id);
		 session.delete(oldRait);
		 session.flush();
		 session.getTransaction().commit();
	}
	
	
	
}
