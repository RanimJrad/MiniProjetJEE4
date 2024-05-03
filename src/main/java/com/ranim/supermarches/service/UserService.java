package com.ranim.supermarches.service;

import com.ranim.supermarches.entities.Role;
import com.ranim.supermarches.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);

}
