package main.java.databasetables;

public class TRatings {
	private int rating;
	private String artist_id;
	private String user_id;
	private String rating_id;
	
	
	private TUsers user;
	public TUsers getUser() {
		return user;
	}

	public void setUser(TUsers user) {
		this.user = user;
	}
	private TArtists artist;
	
	public TArtists getArtist() {
		return artist;
	}

	public void setArtist(TArtists artist) {
		this.artist = artist;
	}

	public TRatings(){}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRating_id() {
		return rating_id;
	}
	public void setRating_id(String rating_id) {
		this.rating_id = rating_id;
	}
}
