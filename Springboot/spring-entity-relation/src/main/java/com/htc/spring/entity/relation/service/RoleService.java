package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.RoleRepository;
import com.htc.spring.entity.relation.entity.Role;

@Service("roleService")
public class RoleService {
	@Autowired
	RoleRepository roleRepository;

	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	public void deleteRole(int roleId) {
		roleRepository.deleteById(roleId);
	}

	public Role getRoleById(int roleId) {
		Optional<Role> role = roleRepository.findById(roleId);
		if (role.isPresent())
			return role.get();
		else
			return null;
	}

	public List<Role> getAllRole() {
		return (List<Role>) roleRepository.findAll();
	}

	public int updateRole(Role role) {
		Role roleModel = roleRepository.save(role);
		return roleModel.getRoleId();
	}
}
