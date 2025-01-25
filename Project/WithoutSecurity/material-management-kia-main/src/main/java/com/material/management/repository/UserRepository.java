package com.material.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.material.management.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value = "SELECT * FROM mm_db.user WHERE user_name=?1 AND PASSWORD=?2",nativeQuery = true)
	User findByUserNamePassword(String userId,String password);

	User findUserByUserId(Long userId);
}
