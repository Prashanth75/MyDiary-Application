package com.project.spring.mydiary.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.spring.mydiary.entities.User;
import com.project.spring.mydiary.dao.UserDaoInterface;

@Component
public class UserBusinessInterfaceImpl implements UserBusinessInterface {
	
	@Autowired
	private UserDaoInterface userDaoInterface;

	public UserDaoInterface getUserInterface() {
		return userDaoInterface;
	}

	public void setUserInterface(UserDaoInterface userDaoInterface) {
		this.userDaoInterface = userDaoInterface;
	}

	@Override
	public void save(User user) {
		userDaoInterface.save(user);

	}

	@Override
	public void update(User user) {
		userDaoInterface.update(user);

	}

	@Override
	public void delete(User user) {
		userDaoInterface.delete(user);

	}

	@Override
	public User findById(int id) {
		return userDaoInterface.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDaoInterface.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userDaoInterface.findByUsername(username);
	}

}
