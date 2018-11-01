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

			List<String> kysymyslista = new ArrayList<>();

			kysymyslista.add("Testi kysymys asd");
			kysymyslista.add("Testi kysymys 123");
			kysymyslista.add("Testi kysymys ABC");
			
			Kysely kysely1 = new Kysely("Peppi tyytyväisyyskysely" , null);

			kyselyRepository.save(kysely1);

		//	log.info("HAETAAN KAIKKI KYSELYT:");
		//	for (Kysely kysely : kyselyRepository.findAll()) {
		//		log.info(kysely.toString());
		//		System.out.println("Bean Test" + kyselyRepository.findAll());
		//	}

		};

	}
}
