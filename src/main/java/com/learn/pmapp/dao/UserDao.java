/**
 * 
 */
package com.learn.pmapp.dao;

import java.util.List;

import com.learn.pmapp.model.User;

/**
 * @author 137499
 *
 */
public interface UserDao {

	public User save(User user);
	
	public List<User> findAll();
	
	public void deleteUser(User user);

	public User findById(int id);

}
