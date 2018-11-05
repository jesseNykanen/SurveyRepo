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
import ByteMe.Kyselypalvelu.Model.KysymysRepository;

@SpringBootApplication
public class KyselypalveluApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		log.info("SOVELLUS KAYNNISTYY");
		SpringApplication.run(KyselypalveluApplication.class, args);
	}

	@Bean
	public CommandLineRunner kyselyDemo(KyselyRepository kyselyRepository, KysymysRepository kysymysrepository) {
		return (args) -> {
			log.info("Hieman testaus dataa");
			
			List<String> kysymykset = new ArrayList<>();
			List<String> kysymykset2 = new ArrayList<>();
			
			kysymykset.add("Testi kysymys asd");
			kysymykset.add("Testi kysymys 123");
			kysymykset.add("Testi kysymys ABC");
			
			kysymykset2.add("Mihin eri tarkoituksiin olet käyttänyt peppiä? (esim. HOPS, opiskeluohjeet…)");
			kysymykset2.add("Oletko onnistunut tekemään haluamasi käyttäessäsi peppiä?");
			kysymykset2.add("Tuntuiko, että käytit siihen enemmän aikaa kuin olisit halunnut/odottanut?");
			kysymykset2.add("Tuntuiko, että pepin käyttö helpottui ensimmäisen käyttökerran jälkeen?");
			kysymykset2.add("Onko järjestelmässä mielestäsi joitakin puutteita? Mitä?");
			
			
			Kysely kysely = new Kysely("Tämä on hieno kysely", kysymykset);
			Kysely kysely2 = new Kysely("Oletko tyytyväinen - Kysely", kysymykset2);
			

			kyselyRepository.save(kysely);
			kyselyRepository.save(kysely2);

		//	log.info("HAETAAN KAIKKI KYSELYT:");
		//	for (Kysely kysely : kyselyRepository.findAll()) {
		//		log.info(kysely.toString());
		//		System.out.println("Bean Test" + kyselyRepository.findAll());
		//	}

		};
	}
}

