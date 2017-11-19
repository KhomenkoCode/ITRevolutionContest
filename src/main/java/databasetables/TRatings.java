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
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
@Entity
@Table(name = "trating")
public class TRatings implements Serializable {
	@Id
	@Column(name = "rating_id", columnDefinition = "serial")
	@Generated(GenerationTime.INSERT)
	private int rating_id;
	private int rating;
	private String artist_id;
	private String user_id;
	
	public TRatings(){};
	
	public int getRating_id() {
		return rating_id;
	}

	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}

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
	
}
