package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.UsersRepository;
import com.htc.spring.entity.relation.entity.Users;

@Service("usersService")
public class UsersService {
	
	@Autowired
	UsersRepository usersRepository;

	public Users addUser(Users user) {
		return usersRepository.save(user);
	}

	public void deleteUser(int userId) {
		usersRepository.deleteById(userId);
	}

	public Users getUserById(int userId) {
		Optional<Users> user = usersRepository.findById(userId);
		if (user.isPresent())
			return user.get();
		else
			return null;
	}

	public List<Users> getAllUsers() {
		return (List<Users>) usersRepository.findAll();
	}

	public int updateUser(Users users) {
		Users userModel = usersRepository.save(users);
		return userModel.getUserId();
	}
}
