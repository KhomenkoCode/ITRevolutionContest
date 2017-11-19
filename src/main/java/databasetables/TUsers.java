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
@Table(name="tusers")
public class TUsers implements Serializable {
	
	private String username;
	
	@Id
	private String user_id;
	private Set<TRatings> ratings;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<TRatings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<TRatings> ratings) {
		this.ratings = ratings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public TUsers(){}
	
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
