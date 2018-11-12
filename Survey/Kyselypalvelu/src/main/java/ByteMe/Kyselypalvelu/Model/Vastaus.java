package ByteMe.Kyselypalvelu.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String vastaus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "kyselyId")
	private Kysely kysely;

	public Vastaus() {
	}

	public Vastaus(String vastaus, Kysely kysely) {
		super();
		this.vastaus = vastaus;
		this.kysely = kysely;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	@Override
	public String toString() {
		
		return "Vastaus [id=" + id + ", vastaus=" + vastaus + "]";
	}
}