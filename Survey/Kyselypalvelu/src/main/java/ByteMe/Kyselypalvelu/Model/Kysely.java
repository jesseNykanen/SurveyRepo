package ByteMe.Kyselypalvelu.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Kysely {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kyselyId;
	private String kyselyNimi;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kysely")
	@JsonManagedReference
	private List<Kysymys> kysymykset;

	public Kysely() {
	}

	public Kysely(String kyselyNimi, List<Kysymys> kysymykset) {
		super();
		this.kyselyNimi = kyselyNimi;
		this.kysymykset = kysymykset;
	}

	public long getKyselyId() {
		return kyselyId;
	}

	public void setKyselyId(long kyselyId) {
		this.kyselyId = kyselyId;
	}

	public String getKyselyNimi() {
		return kyselyNimi;
	}

	public void setKyselyNimi(String kyselyNimi) {
		this.kyselyNimi = kyselyNimi;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString() {
		return "Kysely [kyselyId=" + kyselyId + ", kyselyNimi=" + kyselyNimi + ", kysymykset=" + kysymykset + "]";
	}

}
