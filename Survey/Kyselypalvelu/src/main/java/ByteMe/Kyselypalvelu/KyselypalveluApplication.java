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
			List<Kysymys> kysymykset2 = new ArrayList<Kysymys>();
			
			// 90ba9fbdc3fea08b4e0216da50342aced342f0e9 VIIMEINEN TOIMIVA VERSIO :^)
			
			kysymykset.add(new Kysymys("Mihin eri tarkoituksiin olet käyttänyt peppiä? (esim. HOPS, opiskeluohjeet…"));
			kysymykset.add(new Kysymys("Oletko onnistunut tekemään haluamasi muutokset käyttäessäsi peppiä?"));
			kysymykset.add(new Kysymys("Tuntuiko, että käytit siihen enemmän aikaa kuin olisit halunnut/odottanut?"));
			kysymykset.add(new Kysymys("Tuntuiko, että pepin käyttö helpottui ensimmäisen käyttökerran jälkeen?"));
			kysymykset.add(new Kysymys("Onko järjestelmässä mielestäsi joitakin puutteita? Mitä?"));
			
			kysymykset2.add(new Kysymys("Tämä on testi kysymys yksi"));
			kysymykset2.add(new Kysymys("Tämä on testi kysymys kaksi"));
			kysymykset2.add(new Kysymys("Tämä on testi kysymys kolme"));
			kysymykset2.add(new Kysymys("Tämä on testi kysymys neljä"));
			kysymykset2.add(new Kysymys("Tämä on testi kysymys viisi :)"));
			
			Kysely kysely1 = new Kysely("MyNet Peppi Kysely", kysymykset);
			Kysely kysely2 = new Kysely("Testi kysely", kysymykset2);
			
			kyselyRepository.save(kysely1);
			kyselyRepository.save(kysely2);
			
			// ASETTAA KYSYMYKSILLE OIKEAN KYSELY IDN
			
			for (int i = 0; i < kysymykset.size(); i++) {
				kysymykset.get(i).setKysely(kysely1);
			}
			
			for (int i = 0; i < kysymykset2.size(); i++) {
				kysymykset2.get(i).setKysely(kysely2);
			}
			
			kysymysrepository.saveAll(kysymykset);
			kysymysrepository.saveAll(kysymykset2);
			System.out.println("Tässä kyselyt: " + kyselyRepository.findAll());

		};
	}
}