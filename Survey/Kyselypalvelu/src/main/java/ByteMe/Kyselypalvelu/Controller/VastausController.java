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

@Controller
@CrossOrigin
public class VastausController {

	@Autowired
	private VastausRepository vastausrepository;

	// UUSI VASTAUS
	@PostMapping("/uusiVastaus")
	Vastaus uusiVastaus(@RequestBody Vastaus vastaus) {
		return vastausrepository.save(vastaus);
	}

	// NAYTTAA KAIKKI VASTAUKSET
	@RequestMapping("/vastaukset")
	public @ResponseBody List<Vastaus> findVastauksetRest() {
		return (List<Vastaus>) vastausrepository.findAll();
	}

}
