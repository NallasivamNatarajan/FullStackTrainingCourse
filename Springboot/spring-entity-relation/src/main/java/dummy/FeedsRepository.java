package dummy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.cattle.management.entity.Feeds;

@Repository("feedsRepository")
public interface FeedsRepository extends CrudRepository<Feeds, Integer>{
}
