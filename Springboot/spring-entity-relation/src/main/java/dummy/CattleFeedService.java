package dummy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.cattle.management.dao.CattleFeedRepository;
import com.htc.cattle.management.entity.CattleFeed;

@Service("cattleFeedService")
public class CattleFeedService {
	@Autowired
	CattleFeedRepository cattleFeedRepository;

	public CattleFeed addCattleFeed(CattleFeed cattleFeed) {
		return cattleFeedRepository.save(cattleFeed);
	}

	public void deleteCattleFeed(int cattleFeedId) {
		cattleFeedRepository.deleteById(cattleFeedId);
	}

	public CattleFeed getCattleFeedById(int cattleFeedId) {
		Optional<CattleFeed> cattleFeed = cattleFeedRepository.findById(cattleFeedId);
		if (cattleFeed.isPresent())
			return cattleFeed.get();
		else
			return null;
	}

	public List<CattleFeed> getAllCattleFeed() {
		return (List<CattleFeed>) cattleFeedRepository.findAll();
	}

	public int updateCattleFeed(CattleFeed cattle) {
		CattleFeed cattleFeed = cattleFeedRepository.save(cattle);
		return cattleFeed.getCattleFeedId();
	}
}