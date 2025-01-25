package dummy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.cattle.management.entity.CattleFeed;

@Repository("cattleFeedRepository")
public interface CattleFeedRepository extends CrudRepository<CattleFeed, Integer> {
}
