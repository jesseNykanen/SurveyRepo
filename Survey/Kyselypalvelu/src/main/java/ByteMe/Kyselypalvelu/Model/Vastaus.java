package ByteMe.Kyselypalvelu.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Vastaus {
	
/* 	ESIMERKKI JSON

  	{
	    "vastausId": null,
	    "vastaus": "Olen käyttänyt Peppiä kursseille ilmoittautumiseen",
	    "kysymys": {
	        "kysymysId": 1
	    }
	} 
*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vastausId;
	private String vastaus;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "kysymysId")
	private Kysymys kysymys;

	public Vastaus() {
	}

	public Vastaus(String vastaus, Kysymys kysymys) {
		super();
		this.vastaus = vastaus;
		this.kysymys = kysymys;
	}

	public long getVastausId() {
		return vastausId;
	}

	public void setVastausId(long vastausId) {
		this.vastausId = vastausId;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		
		return "Vastaus [vastausId=" + vastausId + ", vastaus=" + vastaus + "]";
	}
}