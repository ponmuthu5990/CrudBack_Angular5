package com.demo.crudOperation.DAO;

import java.util.List;

import com.demo.crudOperation.model.User;

public interface UserDAO {

	public void save(User user);
	
	public void update(User user);

	public User getByUserID(Long id);
	
	public List<User> getAllUser();
	
	public boolean deleteUser(Long id);
}
