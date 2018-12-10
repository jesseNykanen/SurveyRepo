package ByteMe.Kyselypalvelu.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Kysymys {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long kysymysId;
	private String kysymys;

	@ManyToOne
	@JoinColumn(name = "kyselyId")
	private Kysely kysely;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	@JsonBackReference
	private List<Vaihtoehto> vaihtoehdot;

//	@JsonBackReference
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
//	private List<Vastaus> vastaukset;

	private String kysymysTyyppi;

	public Kysymys() {
	}

	public Kysymys(String kysymys, String kysymysTyyppi) {
		super();
		this.kysymys = kysymys;
		this.kysymysTyyppi = kysymysTyyppi;

	}
	public Kysymys(String kysymys, String kysymysTyyppi, List<Vaihtoehto> vaihtoehdot, List<Vastaus> vastaukset) {
		super();
		this.kysymys = kysymys;
		this.kysymysTyyppi = kysymysTyyppi;
	//	this.vastaukset = vastaukset;
	}

	public long getKysymysId() {
		return kysymysId;
	}

	public void seKysymysId(long kysymysId) {
		this.kysymysId = kysymysId;
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

	public String getKysymysTyyppi() {
		return kysymysTyyppi;
	}

	public void setKysymysTyyppi(String kysymysTyyppi) {
		this.kysymysTyyppi = kysymysTyyppi;
	}

	public List<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}

//	public List<Vastaus> getVastaukset() {
//		return vastaukset;
//	}

//	public void setVastaukset(List<Vastaus> vastaukset) {
//	this.vastaukset = vastaukset;
//	}

	public void setKysymysId(long kysymysId) {
		this.kysymysId = kysymysId;
	}

	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [kysymysId=" + kysymysId + ", kysymys= " + kysymys + ",  kysely=" + kysely
					+ ", kysymysTyyppi= " + kysymysTyyppi + "]";

		else
			return "Kysymys [kysymysId=" + kysymysId + ", kysymys = " + kysymys + ", kysymysTyyppi= " + kysymysTyyppi
					+ "]";
	}
}