package hh.swd2.ekaSpringProjekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd2.ekaSpringProjekti.model.Survey;
import hh.swd2.ekaSpringProjekti.model.SurveyRepository;
import hh.swd2.ekaSpringProjekti.model.Category;
import hh.swd2.ekaSpringProjekti.model.CategoryRepository;

@SpringBootApplication
public class SurveyApplication {
	private static final Logger log = LoggerFactory.getLogger(SurveyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(SurveyRepository bookrepository, CategoryRepository categoryrepository) {
		return (args) -> {

			Category action = new Category("action");
			Category horror = new Category("horror");
			Category documentary = new Category("documentary");
			categoryrepository.save(action);
			categoryrepository.save(horror);
			categoryrepository.save(documentary);

			log.info("save a couple of books");
			bookrepository.save(new Survey(24234L, "Johnson, Long", "Long Johnsons stories about long johnsons", "2011",
					19.95, documentary));
			bookrepository.save(new Survey(1234L, "Treehugger", "Nature preservation", "1950", 9.95, action));
			log.info("find all books");
			for (Survey book : bookrepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
