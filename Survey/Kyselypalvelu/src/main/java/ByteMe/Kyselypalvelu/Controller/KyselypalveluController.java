package ByteMe.Kyselypalvelu.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ByteMe.Kyselypalvelu.Model.Kysely;
import ByteMe.Kyselypalvelu.Model.KyselyRepository;
import ByteMe.Kyselypalvelu.Model.Kysymys;
import ByteMe.Kyselypalvelu.Model.KysymysRepository;

@Controller
public class KyselypalveluController {

	@Autowired
	private KyselyRepository kyselyrepository;
	@Autowired
	private KysymysRepository kysymysrepository;
	
	//uudelleenohjaa 
//	@RequestMapping("/")
//	public String index() {
//		return "redirect:/kysymykset";
//	}
	
	// PALAUTTAA KAIKKI KYSYMYKSET
	@RequestMapping("/kysymykset")
	public @ResponseBody List<Kysymys> findKyselyRest() {
		return (List<Kysymys>) kysymysrepository.findAll();
	}

	// PALAUTTAA
	@RequestMapping("/kysymys/{id}")
	public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("id") Long kysymysId) {
		return kysymysrepository.findById(kysymysId);
	}

	// PALAUTTAA KAIKKI KYSELYT
	@RequestMapping("/kyselyt")
	public @ResponseBody List<Kysely> findKyselytRest() {
		return (List<Kysely>) kyselyrepository.findAll();
	}

	// PALAUTTAA YHDEN KYSELYN ID:LLÄ
	@RequestMapping("/kyselyt/{id}")
	public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long kyselyId) {
		return kyselyrepository.findById(kyselyId);
	}
	
	// LISÄÄ KYSYMYKSEN
	@PostMapping("/uusiKysymys")
	public String helloYou(@RequestParam(name="firstname") String etunimi, 
			@RequestParam(name="lastname") String sukunimi) {
		return "Hello " + etunimi + " " +sukunimi;
	} 
	}
