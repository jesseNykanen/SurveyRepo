package ByteMe.Kyselypalvelu.Model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepository extends CrudRepository<Kysely, Long> {

	List<Kysely> findByKyselyNimi (String kyselyNimi);
}
