package ByteMe.Kyselypalvelu;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ByteMe.Kyselypalvelu.Model.Kysely;
import ByteMe.Kyselypalvelu.Model.KyselyRepository;
import ByteMe.Kyselypalvelu.Model.Kysymys;
import ByteMe.Kyselypalvelu.Model.KysymysRepository;

@SpringBootApplication
public class KyselypalveluApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		log.info("SOVELLUS KÄYNNISTYY :)");
		SpringApplication.run(KyselypalveluApplication.class, args);
	}

	@Bean
	public CommandLineRunner kyselyDemo(KyselyRepository kyselyRepository, KysymysRepository kysymysrepository) {
		return (args) -> {
			log.info("Hieman testaus dataa");
			
			List<Kysymys> kysymykset = new ArrayList<Kysymys>();
			
			kysymykset.add(new Kysymys("Mihin eri tarkoituksiin olet käyttänyt peppiä? (esim. HOPS, opiskeluohjeet…", "Tekstikysymys"));
			kysymykset.add(new Kysymys("Oletko onnistunut tekemään haluamasi muutokset käyttäessäsi peppiä?", "Tekstikysymys"));
			kysymykset.add(new Kysymys("Tuntuiko, että käytit siihen enemmän aikaa kuin olisit halunnut/odottanut?", "Tekstikysymys"));
			kysymykset.add(new Kysymys("Tuntuiko, että pepin käyttö helpottui ensimmäisen käyttökerran jälkeen?", "Tekstikysymys"));
			kysymykset.add(new Kysymys("Onko järjestelmässä mielestäsi joitakin puutteita? Mitä?", "Tekstikysymys"));			

			Kysely kysely1 = new Kysely("MyNet Peppi Kysely", kysymykset);
			
			kyselyRepository.save(kysely1);
			
			// ASETTAA KYSYMYKSILLE OIKEAN KYSELY IDN
			
			for (int i = 0; i < kysymykset.size(); i++) {
				kysymykset.get(i).setKysely(kysely1);
			}
			
			kysymysrepository.saveAll(kysymykset);
			System.out.println("Tässä kyselyt: " + kyselyRepository.findAll());

		};
	}
}