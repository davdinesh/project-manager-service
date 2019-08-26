package com.learn.pmapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.learn.pmapp.ProjManagerApplicationTests;
import com.learn.pmapp.model.User;

public class UserControllerAllTest extends ProjManagerApplicationTests {
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	   @Test
	   public void getAllUsers() throws Exception {
	      String uri = "/user/";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      User[] users = super.mapFromJson(content, User[].class);
	      assertTrue(users.length > 0);
	   }
	   
	/*   @Test
	   public void createUser() throws Exception {
	      String uri = "/user/add";
	      User user = new User();
	      user.setFirstName("Test FirstName");
	      user.setLastName("Test LastName");
	      user.setEmployeeId(9002);
	      String inputJson = super.mapToJson(user);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "User is created successfully");
	   }
	   
	   @Test
	   public void updateUser() throws Exception {
	      String uri = "/user/update/56";
	      User user = new User();
	      user.setFirstName("FirstName Test");
	      user.setLastName("LastName Test");
	      String inputJson = super.mapToJson(user);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "User is updated successsfully");
	   }
	 */

}
