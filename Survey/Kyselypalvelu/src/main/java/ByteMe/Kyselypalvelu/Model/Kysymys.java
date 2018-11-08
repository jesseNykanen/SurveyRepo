package ByteMe.Kyselypalvelu.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kysymys {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String kysymys;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "kyselyId")
	private Kysely kysely;

	public Kysymys() {
	}

	public Kysymys(String kysymys) {
		super();
		this.kysymys = kysymys;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [id=" + id + ", kysymys= " + kysymys + ",  kysely=" + kysely + "]";

		else
			return "Kysymys [id=" + id + ", kysymys = " + kysymys +  "]";
	}

}