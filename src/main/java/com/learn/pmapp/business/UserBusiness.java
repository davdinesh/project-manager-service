/**
 * 
 */
package com.learn.pmapp.business;

import java.util.List;

import com.learn.pmapp.model.User;

/**
 * @author 137499
 *
 */
public interface UserBusiness {
	
	public User save(User user);
	
	public List<User> findAll();

	public User findById(int id);

	public void deleteUser(User emp);

}
