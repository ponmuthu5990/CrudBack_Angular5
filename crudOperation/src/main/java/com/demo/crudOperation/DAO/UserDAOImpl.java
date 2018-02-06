package com.demo.crudOperation.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.crudOperation.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	public User getByUserID(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	public List<User> getAllUser() {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> userList = query.list();
		return userList;
	}

	public boolean deleteUser(Long id) {
		Session session=sessionFactory.getCurrentSession();
		User user = new User();
		user.setId(id);
		session.delete(user);
		return true;
	}

}
