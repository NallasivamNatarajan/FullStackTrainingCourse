package dummy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.cattle.management.entity.CattleTreatment;

@Repository("cattleTreatmentRepository")
public interface CattleTreatmentRepository extends CrudRepository<CattleTreatment, Integer>{
}
