package main.java.databasetables;

import java.util.HashSet;
import java.util.Set;

public class TUsers {
	private String username;
	private String user_id;
	private Set<TRatings> ratings;

	
	public Set<TRatings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<TRatings> ratings) {
		this.ratings = ratings;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public TUsers(){}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
