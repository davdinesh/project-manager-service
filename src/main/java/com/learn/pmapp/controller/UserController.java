/**
 * 
 */
package com.learn.pmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.pmapp.business.UserBusiness;
import com.learn.pmapp.model.User;

/**
 * @author 137499
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserBusiness userBusiness;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		//todo - need to check unnique employee id
		return userBusiness.save(user);
	}
	
	@GetMapping("/")
	public List<User> fetchAllUsers() {
		
		return userBusiness.findAll(); 
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") int id, @RequestBody User user) {
		User emp = userBusiness.findById(id);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setFirstName(user.getFirstName());
		emp.setLastName(user.getLastName());
		
		User empUpdated = userBusiness.save(emp);
		
		return ResponseEntity.ok().body(empUpdated);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="id") int id) {
		
		User emp = userBusiness.findById(id);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		userBusiness.deleteUser(emp);
		return ResponseEntity.ok().build();
		
	}
	
}
