package dummy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.cattle.management.entity.Curative;

@Repository("curativeRepository")
public interface CurativeRepository extends CrudRepository<Curative, Integer>{
}
