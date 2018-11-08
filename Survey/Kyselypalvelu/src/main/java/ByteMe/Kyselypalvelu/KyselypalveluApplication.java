package ByteMe.Kyselypalvelu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import ByteMe.Kyselypalvelu.Model.Kysely;
import ByteMe.Kyselypalvelu.Model.KyselyRepository;
import ByteMe.Kyselypalvelu.Model.Kysymys;
import ByteMe.Kyselypalvelu.Model.KysymysRepository;

	@SpringBootApplication
	public class KyselypalveluApplication extends SpringBootServletInitializer {
		private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);
	    @Override
	    protected SpringApplicationBuilder configure
	        (SpringApplicationBuilder application) {
	        return application.sources(KyselypalveluApplication.class);
	    }

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(KyselypalveluApplication.class, args);
	    }
	
	
	@Bean
	public CommandLineRunner kyselyDemo(KyselyRepository kyselyRepository, KysymysRepository kysymysrepository) {
		return (args) -> {
			log.info("Hieman testaus dataa");
			
			List<Kysymys> kysymykset = new ArrayList<Kysymys>();
			
			kysymykset.add(new Kysymys("Mihin eri tarkoituksiin olet käyttänyt peppiä? (esim. HOPS, opiskeluohjeet…"));
			kysymykset.add(new Kysymys("Oletko onnistunut tekemään haluamasi käyttäessäsi peppiä?"));
			kysymykset.add(new Kysymys("Tuntuiko, että käytit siihen enemmän aikaa kuin olisit halunnut/odottanut?"));
			kysymykset.add(new Kysymys("Tuntuiko, että pepin käyttö helpottui ensimmäisen käyttökerran jälkeen?"));
			kysymykset.add(new Kysymys("Onko järjestelmässä mielestäsi joitakin puutteita? Mitä?"));
			
			Kysely kysely = new Kysely("MyNet Peppi Kysely", kysymykset);
			
			kyselyRepository.save(kysely);
			kysymysrepository.saveAll(kysymykset);
			System.out.println("Tässä kysely: " + kyselyRepository.findAll());

		};
	}
}