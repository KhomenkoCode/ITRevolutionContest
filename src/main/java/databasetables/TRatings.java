package main.java.databasetables;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tratings")
public class TRatings implements Serializable {
	private int rating;
	private String rating_id;
	
	
	private TUsers user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public TUsers getUser() {
		return user;
	}

	public void setUser(TUsers user) {
		this.user = user;
	}
	
	private TArtists artist;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_id", nullable = false)
	public TArtists getArtist() {
		return artist;
	}
	
	public void setArtist(TArtists artist) {
		this.artist = artist;
	}

	public TRatings(){}
	
	@Column(name = "rating")
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rating_id", unique = true, nullable = false)
	public String getRating_id() {
		return rating_id;
	}
	public void setRating_id(String rating_id) {
		this.rating_id = rating_id;
	}
}
