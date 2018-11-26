package ByteMe.Kyselypalvelu.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vaihtoehto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vaihtoehtoId;
	private String valintaTeksti;
	
	@ManyToOne
	@JoinColumn(name = "kysymysId")
	private Kysymys kysymys;
	
	public Vaihtoehto() {
	}

	public Vaihtoehto( String valintaTeksti, Kysymys kysymys) {
		super();
		this.valintaTeksti = valintaTeksti;
		this.kysymys = kysymys;
	}

	public Long getVaihtoehtoId() {
		return vaihtoehtoId;
	}

	public void setVaihtoehtoId(Long vaihtoehtoId) {
		this.vaihtoehtoId = vaihtoehtoId;
	}

	public String getValintaTeksti() {
		return valintaTeksti;
	}

	public void setValintaTeksti(String valintaTeksti) {
		this.valintaTeksti = valintaTeksti;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Vaihtoehto [vaihtoehtoId=" + vaihtoehtoId + ", valintaTeksti=" + valintaTeksti + "]";
	}
	
}
