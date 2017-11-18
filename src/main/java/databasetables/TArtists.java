package main.java.databasetables;

import java.util.HashSet;
import java.util.Set;

public class TArtists {
	private String artist_name;
	private String spotify_artist_id;
	private Set<TRatings> ratings;

	
	public Set<TRatings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<TRatings> ratings) {
		this.ratings = ratings;
	}

	public TArtists(){}
	
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getSpotify_artist_id() {
		return spotify_artist_id;
	}
	public void setSpotify_artist_id(String spotify_artist_id) {
		this.spotify_artist_id = spotify_artist_id;
	}
	
	
}
