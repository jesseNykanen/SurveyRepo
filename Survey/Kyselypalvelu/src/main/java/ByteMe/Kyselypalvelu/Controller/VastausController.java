package ByteMe.Kyselypalvelu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ByteMe.Kyselypalvelu.Model.Vastaus;
import ByteMe.Kyselypalvelu.Model.VastausRepository;

@CrossOrigin
@Controller
public class VastausController {

	@Autowired
	private VastausRepository vastausrepository;

	// UUSI VASTAUS POST
	@PostMapping("/uusiVastaus")
	public @ResponseBody Vastaus uusiVastaus(@RequestBody Vastaus vastaus) {
		return vastausrepository.save(vastaus);
	}

	// UUSI VASTAUSLISTA POST
	@PostMapping("/uusiVastauslista")
	public @ResponseBody List<Vastaus> uusiVastauslista(@RequestBody List<Vastaus> vastaukset) {
		System.out.println("selaimelta tuli vastauslista" + vastaukset);
		return (List<Vastaus>) vastausrepository.saveAll(vastaukset);
	}

	// NAYTTAA KAIKKI VASTAUKSET
	@RequestMapping("/vastaukset")
	public @ResponseBody List<Vastaus> findVastauksetRest() {
		return (List<Vastaus>) vastausrepository.findAll();
	}

}
