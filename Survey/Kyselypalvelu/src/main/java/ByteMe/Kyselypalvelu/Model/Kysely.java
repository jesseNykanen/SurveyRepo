package ByteMe.Kyselypalvelu.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Kysely {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kyselyId;
	private String kyselyNimi;

	
	@Column
    @ElementCollection
	@JsonManagedReference
	private List<String> kysymykset;

	public Kysely() {
	}

	public Kysely(String kyselyNimi, List<String> kysymykset) {
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

	public List<String> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<String> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString() {
		return "Kysely [kyselyId=" + kyselyId + ", kyselyNimi=" + kyselyNimi + ", kysymykset=" + kysymykset + "]";
	}

}
