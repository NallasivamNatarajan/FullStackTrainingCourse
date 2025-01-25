package com.cattle.management.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cattle.management.entity.CattleTransfer;

@Repository("cattleTransferRepository")
public interface CattleTransferRepository extends CrudRepository<CattleTransfer, Integer> {

	@Query(value = "SELECT * FROM tb_cattle_transfer where cattle_from=:cattleFrom", nativeQuery = true)
	 Set<CattleTransfer> findAllBooksByCattleFrom(String cattleFrom);

	@Query(value = "Update tb_cattle_transfer set transfer_reason=:transferReason where transfer_id=:transferId", nativeQuery = true)
	 void saveTransferReasonToCattle(@Param("transferReason")String transferReason,@Param("transferId")int transferId);

}
