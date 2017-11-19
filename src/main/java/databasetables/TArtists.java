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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tartists")
public class TArtists implements Serializable {
	private String artist_name;
	@Id
	private String spotify_artist_id;
	private Set<TRatings> ratings;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "artist")
	public Set<TRatings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<TRatings> ratings) {
		this.ratings = ratings;
	}

	public TArtists(){}
	
	@Column(name = "artist_name", nullable = false)
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "spotify_artist_id", unique = true, nullable = false)
	public String getSpotify_artist_id() {
		return spotify_artist_id;
	}
	public void setSpotify_artist_id(String spotify_artist_id) {
		this.spotify_artist_id = spotify_artist_id;
	}
	
	
}
