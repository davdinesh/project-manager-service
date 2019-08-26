/**
 * 
 */
package com.learn.pmapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.dao.UserDao;
import com.learn.pmapp.model.User;
import com.learn.pmapp.repository.UserRepository;

/**
 * @author 137499
 *
 */
@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}

	@Override
	public User findById(int id) {
		return userRepository.getOne(id);
	}

	
}
