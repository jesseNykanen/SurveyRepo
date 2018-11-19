package ByteMe.Kyselypalvelu.Model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository<Kysymys, Long> {

	List<Kysymys> findByKysymys (String kysymys);
	List<Kysymys> findByKysely (Kysely kysely);
}
