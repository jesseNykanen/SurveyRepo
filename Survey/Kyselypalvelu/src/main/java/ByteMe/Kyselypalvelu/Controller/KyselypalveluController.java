package ByteMe.Kyselypalvelu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ByteMe.Kyselypalvelu.Model.Kysely;
import ByteMe.Kyselypalvelu.Model.KyselyRepository;
import ByteMe.Kyselypalvelu.Model.Kysymys;
import ByteMe.Kyselypalvelu.Model.KysymysRepository;

@Controller
@CrossOrigin
public class KyselypalveluController {

	@Autowired
	private KyselyRepository kyselyrepository;
	@Autowired
	private KysymysRepository kysymysrepository;

	// OHJAA INDEX SIVULLE
	@RequestMapping("/")
	public String index() {
		return "sivupohja";
	}

	// PALAUTTAA KAIKKI KYSYMYKSET
	@RequestMapping("/kysymykset")
	public @ResponseBody List<Kysymys> findKyselyRest() {
		return (List<Kysymys>) kysymysrepository.findAll();
	}

	// PALAUTTAA YHDEN KYSELYN KYSMYKSET
	@RequestMapping("/kysely/{id}")
	public @ResponseBody List<Kysely> findKyselynKysymyksetRest(@PathVariable("id") Long kyselyId) {

		return (List<Kysely>) kyselyrepository.findByKyselyId(kyselyId);
	}

	// PALAUTTAA YHDEN KYSELYN KYSMYKSET
	@RequestMapping("/kysely/{id}/kysymykset")
	public @ResponseBody List<Kysymys> findKyselynKysymyksetRest2(@PathVariable("id") Long kyselyId) {

		Kysely kysely = new Kysely();
		kysely.setKyselyId(kyselyId);
		return (List<Kysymys>) kysymysrepository.findByKysely(kysely);
	}

	// PALAUTTAA KAIKKI KYSELYT
	@RequestMapping("/kyselyt")
	public @ResponseBody List<Kysely> findKyselytRest() {
		return (List<Kysely>) kyselyrepository.findAll();
	}

}
