package ByteMe.Kyselypalvelu.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ByteMe.Kyselypalvelu.Model.Kysely;
import ByteMe.Kyselypalvelu.Model.KyselyRepository;

@Controller
public class KyselypalveluController {

	@Autowired
	private KyselyRepository kyselyrepository;
	
	// PALAUTTAA KAIKKI KYSELYT
	@RequestMapping("/kyselyt")
	public @ResponseBody List<Kysely> findKyselyRest() {
		System.out.println("Controller print" + kyselyrepository.findAll());
		return (List<Kysely>) kyselyrepository.findAll();
	}
	
	// PALAUTTAA YHDEN KYSELYN ID:LLÄ
	@RequestMapping("/kyselyt/{id}")
	public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long kyselyId) {
		return kyselyrepository.findById(kyselyId);
	}
}
