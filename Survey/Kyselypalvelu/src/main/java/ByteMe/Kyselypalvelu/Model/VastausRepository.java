package ByteMe.Kyselypalvelu.Model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long>{

	List<Vastaus> findByVastaus (String vastaus);
	
}
