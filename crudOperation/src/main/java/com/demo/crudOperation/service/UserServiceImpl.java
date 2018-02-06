package com.demo.crudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.crudOperation.DAO.UserDAO;
import com.demo.crudOperation.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void save(User user) {
		userDAO.save(user);


	}

	public void update(User user) {
		userDAO.update(user);

	}

	public User getByUserID(Long id) {
		// TODO Auto-generated method stub
		return userDAO.getByUserID(id);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDAO.getAllUser();
	}

	public boolean deleteUser(Long id) {
		userDAO.deleteUser(id);
		return true;
	}

}
